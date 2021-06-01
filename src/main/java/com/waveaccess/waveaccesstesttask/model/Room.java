package com.waveaccess.waveaccesstesttask.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room extends AbstractNamedEntity {

    public Room() {
    }

    public Room(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
