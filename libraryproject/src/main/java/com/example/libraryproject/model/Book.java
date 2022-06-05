package com.example.libraryproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @NotEmpty(message = "id is required")
    private Integer id;
    @Column(nullable = false)
    @NotEmpty(message = "name is required")
    private String name;
    @Column(nullable = false)
    @NotEmpty(message = "genre is required")
    private String genre;




    @ManyToMany(mappedBy = "books",cascade =CascadeType.ALL)
    @JsonIgnore
    private Set<Loan> loan;

}
