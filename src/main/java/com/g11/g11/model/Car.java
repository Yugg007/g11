package com.g11.g11.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String variant;
    private double price;
    private int year;
    private double kilometers;
    private int bodycondition;
    private int wheelcondition;
    private int enginecondition;
    private int batterycondition;
    private int overallcondition;
    
    public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getKilometers() {
		return kilometers;
	}
	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}
	public int getBodyCondition() {
		return bodycondition;
	}
	public void setBodyCondition(int bodyCondition) {
		this.bodycondition = bodyCondition;
	}
	public int getWheelCondition() {
		return wheelcondition;
	}
	public void setWheelCondition(int wheelCondition) {
		this.wheelcondition = wheelCondition;
	}
	public int getEngineCondition() {
		return enginecondition;
	}
	public void setEngineCondition(int engineCondition) {
		this.enginecondition = engineCondition;
	}
	public int getBatteryCondition() {
		return batterycondition;
	}
	public void setBatteryCondition(int batteryCondition) {
		this.batterycondition = batteryCondition;
	}
	public int getOverallCondition() {
		return overallcondition;
	}
	public void setOverallCondition(int overallCondition) {
		this.overallcondition = overallCondition;
	}
	public void addVariable(String model, String variant, double price, int year, double kilometers,
			int bodyCondition, int wheelCondition, int engineCondition, int batteryCondition,
			int overallCondition) {
		this.model = model;
		this.variant = variant;
		this.price = price;
		this.year = year;
		this.kilometers = kilometers;
		this.bodycondition = bodyCondition;
		this.wheelcondition = wheelCondition;
		this.enginecondition = engineCondition;
		this.batterycondition = batteryCondition;
		this.overallcondition = overallCondition;
	}

    // Constructors, getters, and setters
}

