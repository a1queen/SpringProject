package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.NewOrder;

@Repository
public interface OrderRepository extends JpaRepository<NewOrder, Integer> {
}
