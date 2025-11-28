package LPO1.T06.T3;

// C1_2 herda C e implementa I1, I2
public class C1_2 extends C implements I1, I2 {

    // Matriz própria
    private float[][] atributo3;

    // Construtor padrão
    public C1_2() {
        super(); // inicializa C
        atributo3 = new float[2][2]; // zeros por padrão
    }

    // Construtor com parâmetros
    public C1_2(String p1, float p2) {
        super(p1, p2);
        atributo3 = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                atributo3[i][j] = 1.0f;
            }
        }
    }

    // I1
    @Override
    public void operacao1() {
        System.out.println("...Passou por operacao1()");
        System.out.println("   atributo1 = " + atributo1);
        System.out.println("   atributo2 = " + atributo2);
        System.out.println("   atributo3[0][0] = " + atributo3[0][0]);
    }

    // I2
    @Override
    public void operacao2() {
        System.out.println("...Passou por operacao2()");
    }
}
