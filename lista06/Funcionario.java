/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package q1.lista06;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author molle
 */
public class Funcionario {

    private String nome = "a";
    private double salario = 0;
    private double imposto;

    public Funcionario(String nome, double salario) throws IllegalArgumentException {
        setNome(nome);
        setSalario(salario);
        calcularIrpf();
    }

    public Funcionario() {
        Funcionario vetor[] = new Funcionario[5];
        boolean erro = true;
        for (int i = 0; i < 5; i++) {
            Funcionario novo = new Funcionario(nome, salario);
            do {
                try {
                    novo.setNome(JOptionPane.showInputDialog("Nome do funcionário: "));
                    erro = false;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } while (erro);
            erro = true;
            do {
                try {
                    novo.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Salário do Funcionário: ")));
                    novo.calcularIrpf();
                    erro = false;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } while (erro);
            vetor[i] = novo;
        }

        for (int u = 0; u < 5; u++) {
            JOptionPane.showMessageDialog(null, "funcionário: " + vetor[u].getNome() + "\nImposto: " + vetor[u].getImposto());
        }

        //perguntar se há como imprimir em lista com JOptionPane
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("O salário não pode ser menor do que zero");
        }
        this.salario = salario;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double calcularIrpf() {
        FaixaIrpf faixa = identificarFaixaIrpf();
        switch (faixa) {
            case QUINTA:
                imposto = (getSalario() - 4664.68) * 0.275 + 205.56675 + 138.66 + 69.20;
                break;
            case QUARTA:
                imposto = (getSalario() - 3751.05) * 0.225 + 138.66 + 69.20;
                break;
            case TERCEIRA:
                imposto = (getSalario() - 2826.65) * 0.15 + 69.20;
                break;
            case SEGUNDA:
                imposto = (getSalario() - 1903.98) * 0.075;
                break;
            case PRIMEIRA:
                imposto = 0;
                break;
        }
        return imposto;
    }

    public FaixaIrpf identificarFaixaIrpf() {
        if (getSalario() >= 4664.69) {
            return FaixaIrpf.QUINTA;
        } else if (getSalario() >= 3751.06 && getSalario() <= 4664.68) {
            return FaixaIrpf.QUARTA;
        } else if (getSalario() >= 2826.66 && getSalario() <= 3751.05) {
            return FaixaIrpf.TERCEIRA;
        } else if (getSalario() >= 1903.99 && getSalario() <= 2826.65) {
            return FaixaIrpf.SEGUNDA;
        } else {
            return FaixaIrpf.PRIMEIRA;
        }
    }

    public static void main(String[] args) {
        Funcionario f = new Funcionario("Ana", 200);
        double imposto = f.calcularIrpf();
        DecimalFormat df = new DecimalFormat("0.00");

    }
}

/*

import java.util.Scanner;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class App {

    private Funcionario[] funcionarios;
    private int quantidadeFuncionarios;

    public App() {
        Scanner entrada = new Scanner(System.in);
        funcionarios = new Funcionario[5];

        int comando = 0;
        do {
            String retorno = JOptionPane.showInputDialog("Digite o comando para calcular o seu IRPF(imposto de renda): " + 
            " \n1 - Nome\n" + 
            "2 - Salario\n" + 
            "3 - Encerrar programa");

            comando = Integer.parseInt(retorno);

            switch(comando) {
                case 1: criarNome();
                    break;

                case 2: calcularImposto();
                    break;

                case 3: System.out.println("Encerrando programa.....");
                    break;

                default: JOptionPane.showMessageDialog(null, "Opção de ação inválida");
                    break;
            }

            entrada.close(); 

        } while (comando != 3);  
    }
    private void calcularImposto() {
        String nomeFuncionario = JOptionPane.showInputDialog("Informe o seu nome: ");
        Funcionario funcionario = buscar(nomeFuncionario);

        DecimalFormat df = new DecimalFormat("0.00");

        if (funcionario != null) {
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do seu salario: "));
        funcionario.setSalario(salario);
        JOptionPane.showMessageDialog(null, "Imposto: " + df.format(funcionario.calcularIrpf(salario)));
        } else {
            JOptionPane.showMessageDialog(null, "Nome de funcionario não existe");
        }
    }

    private void criarNome() {
        String nomeFuncionario = JOptionPane.showInputDialog("Insira o seu nome: ");

        if (buscar(nomeFuncionario) == null && quantidadeFuncionarios < funcionarios.length) {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nomeFuncionario);
            funcionarios[quantidadeFuncionarios] = funcionario;
            quantidadeFuncionarios++; 
        }
    }

    private Funcionario buscar(String nomeFuncionario) {
        for (Funcionario c: funcionarios) {
            if (c != null && c.getNome().trim().equalsIgnoreCase(nomeFuncionario)) {
                return c;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        new App();
    }
}*/