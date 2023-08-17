package com.example.got.repository;

import com.example.got.entity.WhiteWalker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiteWalkerRepository extends JpaRepository<WhiteWalker, Integer> {

}