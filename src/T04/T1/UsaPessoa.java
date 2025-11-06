package T04.T1;

import java.util.Scanner;

// (b) Crie uma outra classe que utilize um objeto Pessoa
public class UsaPessoa {

    // Este é o método principal, onde o programa começa
    public static void main(String[] args) {

        // 1. Cria o objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // 2. Instancia um objeto do tipo Pessoa
        Pessoa pessoa1 = new Pessoa();

        // (b)

        // 3. Lê as informações do teclado
        System.out.print("Digite o nome da pessoa: ");
        String nomeInput = scanner.nextLine();

        System.out.print("Digite a idade da pessoa: ");
        int idadeInput = scanner.nextInt();

        scanner.nextLine(); // Truque para "limpar" o Enter do teclado

        System.out.print("Digite o endereço da pessoa: ");
        String enderecoInput = scanner.nextLine();

        // 4. Usa os métodos "setters" para guardar os dados no objeto
        pessoa1.setNome(nomeInput);
        pessoa1.setIdade(idadeInput);
        pessoa1.setEndereco(enderecoInput);

        // 5. Mostra os dados usando os métodos "getters"
        System.out.println("\nExibindo dados: ");
        System.out.println("Nome lido: " + pessoa1.getNome());
        System.out.println("Idade lida: " + pessoa1.getIdade());
        System.out.println("Endereço lido: " + pessoa1.getEndereco());

        // (d)

        // 6. Utiliza o método fazAniversario() algumas vezes
        System.out.println("\n...Comemorando alguns aniversários...");
        pessoa1.fazAniversario(); // +1 ano
        pessoa1.fazAniversario(); // +1 ano

        // 7. Imprime os atributos usando o método imprime()
        // O método imprime() já mostra a idade atualizada.
        pessoa1.imprime();

        // 8. Fecha o scanner
        scanner.close();
    }
}
