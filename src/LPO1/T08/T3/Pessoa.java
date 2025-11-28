package LPO1.T08.T3;

// Molde abstrato para Aluno/Professor; não instanciável
public abstract class Pessoa {

    // Estado comum
    private String nome;
    private String cpf;
    private String endereco;

    public Pessoa(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Acesso somente-leitura
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}

