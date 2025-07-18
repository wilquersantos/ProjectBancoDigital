package com.banco;

public abstract class Conta {
    // Atributos da conta
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    // Construtor
    public Conta(Cliente cliente) {
        this.agencia = 1; // Agência padrão
        this.numero = (int) (Math.random() * 10000); // Número de conta aleatório
        this.saldo = 0;
        this.cliente = cliente;
    }

    // Métodos abstratos
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract void transferir(double valor, Conta destino);

    // Getters
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Método para imprimir extrato (comum a todas as contas)
    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}

