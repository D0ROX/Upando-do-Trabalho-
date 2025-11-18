package T05.T3;

// Modelo simples de bicicleta com limite de marchas
public class Bicicleta {

    // Estado encapsulado
    private int cadencia;
    private int velocidade;
    private int marcha;
    private int numeroMaximoMarchas; // define a faixa válida de marcha

    // Padrão: 18 marchas; inicia parada
    public Bicicleta() {
        this.numeroMaximoMarchas = 18;
        this.cadencia = 0;
        this.velocidade = 0;
        this.marcha = 1;
    }

    // Permite configurar o limite de marchas; inicia parada
    public Bicicleta(int maxMarchas) {
        this.numeroMaximoMarchas = maxMarchas;
        this.cadencia = 0;
        this.velocidade = 0;
        this.marcha = 1;
    }

    // Getters (somente leitura do estado)
    public int getCadencia() { return cadencia; }
    public int getVelocidade() { return velocidade; }
    public int getMarcha() { return marcha; }
    public int getNumeroMaximoMarchas() { return numeroMaximoMarchas; }

    // Ajusta cadência (sem regra de faixa aqui)
    public void mudarCadencia(int novoValor) {
        this.cadencia = novoValor;
    }

    // Garante marcha dentro da faixa [1..max]
    public void mudarMarcha(int novoValor) {
        if (novoValor > 0 && novoValor <= numeroMaximoMarchas) {
            this.marcha = novoValor;
            System.out.println("Marcha alterada para: " + marcha);
        } else {
            System.out.println("Marcha inválida. Máximo: " + numeroMaximoMarchas);
        }
    }

    // Incrementa velocidade (sem regra de topo)
    public void aumentarVelocidade(int incremento) {
        this.velocidade += incremento;
    }

    // Decrementa velocidade sem permitir negativo
    public void aplicarFreios(int decremento) {
        this.velocidade -= decremento;
        if (velocidade < 0) velocidade = 0;
    }

    // Estado atual em uma linha
    public void printStates() {
        System.out.println("Cadencia: " + cadencia +
                " | Velocidade: " + velocidade +
                " | Marcha: " + marcha +
                " (Max: " + numeroMaximoMarchas + ")");
    }
}

