package com.api.freetoyz.repository.toyz;

import com.api.freetoyz.services.model.ToyzServiceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface ToyzRepository extends CrudRepository<ToyzRepositoryModel,Integer> {
    ArrayList<ToyzRepositoryModel> findAll();

    Optional<ToyzRepositoryModel> findById(Integer id);


    List<ToyzServiceModel> findByCategories(String category);
}
