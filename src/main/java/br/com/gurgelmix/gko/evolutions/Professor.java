package br.com.gurgelmix.gko.evolutions;

import javax.persistence.Column;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

//@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "id")
public class Professor extends Pessoa {


    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "numeroHorasDia", nullable = false)
    private int numeroHorasDia;
    @Column(name = "valorHora", nullable = false)
    private double valorHora;

    public Professor(String titulo, int numeroHorasDia, double valorHora) {
        this.titulo = titulo;
        this.numeroHorasDia = numeroHorasDia;
        this.valorHora = valorHora;
    }

    public Professor(long id, String nome, String cpf, Date dataNascimento, String titulo, int numeroHorasDia, double valorHora) {
        super(id, nome, cpf, dataNascimento);
        this.titulo = titulo;
        this.numeroHorasDia = numeroHorasDia;
        this.valorHora = valorHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroHorasDia() {
        return numeroHorasDia;
    }

    public void setNumeroHorasDia(int numeroHorasDia) {
        this.numeroHorasDia = numeroHorasDia;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
