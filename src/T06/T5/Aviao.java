package T06.T5;

public class Aviao extends VeiculoAereo {

    private String companhiaAerea;

    public Aviao(String marca, String modelo, int ano, int numeroMotores, String companhiaAerea) {
        super(marca, modelo, ano, numeroMotores);
        this.companhiaAerea = companhiaAerea;
    }

    public String getCompanhiaAerea() { return companhiaAerea; }
    public void setCompanhiaAerea(String companhiaAerea) { this.companhiaAerea = companhiaAerea; }

    @Override
    public void andar() {
        System.out.println("O avião " + getModelo() + " da " + companhiaAerea + " está voando.");
    }
}

