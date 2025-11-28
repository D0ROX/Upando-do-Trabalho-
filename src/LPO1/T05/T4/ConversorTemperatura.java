package LPO1.T05.T4;

// Conversões entre Celsius, Fahrenheit e Kelvin
public class ConversorTemperatura {

    // Mantém as fórmulas explícitas e sem efeitos colaterais
    public static double celsiusParaFahrenheit(double c) {
        return (c * 9.0 / 5.0) + 32.0;
    }

    public static double fahrenheitParaCelsius(double f) {
        return (f - 32.0) * 5.0 / 9.0;
    }

    public static double celsiusParaKelvin(double c) {
        return c + 273.15;
    }

    public static double kelvinParaCelsius(double k) {
        return k - 273.15;
    }

    // Converte por composição para reduzir duplicação
    public static double fahrenheitParaKelvin(double f) {
        return celsiusParaKelvin(fahrenheitParaCelsius(f));
    }

    public static double kelvinParaFahrenheit(double k) {
        return celsiusParaFahrenheit(kelvinParaCelsius(k));
    }
}

