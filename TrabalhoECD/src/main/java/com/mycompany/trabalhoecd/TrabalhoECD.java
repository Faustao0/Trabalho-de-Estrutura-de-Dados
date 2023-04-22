package com.mycompany.trabalhoecd;

import java.util.Arrays;
import java.util.Scanner;

public class TrabalhoECD {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o tamanho do vetor desejado: ");
        int tamanho = scanner.nextInt();

        int[] vetor = new int[tamanho];
        System.out.println("Digite os " + tamanho + " números inteiros separados por espaço:");
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = scanner.nextInt();
        }

        System.out.print("Vetor original: ");
        exibirVetor(vetor);
    
        System.out.println("Escolha o método de ordenação:");
        System.out.println("1 - Ordenação por inserção");
        System.out.println("2 - Ordenação por seleção");
        System.out.println("3 - Ordenação bolha");
        int escolha = scanner.nextInt();

        int[] copiaVetor = Arrays.copyOf(vetor, vetor.length); 

        long tempoInicio = System.nanoTime(); 
     
        switch (escolha) {
            case 1 -> {
                ordenacaoInsercao(copiaVetor);
                System.out.print("Vetor ordenado por inserção: ");
                exibirVetor(copiaVetor);
            }
            case 2 -> {
                ordenacaoSelecao(copiaVetor);
                System.out.print("Vetor ordenado por seleção: ");
                exibirVetor(copiaVetor);
            }
            case 3 -> {
                ordenacaoBolha(copiaVetor);
                System.out.print("Vetor ordenado por bolha: ");
                exibirVetor(copiaVetor);
            }
            default -> System.out.println("Opção inválida!");
        }

        long tempoFim = System.nanoTime();
        System.out.println("Tempo de execução: " + (tempoFim - tempoInicio) + " nanosegundos");
              
       long tempoInicioInsercao = System.nanoTime(); 
        int[] copiaVetorInsercao = null;
        ordenacaoInsercao(copiaVetorInsercao);
        long tempoFimInsercao = System.nanoTime(); 
       
        long tempoInicioSelecao = System.nanoTime(); 
        int[] copiaVetorSelecao = null;
        ordenacaoSelecao(copiaVetorSelecao);
        long tempoFimSelecao = System.nanoTime(); 
        
        long tempoInicioBolha = System.nanoTime(); 
        int[] copiaVetorBolha = null;
        ordenacaoBolha(copiaVetorBolha);
        long tempoFimBolha = System.nanoTime(); 
        

        System.out.println("Tempo de execução por inserção: " + (tempoFimInsercao - tempoInicioInsercao) + " nanosegundos");
        System.out.println("Tempo de execução por seleção: " + (tempoFimSelecao - tempoInicioSelecao) + " nanosegundos");
        System.out.println("Tempo de execução por bolha: " + (tempoFimBolha - tempoInicioBolha) + " nanosegundos");

    }
    //mostra o vetor 
    public static void exibirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
    //Ordenação de inserção 
    public static void ordenacaoInsercao(int[] vetor) {
    for (int i = 1; i < vetor.length; i++) {
        for (int j = i; j > 0 && vetor[j] < vetor[j - 1]; j--) {
            int temp = vetor[j];
            vetor[j] = vetor[j - 1];
            vetor[j - 1] = temp;
        }
    }
    }
    
    //Ordenaçãoo de Seleção
   public static void ordenacaoSelecao(int[] vetor) {
    for (int i = 0; i < vetor.length - 1; i++) {
        int indiceMenor = i;
        for (int j = i + 1; j < vetor.length; j++) {
            if (vetor[j] < vetor[indiceMenor]) {
                indiceMenor = j;
            }
        }
        int temp = vetor[i];
        vetor[i] = vetor[indiceMenor];
        vetor[indiceMenor] = temp;
    }
}

//Ordenção de bolha
private static void ordenacaoBolha(int[] copiaVetorBolha) {
    boolean houveTroca = true;
    while (houveTroca) {
        houveTroca = false;
        for (int i = 0; i < copiaVetorBolha.length - 1; i++) {
            if (copiaVetorBolha[i] > copiaVetorBolha[i+1]) {
                int temp = copiaVetorBolha[i];
                copiaVetorBolha[i] = copiaVetorBolha[i+1];
                copiaVetorBolha[i+1] = temp;
                houveTroca = true;
            }
        }
    }
    }
}
