package com.klef.fsad.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.fsad.exam.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{

}