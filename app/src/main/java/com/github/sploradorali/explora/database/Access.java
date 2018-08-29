package com.github.sploradorali.explora.database;

import android.arch.persistence.room.*;
import com.github.sploradorali.explora.entities.Profiles;

@Dao
public interface Access {
    @Insert
    void insertSingleProfile(Profiles profile);
    @Insert
    void insertMultipleProfiles(Profiles profiles);
    @Query("SELECT * FROM Profiles WHERE profileId = :profileId")
    Profiles fetchSingleProfileById(int profileId);
    @Update
    void updateProfile(Profiles profile);
    @Delete
    void deleteProfile(Profiles profile);
    @Query("DELETE FROM Profiles")
    void clearProfiles();
}
