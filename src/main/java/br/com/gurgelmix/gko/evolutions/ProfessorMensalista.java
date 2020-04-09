package br.com.gurgelmix.gko.evolutions;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

//@Entity
@Table(name = "professorMensalista")
public class ProfessorMensalista extends Professor {

    @Column(name = "numeroDiaMes",nullable = false)
    private int numeroDiaMes;


    public ProfessorMensalista(String titulo, int numeroHorasDia, double valorHora, int numeroDiaMes) {
        super(titulo, numeroHorasDia, valorHora);
        this.numeroDiaMes = numeroDiaMes;
    }

    public ProfessorMensalista(long id, String nome, String cpf, Date dataNascimento, String titulo, int numeroHorasDia, double valorHora, int numeroDiaMes) {
        super(id, nome, cpf, dataNascimento, titulo, numeroHorasDia, valorHora);
        this.numeroDiaMes = numeroDiaMes;
    }

    public int getNumeroDiaMes() {
        return numeroDiaMes;
    }

    public void setNumeroDiaMes(int numeroDiaMes) {
        this.numeroDiaMes = numeroDiaMes;
    }
}
