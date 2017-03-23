package com.build.assistant.Repo;

import com.build.assistant.Model.Attendees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sunny on 21/03/17.
 */
@Repository
public interface AttendeeRepo extends JpaRepository<Attendees, Long>{
    Attendees findByTicketNumber(String ticketNumber);
}
