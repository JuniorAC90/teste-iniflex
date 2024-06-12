package entidades;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private LocalDate dataNascimento;

    private static int maiorIdade = 0;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;

        if (maiorIdade == 0) {
            maiorIdade = this.calculaIdade();
        } else {
            if (maiorIdade < this.calculaIdade()) {
                maiorIdade = this.calculaIdade();
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public int calculaIdade() {
        if (this.dataNascimento == null) {
            return 0;
        }
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public int getMaiorIdade() {
        return maiorIdade;
    }

    public int compareTo(Pessoa p) {
        return this.getNome().compareTo(p.getNome());
    }

}
