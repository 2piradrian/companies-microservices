package com.twopiardrian.companies_crud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String founder;

    private String logo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate foundationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private List<WebSite> websites;

}
