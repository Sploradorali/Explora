package com.github.sploradorali.explora.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.github.sploradorali.explora.entities.Profiles;

@Database(entities =  {Profiles.class}, version = 2, exportSchema = false)
public abstract class Implementation extends RoomDatabase {

    public abstract Access access();
}
