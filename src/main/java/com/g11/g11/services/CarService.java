package com.g11.g11.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g11.g11.model.Car;
import com.g11.g11.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository cr;

	public List<Car> getAllCars() {
		return (List<Car>) cr.findAll();
	}

	public void insertCar(Car car) {
		cr.save(car);
	}

	public void deleteById(int i) {
		Car carToDelete = cr.findByid(i); // Replace with your own logic to find the entity to delete
		if (carToDelete != null) {
			cr.delete(carToDelete);
		}		
	}
}
