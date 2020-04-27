package org.hakathon.fullstackapp.repository;

import org.hakathon.fullstackapp.model.Fan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface FanRepository extends CrudRepository<Fan, Long> {
}
