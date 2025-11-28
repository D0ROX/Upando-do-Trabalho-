package LPO1.TrabalhoLPO1;

public interface ContaI {
    boolean deposita(double valor);
    boolean saca(double valor);
    Cliente getDono();
    int getNumero();
    double getSaldo();
    void remunera();
}
