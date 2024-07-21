package com.przemyslawren.gymguide.repository;

import com.przemyslawren.gymguide.model.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {

    @Query("{name:'?0'}")
    Exercise findExerciseByName(String name);
}
