package com.lenscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscart.entity.SunGlasses;

@Repository
public interface SunGlassRepository extends JpaRepository<SunGlasses, Integer> {

}
