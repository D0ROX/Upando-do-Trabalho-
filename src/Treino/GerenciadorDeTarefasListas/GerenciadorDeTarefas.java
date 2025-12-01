package Treino.GerenciadorDeTarefasListas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeTarefas {

    private List<String> tarefas;

    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String tarefa) {
        this.tarefas.add(tarefa);
        System.out.println("✅ Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        System.out.println(" --- Tarefas --- ");
        if (this.tarefas.isEmpty()) {
            System.out.println("Nenhum tarefa encontrada");
            return;
        }
        for(int i = 0; i < this.tarefas.size(); i++){
            System.out.println((i +1) + ". " +this.tarefas.get(i));
        }
        System.out.println("--------------------");
    }
    public boolean removerTarefa(String tarefa) {
        boolean tarefaRemovida = tarefas.remove(tarefa);

        if(tarefaRemovida){
            System.out.println("\n✅ Tarefa removida! ");
            return true;
        } else {
            System.out.println("\n❌ Esta tarefa não esta na lista! ");
            return false;
        }
    }

    public static void main(String[] args){

        GerenciadorDeTarefas meuGerenciador = new GerenciadorDeTarefas();

        meuGerenciador.listarTarefas();

        meuGerenciador.adicionarTarefa("Estudar Construtor ");
        meuGerenciador.adicionarTarefa("Aprender a usar MAC ");

        meuGerenciador.listarTarefas();

        meuGerenciador.removerTarefa("Aprender a usar MAC ");

        meuGerenciador.listarTarefas();

        meuGerenciador.removerTarefa("Correr na rua ");
    }


}




