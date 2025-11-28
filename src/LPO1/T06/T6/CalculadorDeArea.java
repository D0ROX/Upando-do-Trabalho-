package LPO1.T06.T6;

public class CalculadorDeArea {

    // Soma as áreas de uma lista polimórfica de Superficie
    public static double somarAreas(Superficie[] formas) {
        if (formas == null) return 0.0;

        double soma = 0.0;
        for (Superficie f : formas) {
            if (f != null) {
                soma += f.area(); // polimorfismo em tempo de execução
            }
        }
        return soma;
    }
}
