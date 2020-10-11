package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField txtFrase, txtSolucion;
    @FXML ComboBox comboBox;
    @FXML protected void initialize(){
        comboBox.getItems().addAll("CharAt", "CompareTo", "EqualsIgnoreCase", "IndexOf", "LastIndexOf", "Replace", "ReplaceFirst", "Split", "StartsWith", "EndsWith", "Substring");
    }

    public void evento(ActionEvent event){
        String texto=txtFrase.getText();
        switch (comboBox.getSelectionModel().getSelectedIndex()){
            case 0:{
                char res=texto.charAt(2);
                txtSolucion.setText(res+"");
                break;
            }
            case 1:{
                int res=texto.compareTo("5");
                txtSolucion.setText(res+"");
                break;
            }
            case 2:{
                boolean res=texto.equalsIgnoreCase("Hola");
                txtSolucion.setText(res+"");
                break;
            }
            case 3:{
                int res=texto.indexOf("o");
                txtSolucion.setText(res+"");
                /*int res=texto.indexOf("o", 2);
                txtSolucion.setText(res+"");*/
                break;
            }
            case 4:{
                int res=texto.lastIndexOf("a");
                txtSolucion.setText(res+"");
                /*int res=texto.lastIndexOf("a", 5);
                txtSolucion.setText(res+"");*/
                break;
            }
            case 5:{
                String res=texto.replace("a","☺");
                txtSolucion.setText(res);
                break;
            }
            case 6:{
                String res=texto.replaceFirst("o","♥");
                txtSolucion.setText(res);
                break;
            }
            case 7:{
                String[] res=texto.split("-");
                for (String ress:res) {
                    System.out.println(ress);
                }
                break;
            }
            case 8:{
                boolean res=texto.startsWith("ma");
                txtSolucion.setText(res+"");
                break;
            }
            case 9:{
                boolean res=texto.endsWith("ca");
                txtSolucion.setText(res+"");
                break;
            }
            case 10:{
                String res=texto.substring(5);
                txtSolucion.setText(res+"");
                //String res=texto.substring(0,5);
                //txtSolucion.setText(res+"");
                break;
            }
        }
    }
}
