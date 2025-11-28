package LPO1.T06.T5;

// Concreta: herda de VeiculoTerrestre
public class Carro extends VeiculoTerrestre {

    private String placa;

    public Carro(String marca, String modelo, int ano, int numeroRodas, String placa) {
        super(marca, modelo, ano, numeroRodas);
        this.placa = placa;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    @Override
    public void andar() {
        System.out.println("O carro " + getModelo() + " (placa " + placa + ") está andando na estrada.");
    }
}
