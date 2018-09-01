package com.github.sploradorali.explora.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity (
        tableName = "event_agenda_rels",
        primaryKeys = {"eventId", "agendaId"},
        foreignKeys = {
            @ForeignKey(entity = Event.class,
                    parentColumns = "id",
                    childColumns = "eventId",
                    onDelete = CASCADE),
            @ForeignKey(entity = DayAgenda.class,
                    parentColumns = "id",
                    childColumns = "agendaId",
                    onDelete = CASCADE)
        },
        indices = {
                @Index(value = {"eventId", "agendaId"}),
                @Index("agendaId")
        })
public class EventAgendaRel {
    private int eventId;
    private int agendaId;

    public EventAgendaRel() {
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(int agendaId) {
        this.agendaId = agendaId;
    }
}
