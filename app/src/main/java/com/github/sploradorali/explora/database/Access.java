package com.github.sploradorali.explora.database;

import android.arch.persistence.room.*;
import com.github.sploradorali.explora.entities.*;

@Dao
public interface Access {
    /*
    * Profile Access
    */
    @Insert
    void insertSingleProfile(Profile profile);
    @Insert
    void insertMultipleProfiles(Profile profiles);
    @Query("SELECT * FROM profiles WHERE id = :profileId")
    Profile fetchSingleProfileById(int profileId);
    @Update
    void updateProfile(Profile profile);
    @Delete
    void deleteProfile(Profile profile);
    @Query("DELETE FROM profiles")
    void clearProfiles();

    /*
    * Event Access
    */
    @Insert
    void insertSingleEvent(Event event);
    @Insert
    void insertMultipleEvents(Event events);
    @Query("SELECT * FROM events WHERE id = :eventId")
    Event fetchSingleEventById(int eventId);
    @Update
    void updateEvent(Event event);
    @Delete
    void deleteEvent(Event event);
    @Query("DELETE FROM events")
    void clearEvents();

    /*
    * Trip Access
    */
    @Insert
    void insertSingleTrip(Trip trip);
    @Insert
    void insertMultipleTrips(Trip trips);
    @Query("SELECT * FROM trips WHERE id = :tripId")
    Trip fetchSingleTripById(int tripId);
    @Update
    void updateTrip(Trip trip);
    @Delete
    void deleteTrip(Trip trip);
    @Query("DELETE FROM trips")
    void clearTrips();

    /*
    * DayAgenda Access
    */
    @Insert
    void insertSingleDayAgenda(DayAgenda dayAgenda);
    @Insert
    void insertMultipleDayAgendas(DayAgenda dayAgendas);
    @Query("SELECT * FROM day_agendas WHERE id = :dayAgendaId")
    DayAgenda fetchSingleDayAgendaById(int dayAgendaId);
    @Update
    void updateDayAgenda(DayAgenda dayAgenda);
    @Delete
    void deleteDayAgenda(DayAgenda dayAgenda);
    @Query("DELETE FROM day_agendas")
    void clearDayAgendas();

    /*
    * EventAgendaRel Access
    */
    @Insert
    void insertSingleEventAgendaRel(EventAgendaRel eventAgendaRel);
    @Insert
    void insertMultipleEventAgendaRels(EventAgendaRel eventAgendaRels);
    @Query("SELECT * FROM event_agenda_rels WHERE eventId = :eventId")
    EventAgendaRel[] fetchEventAgendaRelsByEventId(int eventId);
    @Query("SELECT * FROM event_agenda_rels WHERE agendaId = :agendaId")
    EventAgendaRel[] fetchEventAgendaRelsByAgendaId(int agendaId);
    @Query("SELECT * FROM event_agenda_rels WHERE eventId = :eventId AND agendaId = :agendaId")
    EventAgendaRel fetchSingleEventAgendaRelByIds(int eventId, int agendaId);
    @Update
    void updateEventAgendaRel(EventAgendaRel eventAgendaRel);
    @Delete
    void deleteEventAgendadRel(EventAgendaRel eventAgendaRel);
    @Query("DELETE FROM event_agenda_rels")
    void clearEventAgendaRels();
}
