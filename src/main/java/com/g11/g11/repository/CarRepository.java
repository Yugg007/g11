package com.g11.g11.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g11.g11.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByModel(String model);
    List<Car> findByVariant(String variant);
    List<Car> findByPriceBetween(double minPrice, double maxPrice);
    List<Car> findByYear(int year);
    List<Car> findByKilometersLessThan(double maxKilometers);
	Car findByid(int i);
}
