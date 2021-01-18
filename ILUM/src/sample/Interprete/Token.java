package sample.Interprete;

public class Token {
    private String tipo;
    private String valorX;
    private String valorY;
    private String nombre;

    public Token(String tipo, String valorX, String valorY, String nombre) {
        this.tipo = tipo;
        this.valorX = valorX;
        this.valorY = valorY;
        this.nombre = nombre;
    }

    public Token(String tipo, String valorX, String valorY) {
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

    public String getValorX() {
        return valorX;
    }

    public void setValorX(String valorX) {
        this.valorX = valorX;
    }

    public String getValorY() {
        return valorY;
    }

    public void setValorY(String valorY) {
        this.valorY = valorY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
