package br.com.facef.info.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name ="student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public List<Class> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Class> studentList) {
        this.studentList = studentList;
    }

    @ManyToMany(mappedBy = "studentList")
    private List<Class> studentList;


    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;

    public Student(int id, String nome, String cpf, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
