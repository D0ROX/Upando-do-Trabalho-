package LPO1.T05.T4;

import java.util.Scanner;

// CLI para usar o ConversorTemperatura
public class UsaConversor {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Conversor de Temperatura");
            System.out.println("1. Celsius -> Fahrenheit");
            System.out.println("2. Fahrenheit -> Celsius");
            System.out.println("3. Celsius -> Kelvin");
            System.out.println("4. Kelvin -> Celsius");
            System.out.println("5. Fahrenheit -> Kelvin");
            System.out.println("6. Kelvin -> Fahrenheit");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();

            System.out.print("Digite a temperatura: ");
            double temperatura = sc.nextDouble();
            double resultado;

            // Seleciona a conversão e imprime resultado
            switch (opcao) {
                case 1:
                    resultado = ConversorTemperatura.celsiusParaFahrenheit(temperatura);
                    System.out.printf("%.2f C = %.2f F%n", temperatura, resultado);
                    break;
                case 2:
                    resultado = ConversorTemperatura.fahrenheitParaCelsius(temperatura);
                    System.out.printf("%.2f F = %.2f C%n", temperatura, resultado);
                    break;
                case 3:
                    resultado = ConversorTemperatura.celsiusParaKelvin(temperatura);
                    System.out.printf("%.2f C = %.2f K%n", temperatura, resultado);
                    break;
                case 4:
                    resultado = ConversorTemperatura.kelvinParaCelsius(temperatura);
                    System.out.printf("%.2f K = %.2f C%n", temperatura, resultado);
                    break;
                case 5:
                    resultado = ConversorTemperatura.fahrenheitParaKelvin(temperatura);
                    System.out.printf("%.2f F = %.2f K%n", temperatura, resultado);
                    break;
                case 6:
                    resultado = ConversorTemperatura.kelvinParaFahrenheit(temperatura);
                    System.out.printf("%.2f K = %.2f F%n", temperatura, resultado);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

