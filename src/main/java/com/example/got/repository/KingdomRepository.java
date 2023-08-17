package com.example.got.repository;

import com.example.got.entity.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KingdomRepository extends JpaRepository<Kingdom, Integer> {

}