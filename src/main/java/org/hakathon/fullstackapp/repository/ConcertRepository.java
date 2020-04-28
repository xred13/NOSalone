package org.hakathon.fullstackapp.repository;

import org.hakathon.fullstackapp.model.Concert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConcertRepository extends CrudRepository<Concert, Long> {



}
