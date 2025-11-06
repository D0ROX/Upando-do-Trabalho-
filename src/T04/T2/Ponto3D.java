package T04.T2;

public class Ponto3D {

    private double x;
    private double y;
    private double z;
    private String cor;
    private double intensidade;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(double intensidade) {
        this.intensidade = intensidade;
    }

    /**
     a. Calcula a distância entre este ponto e outro ponto 'p' recebido
     como parâmetro.
     */
    public double calculaDistancia(Ponto3D p) {

        double diffX = this.x - p.getX();
        double diffY = this.y - p.getY();
        double diffZ = this.z - p.getZ();

        double distancia = Math.sqrt(
                Math.pow(diffX, 2) + Math.pow(diffY, 2) + Math.pow(diffZ, 2)
        );

        return distancia;
    }
}