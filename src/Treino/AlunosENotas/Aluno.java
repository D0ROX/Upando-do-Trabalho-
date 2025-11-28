package Treino.AlunosENotas;

import java.util.ArrayList;

public class Aluno {
    private String nome;                // nome do aluno
    private ArrayList<Double> notas;    // lista de notas do aluno

    // Construtor
    public Aluno(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    // Método para adicionar uma nota
    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    // Método para calcular a média
    public double calcularMedia() {
        if(notas.isEmpty()) return 0;
        double soma = 0;
        for(Double n : notas) {
            soma += n;
        }
        return soma / notas.size();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    // Para exibir o aluno e suas notas
    public void mostrarAluno() {
        System.out.println("Nome: " + nome);
        System.out.println("Notas: " + notas);
        System.out.printf("Média: %.2f\n", calcularMedia());
    }
}

