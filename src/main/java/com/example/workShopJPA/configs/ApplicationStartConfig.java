package com.example.workShopJPA.configs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workShopJPA.entities.Car;
import com.example.workShopJPA.entities.Owner;
import com.example.workShopJPA.models.CarsMock;
import com.example.workShopJPA.models.OwnersMock;
import com.example.workShopJPA.repositories.CarRepository;
import com.example.workShopJPA.repositories.OwnerRepository;

@Configuration
public class ApplicationStartConfig implements CommandLineRunner {

    @Autowired
    CarRepository carRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public void run(String... args) throws Exception {
        OwnersMock ownersMock = OwnersMock.getInstance();
        List<Owner> initialOwners = ownersMock.getOwnersFirstFeed();
        for (Owner owner : initialOwners) {
            System.out.println(owner.getName());
            ownerRepository.save(owner);
        }

        CarsMock carsMock = new CarsMock();
        List<Car> initialCars = carsMock.getCarsFirstFeed();
        Car car = initialCars.get(0);
        carRepository.save(car);

        Optional<Car> carfound = carRepository.findById(car.getId());
        if (carfound.isPresent()) {
            Car car1 = carfound.get();
            System.out.println("//////brand/////" + car1.getBrand());
            System.out.println("//////MODEL/////" + car1.getModel());
            System.out.println("//////OWNER/////" + car1.getOwner().getName());
            // Car car2 = carRepository.findById(car1.getId()).get();
            Car car2 = carRepository.findAll().get(0);
            System.out.println("//////brand/////" + car2.getBrand());
            System.out.println("//////MODEL/////" + car2.getModel());
            System.out.println("//////OWNER/////" + car2.getOwner().getName());
        }
        // for (Car car : initialCars) {
        // carRepository.save(car);
        // }

    }

}
