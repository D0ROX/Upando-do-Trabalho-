package LPO1.T05.T2;

public class Ponto3D {
    // 'private' impede acesso direto de fora da classe.
    private double x, y, z;
    private String cor;
    private double intensidade;

    // Getters e Setters 'public' permitem acesso controlado.
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    // ...

    // (a) Calcula a distância deste ponto até o ponto 'p'
    protected double calculaDistancia(Ponto3D p) {
        // 'this.x' é o 'x' do ponto atual
        // 'p.getX()' é o 'x' do ponto 'p'
        double diffX = this.x - p.getX();
        double diffY = this.y - p.getY();
        double diffZ = this.z - p.getZ();
        // Retorna a raiz quadrada da soma dos quadrados
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2) + Math.pow(diffZ, 2));
    }
}
