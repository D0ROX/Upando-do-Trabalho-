package LPO1.TrabalhoLPO1; // É como a “caixa” onde guardamos esta classe dentro do projeto, para organizar.

import java.util.Objects; // Traz uma ajuda pronta do Java para algumas operações (usaremos para gerar um código numérico).

/**
 * Esta classe representa um Cliente, ou seja, um cadastro com informações de uma pessoa.
 * Ela guarda os dados do cliente e também define:
 * - Como mostrar o cliente como texto (toString).
 * - Quando dois clientes devem ser considerados a mesma pessoa (equals e hashCode, usando CPF).
 * - Como ordenar clientes em uma lista (Comparable), por nome e sobrenome.
 */
public class Cliente implements Comparable<Cliente> { // Comparable permite colocar clientes em ordem alfabética.

    // Estas são as “caixinhas” onde o objeto guarda as informações do cliente.
    // Ficam privadas para proteger os dados e evitar mudanças por acidente.
    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;        // Vamos tratar o CPF como o “identificador único” da pessoa.
    private String endereco;

    // Este é o “molde” para criar um Cliente. Quando usamos new Cliente(...), passamos esses dados.
    public Cliente(String nome, String sobrenome, String rg, String cpf, String endereco) {
        this.nome = nome;           // this.nome = o nome guardado dentro do objeto.
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // “Portinhas” para ler os dados (get = pegar/obter).
    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public String getRg() { return rg; }
    public String getCpf() { return cpf; }
    public String getEndereco() { return endereco; }

    // “Portinhas” para mudar os dados com segurança (set = definir/alterar).
    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setRg(String rg) { this.rg = rg; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    // Define como colocar clientes em ordem quando tiver uma lista (ex.: ordenar alfabeticamente).
    // Primeiro compara o nome; se empatar, compara o sobrenome.
    @Override
    public int compareTo(Cliente outro) {
        int cmp = this.nome.compareToIgnoreCase(outro.nome); // Ignora maiúsculas/minúsculas.
        if (cmp != 0) return cmp; // Se os nomes forem diferentes, já decide a ordem.
        return this.sobrenome.compareToIgnoreCase(outro.sobrenome); // Se nomes iguais, decide pelo sobrenome.
    }

    // Diz quando dois Clientes são considerados a mesma pessoa.
    // Aqui, se o CPF for igual, consideramos que é a mesma pessoa.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                // Se for exatamente o mesmo objeto, é igual.
        if (!(o instanceof Cliente)) return false; // Se nem for Cliente, não é igual.
        Cliente cliente = (Cliente) o;             // Transforma o “o” em Cliente para comparar.
        return Objects.equals(cpf, cliente.cpf);   // Compara o CPF (funciona mesmo se algum for nulo).
    }

    // “Par” do equals. Quando dois objetos são iguais, devem gerar o mesmo número aqui.
    // Esse número ajuda estruturas como HashSet/HashMap a funcionarem direito (evitar duplicados).
    @Override
    public int hashCode() {
        return Objects.hash(cpf); // Usa só o CPF, porque o equals também usa só o CPF.
    }

    // Define como o cliente aparece quando transformamos em texto (por exemplo, ao imprimir).
    @Override
    public String toString() {
        return nome + " " + sobrenome + " - CPF: " + cpf;
    }
}
