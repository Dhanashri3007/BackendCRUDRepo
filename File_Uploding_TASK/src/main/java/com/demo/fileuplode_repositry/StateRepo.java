package com.demo.fileuplode_repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.State;
@Repository
public interface StateRepo extends JpaRepository<State, Integer> {

	List<State> findByState(String state);

}
