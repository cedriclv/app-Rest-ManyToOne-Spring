package com.example.workShopJPA.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.workShopJPA.entities.Owner;

@Component
public class OwnersMock {

    private static OwnersMock Instance;
    private List<Owner> carsFirstFeed = new ArrayList<Owner>();

    public static OwnersMock getInstance() {
        if (Instance == null) {
            Instance = new OwnersMock();
        }
        return Instance;
    }

    private OwnersMock() {
        Collections.addAll(
                this.carsFirstFeed,
                new Owner("Cedric"),
                new Owner("Yoann"),
                new Owner("Cyril"));
    }

    public List<Owner> getOwnersFirstFeed() {
        return carsFirstFeed;
    }

    public void setOwnersFirstFeed(List<Owner> carsFirstFeed) {
        this.carsFirstFeed = carsFirstFeed;
    }

}
