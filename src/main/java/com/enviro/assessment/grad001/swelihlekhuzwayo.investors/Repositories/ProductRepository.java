package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
