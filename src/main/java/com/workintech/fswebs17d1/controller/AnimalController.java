package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void loadAll() {
        this.animals = new HashMap<>();
        this.animals.put(1, new Animal(1, "Cat"));
    }

    @GetMapping
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable("id") Integer id) {
        return this.animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable("id") Integer id, @RequestBody Animal animal) {
        animals.replace(id, animal);
        return animals.get(id);

    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable Integer id) {
        Animal animal = animals.get(id);
        animals.remove(animal);
        return animal;
    }
}
