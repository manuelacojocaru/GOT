package com.example.got.repository;

import com.example.got.entity.Dragon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DragonRepository extends JpaRepository<Dragon, Integer> {

}
