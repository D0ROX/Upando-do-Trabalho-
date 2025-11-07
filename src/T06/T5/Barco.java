package T06.T5;

public class Barco extends VeiculoAquatico {

    private String nome;

    public Barco(String marca, String modelo, int ano, double calado, String nome) {
        super(marca, modelo, ano, calado);
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public void andar() {
        System.out.println("O barco " + nome + " está navegando.");
    }
}

