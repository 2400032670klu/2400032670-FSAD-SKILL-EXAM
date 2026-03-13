package com.klef.fsad.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.exam.entity.Restaurant;
import com.klef.fsad.exam.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repo;

    public Restaurant insert(Restaurant r)
    {
        return repo.save(r);
    }
}