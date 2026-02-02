package com.example.springBootJPA.Repository;

import com.example.springBootJPA.Entity.Brothers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BRepository extends JpaRepository<Brothers,Integer> {
}
