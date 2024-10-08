package com.przemyslawren.gymguide.controller;

import com.przemyslawren.gymguide.dto.DetailExerciseDto;
import com.przemyslawren.gymguide.dto.ExerciseGridDto;
import com.przemyslawren.gymguide.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/exercises")
@CrossOrigin
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping
    public ExerciseGridDto getPagedExercises(
            @PageableDefault(size = 20, sort = "name") Pageable pageable,
            @RequestParam(required = false) String name) {

        return exerciseService.searchExercises(name, pageable);
    }

    @GetMapping("/detail")
    public DetailExerciseDto getExercise(@RequestParam String id) {
        return exerciseService.getExercise(id);
    }
}