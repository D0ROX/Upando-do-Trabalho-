package T06.T5;

public abstract class VeiculoAquatico extends Veiculo {

    // Profundidade submersa do casco
    private double calado;

    public VeiculoAquatico(String marca, String modelo, int ano, double calado) {
        super(marca, modelo, ano);
        this.calado = calado;
    }

    public double getCalado() { return calado; }
    public void setCalado(double calado) { this.calado = calado; }
}
