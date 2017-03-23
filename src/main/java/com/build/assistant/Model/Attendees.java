package com.build.assistant.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sunny on 21/03/17.
 */
@Entity
@Table(name = "attendees_details")
public class Attendees {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ticket_number")
    private String ticketNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
