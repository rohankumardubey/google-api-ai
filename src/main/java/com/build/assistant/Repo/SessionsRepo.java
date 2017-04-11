package com.build.assistant.Repo;

import com.build.assistant.Model.Attendees;
import com.build.assistant.Model.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sunny on 21/03/17.
 */
@Repository
public interface SessionsRepo extends JpaRepository<Sessions, Long>{
}
