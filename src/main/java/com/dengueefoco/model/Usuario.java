package com.dengueefoco.model;

import javax.persistence.*;

@Entity
@Table(name = "uaurio")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
