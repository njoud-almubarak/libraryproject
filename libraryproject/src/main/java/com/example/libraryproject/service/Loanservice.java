package com.example.libraryproject.service;

import com.example.libraryproject.exeption.InvalidId;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.Loan;
import com.example.libraryproject.model.Myuser;
import com.example.libraryproject.repository.Bookrepo;
import com.example.libraryproject.repository.Loanrepo;
import com.example.libraryproject.repository.Myuserrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Loanservice {
    private final Loanrepo loanrepo;
    private final Bookrepo bookrepo;
    private final Myuserrepo myuserrepo;

    public List<Loan> getloan(){
        return loanrepo.findAll();
    }


    public void addloan(Loan loan){
        loanrepo.save(loan);
    }

/*public List<Loan> lendedbook(Integer bookId){

        Book book=bookrepo.findById(bookId)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        return loanrepo.findAllByBookId(book.getId());
}*/

    public Loan getloanbookbybookid(Integer bid){
        Book book=bookrepo.findById(bid)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        Loan loan=loanrepo.findById(bid).get();
        return loan;}


    public Loan lendedbooksbyuserid(Integer uid){
        Myuser myuser=myuserrepo.findById(uid)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        Loan loan=loanrepo.findById(uid).get();
        return loan;}
    public void checkloanid(Integer id) {
        Loan loan=loanrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
    }
}
