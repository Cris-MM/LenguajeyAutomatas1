package sample.Interprete;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import static sample.Interprete.TiposToken.*;

public class Compilador {
    private TextArea consola;
    private Canvas placa;
    GraphicsContext contexto;
    Color color;
    public Compilador(TextArea tx, Canvas placa){
        this.consola=tx;
        this.placa=placa;
    }
    public boolean compilar(String renglon){
        boolean erroes=false;
        if (renglon.contains("iniciar")){
            String[] arreglo=renglon.split(" ");
            int i1=renglon.indexOf('(')+1;
            int i2=renglon.indexOf(',');
            int i3=renglon.indexOf(',')+1;
            int i4=renglon.indexOf(')');
            double valx= Double.parseDouble(renglon.substring(i1,i2));
            double valy= Double.parseDouble(renglon.substring(i3,i4));
            String tipoToken="";
            contexto=placa.getGraphicsContext2D();
            contexto.setFill(color);
            color=Color.BLACK;
            double mAn=placa.getWidth()/2;
            double mAl=placa.getWidth()/2;
            //Instruccion 1
            if (arreglo[1].equals("linea")){
                tipoToken = LINEA;
                if (valx<=250 && valy<=250){
                    contexto.strokeLine(mAn+valx,mAl-valy,mAn+(valx+30),mAl-valy);
                }else{
                    consola.setText("El valor máximo en X o Y es 250");
                }
                //Instruccion 2
            }else if (arreglo[1].equals("cuadro")){
                tipoToken = CUADRO;
                if (valx<=250 && valy<=250){
                    contexto.strokeLine(mAn+valx,mAl-valy,mAn+(valx+30),mAl-valy);
                    contexto.strokeLine(mAn+valx,mAl-valy,mAn+valx,mAl-(valy+30));
                    contexto.strokeLine(mAn+(valx+30),mAl-valy,mAn+(valx+30),mAl-(valy+30));
                    contexto.strokeLine(mAn+valx,mAl-(valy+30),mAn+(valx+30),mAl-(valy+30));
                }else{
                    consola.setText("El valor máximo en X o Y es 250");
                }
                //Instruccion 3
            }else if (arreglo[1].equals("rectangulo")){
                tipoToken = RECTANGULO;
                if (valx<=250 && valy<=250){
                    contexto.strokeLine(mAn+valx,mAl-valy,mAn+(valx+50),mAl-valy);
                    contexto.strokeLine(mAn+valx,mAl-valy,mAn+valx,mAl-(valy+30));
                    contexto.strokeLine(mAn+(valx+50),mAl-valy,mAn+(valx+50),mAl-(valy+30));
                    contexto.strokeLine(mAn+valx,mAl-(valy+30),mAn+(valx+50),mAl-(valy+30));
                }else{
                    consola.setText("El valor máximo en X o Y es 250");
                }
                //Instruccion 4
            }else if (arreglo[1].equals("triangulo")){
                tipoToken = TRIANGULO;
                if (valx<=250 && valy<=250){
                    contexto.strokeLine(mAn+valx,mAl-valy,mAn+(valx+30),mAl-valy);
                    contexto.strokeLine(mAn+valx,mAl-valy,mAn+(valx+15),mAl-(valy+30));
                    contexto.strokeLine(mAn+(valx+30),mAl-valy,mAn+(valx+15),mAl-(valy+30));
                }else{
                    consola.setText("El valor máximo en X o Y es 250");
                }
                //Instruccion 5
            }else if (arreglo[1].equals("trapecio")) {
                tipoToken = TRAPECIO;
                if (valx <= 250 && valy <= 250) {
                    contexto.strokeLine(mAn + valx, mAl - valy, mAn + (valx + 50), mAl - valy);
                    contexto.strokeLine(mAn + valx, mAl - valy, mAn + (valx+10), mAl - (valy + 30));
                    contexto.strokeLine(mAn + (valx + 50), mAl - valy, mAn + (valx + 40), mAl - (valy + 30));
                    contexto.strokeLine(mAn + (valx+10), mAl - (valy + 30), mAn + (valx + 40), mAl - (valy + 30));
                } else {
                    consola.setText("El valor máximo en X o Y es 250");
                }
                //Instruccion 6
            }else if (arreglo[1].equals("rombo")) {
            tipoToken = ROMBO;
            if (valx <= 250 && valy <= 250) {
                contexto.strokeLine(mAn + (valx+15), mAl - valy, mAn + valx, mAl - (valy+15));
                contexto.strokeLine(mAn + (valx+15), mAl - valy, mAn + (valx+30), mAl - (valy+15));
                contexto.strokeLine(mAn + valx, mAl - (valy+15),mAn + (valx+15), mAl - (valy+30));
                contexto.strokeLine(mAn + (valx+30), mAl - (valy+15), mAn + (valx+15), mAl - (valy+30));
            } else {
                consola.setText("El valor máximo en X o Y es 250");
            }
        }
            Token token=new Token(tipoToken, valx, valy);
            arrayToken.add(token);
        }
        return erroes;
    }
}
