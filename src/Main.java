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

        for (Funcionario f : listaDeFuncionarios) {
            System.out.println(f);
        }

    }
}