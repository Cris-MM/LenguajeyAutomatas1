package sample.Interprete;

public class Token {
    private String tipo;
    private double valorX;
    private double valorY;
    private String nombre;

    public Token(String tipo, double valorX, double valorY, String nombre) {
        this.tipo = tipo;
        this.valorX = valorX;
        this.valorY = valorY;
        this.nombre = nombre;
    }

    public Token(String tipo, double valorX, double valorY) {
        this.tipo = tipo;
        this.valorX = valorX;
        this.valorY = valorY;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public double getValorY() {
        return valorY;
    }

    public void setValorY(double valorY) {
        this.valorY = valorY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
