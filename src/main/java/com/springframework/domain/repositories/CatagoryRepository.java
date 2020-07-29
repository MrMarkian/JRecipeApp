package com.springframework.domain.repositories;

import com.springframework.domain.Catagory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CatagoryRepository extends CrudRepository<Catagory, Long> {

    Optional<Catagory> findByDescription(String descrtiption);

}

