package com.example.libraryproject.repository;

import com.example.libraryproject.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Loanrepo extends JpaRepository<Loan,Integer> {


 //List<Loan> findAllByBookId(Integer bookId);



}
