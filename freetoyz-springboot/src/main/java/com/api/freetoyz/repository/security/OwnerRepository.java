package com.api.freetoyz.repository.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OwnerRepository extends CrudRepository<OwnerRepositoryModel, Integer> {
    OwnerRepositoryModel findByEmail(String Email);
}
