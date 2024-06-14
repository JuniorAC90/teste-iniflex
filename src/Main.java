import entidades.Funcionario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> listaDeFuncionarios = new ArrayList<>();
        String caminhoDoProjeto = System.getProperty("user.dir");
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoProjeto + "/src/funcionarios.csv"))) {
            br.readLine();
            String linha = br.readLine();
            while (linha != null) {
                String[] linhaFuncionario = linha.split(",");
                String nome = linhaFuncionario[0];
                DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascimento = LocalDate.parse(linhaFuncionario[1], formatarData);
                BigDecimal salario = new BigDecimal(linhaFuncionario[2]);
                String funcao = linhaFuncionario[3];
                Funcionario funcionario = new Funcionario(nome, dataNascimento, salario, funcao);
                listaDeFuncionarios.add(funcionario);
                linha = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 3.2 - Remover João da lista
        listaDeFuncionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        // 3.3 - Imprimindo todos os funcionários
        System.out.println("Imprimindo todos os Funcionários: \n");
        System.out.println("Nome\tDataNasc\tSalário\t\tFunção");
        for (Funcionario f : listaDeFuncionarios) {
            System.out.println(f);
        }
        System.out.println("\n---------------------------------------------\n");
        // 3.4 - Aumentar 10% de salário
        for (Funcionario f : listaDeFuncionarios) {
            f.aumentarDezPorCentoDoSalario();
        }

        // 3.5 - Agrupar por Função em Map
        Map<String, List<Funcionario>> funcionariosAgrupados = new HashMap<>();
        for (Funcionario f : listaDeFuncionarios) {
            funcionariosAgrupados.put(f.getFuncao(), new ArrayList<>());
        }
        for (Funcionario f : listaDeFuncionarios) {
            funcionariosAgrupados.get(f.getFuncao()).add(f);
        }

        // 3.6 - Agrupar por Função em Map
        Set<String> funcoes = funcionariosAgrupados.keySet();
        for (String funcao : funcoes) {
            System.out.println("Função: " + funcao);
            System.out.println("Funcionários: ");
            for(Funcionario f : funcionariosAgrupados.get(funcao)) {
                System.out.println(f);
            }
            System.out.println();
        }

        System.out.println("\n---------------------------------------------\n");

        // 3.8 - Imprimindo os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("Funcionários que fazem aniversário no mês 10 e 12:");
        for(Funcionario f : listaDeFuncionarios) {
            if (f.getDataNascimento().getMonth().equals(Month.OCTOBER) || f.getDataNascimento().getMonth().equals(Month.DECEMBER)) {
                System.out.println(f);
            }
        }

        System.out.println("\n---------------------------------------------\n");

        // 3.9 - Imprimindo o funcionário com a maior idade
        System.out.println("Funcionário com a maior idade:");
        for (Funcionario f : listaDeFuncionarios) {
            if (f.calculaIdade() == f.getMaiorIdade()) {
                System.out.println("Nome: " + f.getNome() + "\t" + "Idade: " + f.calculaIdade());
            }

        }

        System.out.println("\n---------------------------------------------\n");

        // 3.10 Imprimindo todos os funcionários em ordem alfabética
        System.out.println("Funcionários em Ordem Alfabética: \n");
        System.out.println("Nome\tDataNasc\tSalário\t\tFunção");
        Collections.sort(listaDeFuncionarios);
        for (Funcionario f : listaDeFuncionarios) {
            System.out.println(f);
        }

        System.out.println("\n---------------------------------------------\n");

        // 3.11 Imprimindo o total dos salários dos funcionários.
        NumberFormat formatadorSalario = new DecimalFormat("#,###.##");
        formatadorSalario.setMinimumFractionDigits(2);
        BigDecimal totalDosSalarios = listaDeFuncionarios
                .stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários dos funcionários: " + formatadorSalario.format(totalDosSalarios));

        System.out.println("\n---------------------------------------------\n");

        // 3.11 Imprimindo quantos salários mínimos ganha cada funcionário
        System.out.println("Funcionários em Ordem Alfabética: \n");
        System.out.println("Nome\tQuantidade de Salários mínimos");

        for (Funcionario f : listaDeFuncionarios) {
            System.out.println(f.getNome() + "\t" + f.quantiodadeDeSalariosMinimos());
        }

    }
}