package com.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.UserLogin;

@Repository
public interface HomeRepositry  extends JpaRepository<UserLogin, Integer>{

}
