package Rocket;

//Neste projeto, você desenvolverá um sistema básico para gerenciar o empréstimo
// de livros em uma biblioteca. O foco será na listagem de livros disponíveis
// e na funcionalidade de empréstimo.

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<String> catalogo;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();

        this.catalogo.add("Livro 1");
        this.catalogo.add("Livro 2");
        this.catalogo.add("Livro 3");
        this.catalogo.add("Livro 4");
    }

    public void listarLivroDisponiveis(){
        System.out.println("--- Livros disponiveis ---");
        if(catalogo.isEmpty()){
            System.out.println("Nenhum livro encontrado");
            return;
        }
        for(int i = 0; i < catalogo.size(); i++){
            System.out.println(catalogo.get(i));
        }
    }

    public boolean emprestarLivro(String titulo){
        boolean LivroRemovido = catalogo.remove(titulo);

        if(LivroRemovido){
            System.out.println("\n✅ SUCESSO! O livro '" + titulo + "' foi emprestado.");
            return true;
        } else {
            System.out.println("\n❌ ERRO! O livro '" + titulo + "' não foi encontrado (talvez já tenha sido emprestado).");
            return false;
        }
    }

    public static void main(String[] args){

        Biblioteca minhaBiblioteca = new Biblioteca();

        minhaBiblioteca.listarLivroDisponiveis();

        String livroEscolhido = "Livro 1";
        minhaBiblioteca.emprestarLivro(livroEscolhido);

        minhaBiblioteca.listarLivroDisponiveis();

        livroEscolhido = "Java";
        minhaBiblioteca.emprestarLivro(livroEscolhido);

    }
}
