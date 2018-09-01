package com.github.sploradorali.explora.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.github.sploradorali.explora.entities.*;

@Database(entities = {
            Profile.class,
            Event.class,
            Trip.class,
            DayAgenda.class,
            EventAgendaRel.class
        },
        version = 3,
        exportSchema = false)
public abstract class Implementation extends RoomDatabase {
    public abstract Access access();
}
