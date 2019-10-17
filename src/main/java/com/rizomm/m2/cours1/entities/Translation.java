package com.rizomm.m2.cours1.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Validated
public class Translation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String language;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "entry_id")
    private List<Entry> entries;

}
