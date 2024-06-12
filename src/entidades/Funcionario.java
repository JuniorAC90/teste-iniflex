package entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    private static BigDecimal totalDosSalarios = new BigDecimal("0");

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

    public String getFuncao() {
        return funcao;
    }

    public void aumentarDezPorCentoDoSalario() {
        BigDecimal dezPorCento = this.salario.multiply(new BigDecimal("0.10"));
        this.salario = this.salario.add(dezPorCento).setScale(2, RoundingMode.HALF_UP);
    }

    public String quantiodadeDeSalariosMinimos() {
        Double valor = this.salario.doubleValue() / 1212.00;
        return String.format("%.2f", valor);
    }

    @Override
    public String toString() {
        formatadorSalario.setMinimumFractionDigits(2);
        return this.getNome() + "\t"
                + this.getDataNascimento().format(formatadorData) + "\t"
                + formatadorSalario.format(salario) + "\t"
                + funcao;
    }
}
