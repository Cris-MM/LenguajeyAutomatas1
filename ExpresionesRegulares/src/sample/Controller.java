package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {
    @FXML TextField txtTexto;
    @FXML ListView listaEjer;
    @FXML Label lblResultado;
    @FXML protected void initialize(){
        listaEjer.getItems().addAll("1: Ejercicio 1",
                "2: Ejercicio 2",
                "3: Palabra que no comience con db",
                "4: Palabra que termine con count",
                "5: Validad que haya 2 nombres",
                "6: Validar una MAC address",
                "7: Palabra que comience y termine en mayúscula",
                "8: Validar número binario de 8 dígitos",
                "9: Validar escritura de un número hexadecimal",
                "10: Validar operaciones de un digito",
                "11: Validar número de control del ITSNCG",
                "12: Validar el número CURP",
                "13: Validar que haya insertado X cantidad de pesos",
                "14: Validar el número de una tarjeta de crédito",
                "15: Validar una etiqueta HTML",
                "16: Validar un color Hexadecimal",
                "17: Validar un link",
                "18: Validar el Query Insert into de SQL",
                "19: Validar Sentencia if de xvariable con x condicion",
                "20: Validar que se haya escrito una frase con salto de linea",
                "21: Validar que se haya escrito una url con un video de youtube"
        );
    }
    public void procesar(ActionEvent event){
        int seleccion = listaEjer.getSelectionModel().getSelectedIndex();
        String texto=txtTexto.getText();
        String expresion="";
        switch (seleccion){
            case 0:{
                expresion="^[^_][^p]([a-zA-Z0-9]{3,})[q|w]$";
                break;
            }
            case 1:{
                expresion="(\\+[a-zA-Z]+)";
                break;
            }
            case 2:{
                expresion="(?!db).*";
                break;
            }
            case 3:{
                expresion="([a-zA-Z]*)(count)$";
                break;
            }
            case 4:{
                expresion="([a-zA-Z]{2,})[' ']([a-zA-Z]{2,})";
                break;
            }
            case 5:{
                expresion="([A-Fa-f0-9]{2})-([A-Fa-f0-9]{2})-([A-Fa-f0-9]{2})-([A-Fa-f0-9]{2})-([A-Fa-f0-9]{2})-([A-Fa-f0-9]{2})";
                break;
            }
            case 6:{
                expresion="^[A-Z]([A-Za-z]*)[A-Z]$";
                break;
            }
            case 7:{
                expresion="[0|1]{8}";
                break;
            }
            case 8:{
                expresion="[0-9A-Fa-f]+";
                break;
            }
            case 9:{
                expresion="[0-9][+|\\-|*|/][0-9]";
                break;
            }
            case 10:{
                expresion="([0-9]{2})(CG)([0-9]{4})";
                break;
            }
            case 11:{
                expresion="([A-Z]{4})([0-9]{6})[H|M]([A-Z]{2})([A-Z]{3})([A-Z0-9]{2})";
                break;
            }
            case 12:{
                expresion="^[$]([0-9]+)[.]([0-9]{2})(mxn)$";
                break;
            }
            case 13:{
                expresion="^[1-6]([0-9]{3})[' ']([0-9]{4})[' ']([0-9]{4})[' ']([0-9]{4})";
                break;
            }
            case 14:{
                expresion="[<]([a-z]+)[>](</)([a-z]+)[>]";
                break;
            }
            case 15:{
                expresion="#([A-Fa-f0-9]){6}";
                break;
            }
            case 16:{
                expresion="^(http://).+(.com)$";
                break;
            }
            case 17:{
                expresion="(INSERT INTO|insert into)[' ']([A-Za-z0-9]+)[' '](VALUES|values)(\\(('([A-Za-z0-9]+)'[,|''])+\\))[;]";
                break;
            }
            case 18:{
                expresion="(if)(\\(([A-Za-z0-9]+)([=|<|>]{1,2})([A-Za-z0-9]+)\\))(\\{.+\\})";
                break;
            }
            case 19:{
                expresion="([A-Za-z]+)[\\s]+([A-Za-z]+)";
                break;
            }
            case 20:{
                expresion="(https://www.youtube.com/watch\\?v=).+";
            }
        }
        Pattern patron=Pattern.compile(expresion);
        Matcher matcher=patron.matcher(texto);
        if (matcher.matches()){
            lblResultado.setText("Si cumple");
        }else{
            lblResultado.setText("No cumple");
        }
    }
}
