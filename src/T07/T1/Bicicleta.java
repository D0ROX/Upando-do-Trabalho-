package T07.T1;

public class Bicicleta {

    // Estado interno encapsulado
    private int cadencia;
    private int velocidade;
    private int marcha;

    public Bicicleta() {
        cadencia = 0;       // inicia parada
        velocidade = 0;     // inicia parada
        marcha = 1;         // marcha inicial
    }

    // Valida RPM
    public void setCadencia(int novoValor) throws RPMException {
        if (novoValor < 0) {
            throw new RPMException("Cadência (RPM) não pode ser negativa.");
        }
        cadencia = novoValor;
    }

    // Valida faixa de marcha
    public void setMarcha(int novoValor) throws MarchaException {
        if (novoValor < 0 || novoValor > 24) {
            throw new MarchaException("Marcha deve estar entre 0 e 24.");
        }
        marcha = novoValor;
    }

    // Valida faixa de velocidade
    public void setVelocidade(int novoValor) throws VelocidadeException {
        if (novoValor < 0 || novoValor > 100) {
            throw new VelocidadeException("Velocidade deve estar entre 0 e 100 km/h.");
        }
        velocidade = novoValor;
    }

    // Visualização simples do estado
    public void printStates() {
        System.out.println("cadencia=" + cadencia + " velocidade=" + velocidade + " marcha=" + marcha);
    }

    // Getters
    public int getVelocidade() { return velocidade; }
    public int getMarcha() { return marcha; }
    public int getCadencia() { return cadencia; }
}

