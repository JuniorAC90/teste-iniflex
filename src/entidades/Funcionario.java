package entidades;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    private final DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final NumberFormat formatadorSalario = new DecimalFormat("#,###.##");

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionario { " + "\n" +
                "Nome:"+ this.getNome() + "\n" +
                "Data Nascimento:"+ this.getDataNascimento().format(formatadorData) + "\n" +
                "Salário: " + formatadorSalario.format(salario) + "\n" +
                "Função: " + funcao + "\n" +
                '}';
    }
}
