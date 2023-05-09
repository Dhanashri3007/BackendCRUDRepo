package com.demo.fileuplode_repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

	List<Address> findAllByCountry(String country);

}
