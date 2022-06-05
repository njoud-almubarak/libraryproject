package com.example.libraryproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Loan {
    @Id
    @NotEmpty(message = "id is required")
    private Integer id;
    @Column(nullable = false)
    @NotEmpty(message = "id is required")
    private Integer userid;
    @Column(nullable = false)
    @NotEmpty(message = "id is required")
    private Integer bookid;


    @ManyToMany(cascade = CascadeType.ALL)

    private Set<Book> books;
}
