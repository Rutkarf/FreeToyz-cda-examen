package com.api.freetoyz.repository;

import com.api.freetoyz.repository.security.OwnerRepositoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnerRepository extends CrudRepository<OwnerRepositoryModel, Integer> {
    OwnerRepositoryModel findByLogin(String login);
}
