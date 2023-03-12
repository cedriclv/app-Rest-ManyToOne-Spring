package com.example.workShopJPA.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.example.workShopJPA.entities.Car;
import com.example.workShopJPA.entities.Owner;

@Component
public class CarsMock {

    private List<Car> carsFirstFeed = new ArrayList<Car>();

    public CarsMock() {
        OwnersMock ownersMock = OwnersMock.getInstance();

        List<Owner> owners = ownersMock.getOwnersFirstFeed();
        int sizeOwnersList = owners.size();

        Collections.addAll(
                this.carsFirstFeed,
                new Car("renault", "clio", owners.get(new Random().nextInt(0, sizeOwnersList - 1))),
                new Car("renault", "megane", owners.get(new Random().nextInt(0, sizeOwnersList - 1))),
                new Car("peugeot", "308", owners.get(new Random().nextInt(0, sizeOwnersList - 1))));
    }

    public List<Car> getCarsFirstFeed() {
        return carsFirstFeed;
    }

    public void setCarsFirstFeed(List<Car> carsFirstFeed) {
        this.carsFirstFeed = carsFirstFeed;
    }

}
