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
public class BookService {
    private final Bookrepo bookrepo;
    private final Loanrepo loanrepo;
    private final Myuserrepo myuserrepo;

    public List<Book> getbook(){
        return bookrepo.findAll();
    }


    public void addbook(Book book){
        bookrepo.save(book);
    }

    public void lendbook(Integer uid,Integer bid){
        Book book=bookrepo.findById(bid)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        Myuser myuser=myuserrepo.findById(uid)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        Loan l1=new Loan(null,uid,bid,null);
        loanrepo.save(l1);
    }
    //this methode to return all book is lended by book id..
   /* public List<Loan> lendedbook(Integer bookId){

        Book book=bookrepo.findById(bookId)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        return loanrepo.findAllByBookId(book.getId());
    }*///



    public void checkbookid(Integer id) {
        Book book=bookrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
    }
}
