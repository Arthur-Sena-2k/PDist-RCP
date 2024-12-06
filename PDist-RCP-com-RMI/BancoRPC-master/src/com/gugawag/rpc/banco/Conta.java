package com.gugawag.rpc.banco;

class Conta {
    public String numero;
    public double saldo;

    public Conta(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    @Override
    public String toString(){
        return "Conta{numero ='" + numero + "', saldo =" + saldo + "}";
    }
}
