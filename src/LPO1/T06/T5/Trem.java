package LPO1.T06.T5;

public class Trem extends VeiculoTerrestre {

    private int numeroVagoes;

    public Trem(String marca, String modelo, int ano, int numeroRodas, int numeroVagoes) {
        super(marca, modelo, ano, numeroRodas);
        this.numeroVagoes = numeroVagoes;
    }

    public int getNumeroVagoes() { return numeroVagoes; }
    public void setNumeroVagoes(int numeroVagoes) { this.numeroVagoes = numeroVagoes; }

    @Override
    public void andar() {
        System.out.println("O trem " + getModelo() + " com " + numeroVagoes + " vagões está andando nos trilhos.");
    }
}

