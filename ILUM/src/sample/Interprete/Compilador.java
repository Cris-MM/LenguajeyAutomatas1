package sample.Interprete;

import javafx.scene.control.TextArea;

import static sample.Interprete.TiposToken.*;

public class Compilador {
    private TextArea consola;
    public Compilador(TextArea tx){
        this.consola=tx;
    }
    public boolean compilar(String renglon){
        boolean erroes=false;
        if (renglon.contains("iniciar")){
            String[] arreglo=renglon.split(" ");
            int i1=renglon.indexOf('(')+1;
            int i2=renglon.indexOf(',');
            int i3=renglon.indexOf(',')+1;
            int i4=renglon.indexOf(')');
            String valx=renglon.substring(i1,i2);
            String valy=renglon.substring(i3,i4);
            String tipoToken="";
            if (arreglo[1].equals("linea")){
                tipoToken = LINEA;
            }else if (arreglo[1].equals("cuadro")){
                tipoToken = CUADRO;
            }
            Token token=new Token(tipoToken, valx, valy);
            arrayToken.add(token);
        }
        return erroes;
    }
}
