package br.com.facef.info.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name ="class")
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    public Class() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome",nullable = false)
    private String nome;



    public Class(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }


}
