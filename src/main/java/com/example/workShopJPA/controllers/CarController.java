package com.example.workShopJPA.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workShopJPA.entities.Car;
import com.example.workShopJPA.entities.Owner;
import com.example.workShopJPA.repositories.CarRepository;
import com.example.workShopJPA.repositories.OwnerRepository;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping("")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @PostMapping("")
    public Car createCar(String brand, String model, @RequestParam(required = false) String ownerName) {
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        if (ownerName != null && ownerRepository.findByName(ownerName).size() != 0) {
            Owner owner = ownerRepository.findByName(ownerName).get(0);
            car.setOwner(owner);
        }
        return carRepository.save(car);
    }

    @PutMapping("")
    public Car updateCar(Long id, @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model, @RequestParam(required = false) String ownerName) {
        Car car = new Car();
        if (carRepository.findById(id).isPresent()) {
            car = carRepository.findById(id).get();
            if (brand != null) {
                car.setBrand(brand);
            }
            if (model != null) {
                car.setModel(model);
            }
            if (ownerName != null && ownerRepository.findByName(ownerName).size() != 0) {
                Owner owner = ownerRepository.findByName(ownerName).get(0);
                car.setOwner(owner);
            }
        }
        return carRepository.save(car);
    }

    @DeleteMapping("")
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @GetMapping("/brand")
    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

}
