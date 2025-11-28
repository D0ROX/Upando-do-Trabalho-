package LPO1.T04.T1;

// Este é o arquivo "Pessoa.java"

// (a) Estrutura da classe para representar uma Pessoa
public class Pessoa {

    // 'private' para proteger os dados.
    // Isso se chama Encapsulamento.
    private String nome;
    private int idade;
    private String endereco;


    // Métodos (Getters e Setters)
    // Métodos são 'public' para que outras classes possam usá-los.

    // Método para "definir" (set) o nome
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    // Método para "obter" (get) o nome
    public String getNome() {
        return this.nome;
    }

    // Método para "definir" (set) a idade
    public void setIdade(int novaIdade) {
        this.idade = novaIdade;
    }

    // Método para "obter" (get) a idade
    public int getIdade() {
        return this.idade;
    }

    // Método para "definir" (set) o endereço
    public void setEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }

    // Método para "obter" (get) o endereço
    public String getEndereco() {
        return this.endereco;
    }



     // c. Incrementa a idade da pessoa em 1 ano.

    public void fazAniversario() {
        this.idade = this.idade + 1; // ou this.idade++
    }


     // c. Imprime todos os atributos da pessoa de forma legível.
    public void imprime() {
        System.out.println("Dados da Pessoa: ");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade + " anos");
        System.out.println("Endereço: " + this.endereco);
    }
}