
package poo;

import java.util.*; //importar a classe Util.

import java.util.Scanner;

public class APP {
    
    //Constante
    //static final int MAXCONTA = 20;
   
    //variável comum
    static int index = 0;
    
    //Lista de contas
    //static Conta[] lista = new Conta[MAXCONTA];
    
    //Estrutura de dados ArrayList Genérica
    static List<Conta> lista = new ArrayList<Conta>();

    static Scanner tecla = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {                
            System.out.println("*** MENU PRINCIPAL ***");
            System.out.println("1-Incluir conta");
            System.out.println("2-Sacar");
            System.out.println("3-Depositar");
            System.out.println("4-Listar saldo das Contas");
            System.out.println("5-Excluir Conta");
            System.out.println("6-Sair");
            System.out.println("Digite sua opção: ");
            op = tecla.nextInt(); 
            switch(op){
                case 1: incluirConta(); break;
                case 2: sacarValor(); break;
                case 3: depositarValor(); break;    
                case 4: listarContas(); break;
                case 5: excluirContas(); break;
                case 6: break;
            }
        } while (op!=6);       
    }
    
    
    public static void incluirConta(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o saldo da conta:");
        double saldo = tecla.nextDouble();
        //Criar o objeto e inserir na lista
        //lista[index++] = new Conta(num, saldo);
        lista.add(new Conta(num, saldo));
        System.out.println("Conta cadastrada com sucesso!");
    }
    
    public static void sacarValor(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o valor do saque:");
        double valor = tecla.nextDouble();
        
        for (Conta item : lista) {
            if (item.getNumero() == num){
                item.sacar(valor);
                break;
            }
        }
        
        //Procurar a conta na lista
        //for (int i = 0; i < lista.length-1; i++) {
        //    if (num == lista[i].getNumero()){
        //        lista[i].sacar(valor);
        //        break;
        //    }
        //}
        
        
    }
    
    public static void depositarValor(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o valor do depósito:");
        double valor = tecla.nextDouble();
        
        for (Conta item : lista) {
            if (item.getNumero() == num){
                item.depositar(valor);
                break;
            }
        }
        
        //Procurar a conta na lista
        //for (int i = 0; i < lista.length-1; i++) {
        //    if (num == lista[i].getNumero()){
        //        lista[i].depositar(valor);
        //        break;
        //    }
        //}
    }
    
    public static void excluirContas(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        
        for (Conta item : lista) {
            if (item.getNumero() == num){
               lista.remove(item);
            }
        }
        
        //Procurar a conta na lista
        //for (int i = 0; i < lista.length-1; i++) {
            //if (lista[i] != null && 
                //num == lista[i].getNumero()){
                //lista[i]=null; //excluir a referência do objeto
                //System.gc(); //invocar o Garbage Collector
                //break;
            //}
        //}
    }
    
    public static void listarContas(){
        double total = 0;
        System.out.println("----------------------------");
        System.out.println("| Nº Conta:........Saldo:   |");
        
        for (Conta item : lista) {
            System.out.println("|" + item.getNumero()
                               + "........" +
                               item.getSaldo() + "|");
            total = total + item.getSaldo();
        }
        System.out.println("----------------------------");
        System.out.println("| Total:........" + total + "|");
        System.out.println("----------------------------");

        //for (int i = 0; i < lista.length-1; i++) {
        //    if (lista[i] != null){
        //        System.out.println(lista[i].getNumero()
        //                           + "........" +
        //                           lista[i].getSaldo());
        //        //total += lista[i].getSaldo();
        //        total = total + lista[i].getSaldo();
        //    }else{
        //        break;
        //    }
        //}
        
    }
}