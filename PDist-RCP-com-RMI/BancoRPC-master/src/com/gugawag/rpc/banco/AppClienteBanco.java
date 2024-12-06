package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        // String ipServidor = args[0];
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while (opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String numero = entrada.next();
                    System.out.println(banco.pesquisarConta(numero));
                    break;
                }
                case 2: {
                    System.out.println("Quantidade de contas: " + banco.quantidadeContas());
                    break;
                }
                case 3: {
                    System.out.println("Digite o número da nova conta:");
                    String numero = entrada.next();
                    System.out.println("Digite o saldo inicial:");
                    double saldo = entrada.nextDouble();
                    System.out.println(banco.adicionarConta(numero, saldo));
                    break;
                }
                case 4: {
                    System.out.println("Digite o número da conta para remoção:");
                    String numero = entrada.next();
                    System.out.println(banco.removerConta(numero));
                    break;
                }
                case 5: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    System.out.println(banco.saldoConta(conta));
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== BANCO RMI ===");
        System.out.println("Desenvolvido por: [Seu Nome Completo]");
        System.out.println("1 - Pesquisar conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Adicionar nova conta");
        System.out.println("4 - Remover conta");
        System.out.println("5 - Pesquisa conta");
        System.out.println("9 - Sair");
    }
}
