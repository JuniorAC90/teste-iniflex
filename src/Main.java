import entidades.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Funcionario> listaDeFuncionarios = new ArrayList<>();
        Funcionario umFuncionario = new Funcionario(
                "Maria",
                LocalDate.of(2000, 10, 18),
                new BigDecimal("2009.44"),
                "Operador");
        listaDeFuncionarios.add(umFuncionario);

        umFuncionario = new Funcionario(
                "João",
                LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"),
                "Operador");
        listaDeFuncionarios.add(umFuncionario);

        umFuncionario = new Funcionario(
                "Caio",
                LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"),
                "Coordenador");
        listaDeFuncionarios.add(umFuncionario);

        umFuncionario = new Funcionario(
                "Miguel",
                LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"),
                "Diretor");
        listaDeFuncionarios.add(umFuncionario);

        umFuncionario = new Funcionario(
                "Alice",
                LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"),
                "Recepcionista");
        listaDeFuncionarios.add(umFuncionario);

        umFuncionario = new Funcionario(
                "Heitor",
                LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"),
                "Operador");
        listaDeFuncionarios.add(umFuncionario);

        umFuncionario = new Funcionario(
                "Arthur",
                LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"),
                "Contador");
        listaDeFuncionarios.add(umFuncionario);

        umFuncionario = new Funcionario(
                "Laura",
                LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"),
                "Gerente");
        listaDeFuncionarios.add(umFuncionario);

        umFuncionario = new Funcionario(
                "Heloísa",
                LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"),
                "Eletricista");
        listaDeFuncionarios.add(umFuncionario);

        umFuncionario = new Funcionario(
                "Helena",
                LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"),
                "Gerente");
        listaDeFuncionarios.add(umFuncionario);

        for (Funcionario f : listaDeFuncionarios) {
            System.out.println(f);
        }

        System.out.println(listaDeFuncionarios.size());

    }
}