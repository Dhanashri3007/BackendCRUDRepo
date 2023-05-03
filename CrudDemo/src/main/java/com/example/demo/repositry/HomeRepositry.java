package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Product__Multifrom;

@Repository
public interface HomeRepositry extends JpaRepository<Product__Multifrom, Integer>{

}
