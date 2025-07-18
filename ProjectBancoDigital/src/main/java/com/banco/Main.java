package com.banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta contaCorrente = null;
        Conta contaPoupanca = null;
        Cliente cliente = null;

        int opcao;
        do {
            System.out.println("\n=== Menu Banco Digital ===");
            System.out.println("1. Criar Cliente e Contas");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Imprimir Extrato Conta Corrente");
            System.out.println("6. Imprimir Extrato Conta Poupança");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    scanner.nextLine(); // Consumir a nova linha
                    String nomeCliente = scanner.nextLine();
                    cliente = new Cliente();
                    cliente.setNome(nomeCliente);
                    contaCorrente = new ContaCorrente(cliente);
                    contaPoupanca = new ContaPoupanca(cliente);
                    System.out.println("Cliente e contas criados com sucesso!");
                    System.out.println("Conta Corrente: Agência " + contaCorrente.getAgencia() + ", Número " + contaCorrente.getNumero());
                    System.out.println("Conta Poupança: Agência " + contaPoupanca.getAgencia() + ", Número " + contaPoupanca.getNumero());
                    break;
                case 2:
                    if (contaCorrente == null) {
                        System.out.println("Crie um cliente e contas primeiro (Opção 1).");
                        break;
                    }
                    System.out.print("Depositar em (1-Corrente, 2-Poupança): ");
                    int tipoDeposito = scanner.nextInt();
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    if (tipoDeposito == 1) {
                        contaCorrente.depositar(valorDeposito);
                    } else if (tipoDeposito == 2) {
                        contaPoupanca.depositar(valorDeposito);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 3:
                    if (contaCorrente == null) {
                        System.out.println("Crie um cliente e contas primeiro (Opção 1).");
                        break;
                    }
                    System.out.print("Sacar de (1-Corrente, 2-Poupança): ");
                    int tipoSaque = scanner.nextInt();
                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    if (tipoSaque == 1) {
                        contaCorrente.sacar(valorSaque);
                    } else if (tipoSaque == 2) {
                        contaPoupanca.sacar(valorSaque);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 4:
                    if (contaCorrente == null) {
                        System.out.println("Crie um cliente e contas primeiro (Opção 1).");
                        break;
                    }
                    System.out.print("Transferir de (1-Corrente, 2-Poupança): ");
                    int tipoOrigem = scanner.nextInt();
                    System.out.print("Transferir para (1-Corrente, 2-Poupança): ");
                    int tipoDestino = scanner.nextInt();
                    System.out.print("Digite o valor para transferência: ");
                    double valorTransferencia = scanner.nextDouble();

                    Conta origem = (tipoOrigem == 1) ? contaCorrente : contaPoupanca;
                    Conta destino = (tipoDestino == 1) ? contaCorrente : contaPoupanca;

                    if (origem != null && destino != null) {
                        origem.transferir(valorTransferencia, destino);
                    } else {
                        System.out.println("Contas de origem ou destino inválidas.");
                    }
                    break;
                case 5:
                    if (contaCorrente == null) {
                        System.out.println("Crie um cliente e contas primeiro (Opção 1).");
                        break;
                    }
                    ((ContaCorrente) contaCorrente).imprimirExtrato();
                    break;
                case 6:
                    if (contaPoupanca == null) {
                        System.out.println("Crie um cliente e contas primeiro (Opção 1).");
                        break;
                    }
                    ((ContaPoupanca) contaPoupanca).imprimirExtrato();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

