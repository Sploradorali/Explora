package com.github.sploradorali.explora.activities;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.github.sploradorali.explora.R;
import com.github.sploradorali.explora.database.Access;
import com.github.sploradorali.explora.database.Implementation;
import com.github.sploradorali.explora.entities.Profiles;

public class HomeActivity extends AppCompatActivity {

    public static final String DATABASE_NAME = "explora_db";
    private Implementation dbImplementation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button testBtn = findViewById(R.id.test_btn);
        final EditText editText = findViewById(R.id.test_output);

        // Initializes DB
        dbImplementation = Room.databaseBuilder(getApplicationContext(),
                Implementation.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                dbImplementation.access().clearProfiles();
            }
        }).start();

        /* TEST - Adds a profile with an ID of 0 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                Profiles profile = new Profiles();
                profile.setUserName("example");
                dbImplementation.access().insertSingleProfile(profile);
            }
        }).start();

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Profiles selected = dbImplementation.access().fetchSingleProfileById(0);
                            editText.setText(
                                    "ID: " +
                                            selected.getProfileId()
                                            + "\n"
                                            + "Username: " +
                                            selected.getUserName()
                            );
                        } catch (NullPointerException npe) {
                            sendToast("Unable to find profile.", Toast.LENGTH_LONG);
                        }
                    }
                }).start();
            }
        });
    }

    public void sendToast(final String message, final int duration) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, duration).show();
            }
        });
    }
}
