package T06.T5;

public abstract class VeiculoAereo extends Veiculo {

    private int numeroMotores;

    public VeiculoAereo(String marca, String modelo, int ano, int numeroMotores) {
        super(marca, modelo, ano);
        this.numeroMotores = numeroMotores;
    }

    public int getNumeroMotores() { return numeroMotores; }
    public void setNumeroMotores(int numeroMotores) { this.numeroMotores = numeroMotores; }
}

