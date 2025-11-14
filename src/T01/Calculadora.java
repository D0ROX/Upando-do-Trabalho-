package T01;

public class Calculadora {
    public static void main(String[] args) {

        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);
        String operacao = args[2];

        double resultado = 0.0;

        switch (operacao) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "/":
                resultado = num1 / num2;
                break;
            case "X":
                resultado = num1 * num2;
                break;
        }

        System.out.println(resultado);
    }
}
