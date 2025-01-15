package com.teles.basicProject.repositories;

import com.teles.basicProject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
