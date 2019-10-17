package com.rizomm.m2.cours1.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Validated
public class Entry {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String key;

    private String value;

    @ManyToOne
    @JsonIgnore
    private Translation translation;

}
