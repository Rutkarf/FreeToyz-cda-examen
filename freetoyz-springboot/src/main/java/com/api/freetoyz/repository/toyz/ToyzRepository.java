package com.api.freetoyz.repository.toyz;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;




public interface ToyzRepository extends CrudRepository<ToyzRepositoryModel,Long> {


    ArrayList<ToyzRepositoryModel> findAll();
}
