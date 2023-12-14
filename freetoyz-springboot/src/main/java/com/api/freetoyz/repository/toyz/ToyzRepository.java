package com.api.freetoyz.repository.toyz;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;




@Repository
public interface ToyzRepository extends CrudRepository<ToyzRepositoryModel,Long> {
    ArrayList<ToyzRepositoryModel> findAll();
}
