package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    String adicionarConta(String numero, double saldo) throws RemoteException;

    String pesquisarConta(String numero) throws RemoteException;

    String removerConta(String numero) throws RemoteException;

    int quantidadeContas() throws RemoteException;

    double saldoConta(String conta) throws RemoteException;
}
