package com.demo.fileuplode_repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Document;

@Repository
public interface FileUplodeRepositry  extends JpaRepository<Document, Integer>{

}
