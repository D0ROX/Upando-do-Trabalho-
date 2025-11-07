package T06.T5;

public abstract class VeiculoTerrestre extends Veiculo {

    private int numeroRodas;

    public VeiculoTerrestre(String marca, String modelo, int ano, int numeroRodas) {
        super(marca, modelo, ano);
        this.numeroRodas = numeroRodas;
    }

    public int getNumeroRodas() { return numeroRodas; }
    public void setNumeroRodas(int numeroRodas) { this.numeroRodas = numeroRodas; }

    // andar() continua abstrato (herdado de Veiculo)
}
