package com.example.workShopJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.workShopJPA.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    public List<Owner> findByName(String name);
}
