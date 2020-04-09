package br.com.gurgelmix.gko.evolutions;

import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

//@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Aluno extends Pessoa {

    private int matricula;

    public Aluno(){
        /*
        Construtor padrão
         */
    }

    public Aluno(int matricula) {
        this.matricula = matricula;
    }

    public Aluno(long id, String nome, String cpf, Date dataNascimento, int matricula) {
        super(id, nome, cpf, dataNascimento);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
