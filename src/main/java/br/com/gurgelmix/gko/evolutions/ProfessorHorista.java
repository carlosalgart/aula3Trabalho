package br.com.gurgelmix.gko.evolutions;

import javax.persistence.Table;
import java.util.Date;

//@Entity
@Table(name = "professorHorista")
public class ProfessorHorista extends Professor{

    public ProfessorHorista(String titulo, int numeroHorasDia, double valorHora) {
        super(titulo, numeroHorasDia, valorHora);
    }

    public ProfessorHorista(long id, String nome, String cpf, Date dataNascimento, String titulo, int numeroHorasDia, double valorHora) {
        super(id, nome, cpf, dataNascimento, titulo, numeroHorasDia, valorHora);
    }
}
