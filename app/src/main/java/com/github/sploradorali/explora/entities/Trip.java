package com.github.sploradorali.explora.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity (
        tableName = "trips",
        foreignKeys = @ForeignKey(
                entity = Profile.class,
                parentColumns = "id",
                childColumns = "profileId",
                onDelete = CASCADE
        ),
        indices = @Index("profileId")
        )
public class Trip {
    @PrimaryKey (autoGenerate = true)
    private int id;
    private int profileId;
    private String title;
    private String description;
    private long startTimeInEpochMillis;
    private long durationInMillis;

    public Trip() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStartTimeInEpochMillis() {
        return startTimeInEpochMillis;
    }

    public void setStartTimeInEpochMillis(long startTimeInEpochMillis) {
        this.startTimeInEpochMillis = startTimeInEpochMillis;
    }

    public long getDurationInMillis() {
        return durationInMillis;
    }

    public void setDurationInMillis(long durationInMillis) {
        this.durationInMillis = durationInMillis;
    }
}
