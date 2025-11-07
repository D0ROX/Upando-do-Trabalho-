package T06.T3;

// Superclasse C
public class C {
    // Visível para subclasses e mesmo pacote
    protected String atributo1;
    protected float atributo2;

    // Construtor padrão
    public C() {
        this.atributo1 = "VAZIO";
        this.atributo2 = -999.99f;
    }

    // Construtor com parâmetros
    public C(String p1, float p2) {
        this.atributo1 = p1;
        this.atributo2 = p2;
    }
}

