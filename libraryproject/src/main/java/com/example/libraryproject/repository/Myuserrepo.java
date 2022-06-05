package com.example.libraryproject.repository;

import com.example.libraryproject.model.Myuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Myuserrepo extends JpaRepository<Myuser,Integer> {

}
