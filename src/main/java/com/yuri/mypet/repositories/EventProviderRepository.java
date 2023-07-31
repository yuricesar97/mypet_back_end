package com.yuri.mypet.repositories;

import com.yuri.mypet.domain.EventProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventProviderRepository extends JpaRepository<EventProvider, Integer> {

    EventProvider findByTitle(String title);
/** 
    @Query("SELECT b " +
            "FROM EventProvider b " +
            "WHERE b.start >= ?1 " +
            "AND b.finish <=?2")
            */
     EventProvider  findByStart(String start);

     EventProvider findByEnd(String end);
}
