package com.example.desafio.supplier.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.supplier.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}