package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML VBox vbox;
    @FXML TextField txtMensaje;
    public void enter(KeyEvent event){
        if (event.getCode()== KeyCode.ENTER){
            Label label=new Label("Usuario dice: "+txtMensaje.getText());
            vbox.getChildren().add(label);

            String respuesta= chatBot(txtMensaje.getText().toLowerCase());
            Label label2=new Label(respuesta);
            vbox.getChildren().add(label2);
            txtMensaje.clear();
        }
    }
    boolean pidioPieza=false;
    public String chatBot(String mensaje){
        String respuesta="ChatBot dice: "+"Podrías repetir la respuesta";
        if (mensaje.contains("hola")){
            respuesta="ChatBot dice: ¡Hola!, ¿En qué le puedo ayudar?";
        }else if (mensaje.contains("pieza")){
            respuesta="ChatBot dice: Escriba la marca, modelo y la pieza que necesita";
            pidioPieza=true;
        }else if (pidioPieza){
            String[] datos=mensaje.split(" ");
            String modelo=datos[1];
            int indice1=mensaje.indexOf(modelo)+modelo.length();
            int indice2=mensaje.length();
            String pieza=mensaje.substring(indice1, indice2);
            respuesta="ChatBot dice: La pieza "+pieza+" del auto "+datos[0]+" "+datos[1]+" si la tenemos en existencia";
            pidioPieza=false;
        }
        return respuesta;
    }
}
