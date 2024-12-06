package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> contas;
    private List<Conta> contasList = new ArrayList<>();

    public BancoServiceServer() throws RemoteException {
        contas = new HashMap<>();
        contas.put("1", 100.0);
        contas.put("2", 156.0);
        contas.put("3", 950.0);
    }

    @Override
    public String adicionarConta(String numero, double saldo) throws RemoteException {
        Conta conta = new Conta(numero, saldo);

        contasList.add(conta);
        return ("Conta cadastrada com sucesso");
    }

    @Override
    public String pesquisarConta(String numero) throws RemoteException {
        for (Conta conta : contasList){
            if (conta.numero.equals(numero)){
                return conta.toString();
            }
        }
        throw new RemoteException("Account " + numero + " not found");
    }

    @Override
    public String removerConta(String numero) throws RemoteException {
        for (Conta conta : contasList){
            if (conta.numero.equals (numero)){
                contas.remove(conta);
                return "Conta removida";
            }
        }
        throw new RemoteException("Account " + numero + " not found");
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public double saldoConta(String conta) throws RemoteException {
        return contas.get(conta);
    }
}
