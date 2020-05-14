package org.hakathon.fullstackapp.repositories;

import org.hakathon.fullstackapp.models.Concert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Calendar;
import java.util.Collection;

@RepositoryRestResource
public interface ConcertRepository extends CrudRepository<Concert, Long> {

    default Collection<Concert> findByMusicGenreWithUpcomingPerformanceDate(String genre){
        return findByMusicGenreAndPerformanceDateIsAfter(genre, Calendar.getInstance());
    }

    Collection<Concert> findByMusicGenreAndPerformanceDateIsAfter(String genre, Calendar date);

}
