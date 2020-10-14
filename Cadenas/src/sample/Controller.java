package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {
    @FXML Label lblLineas;
    @FXML TextArea txtReseta;
    @FXML protected void initialize(){
        try {
            File f=new File("./src/sample/archivo.txt");
            BufferedReader br=new BufferedReader(new FileReader(f));
            String texto= "";
            while ((texto=br.readLine())!=null){
                txtReseta.appendText("\n"+texto);
            }
        }catch (Exception e){
            txtReseta.setText(e.getMessage());
        }
    }
    public void procesar(ActionEvent event){
        String[] arregloLineas = txtReseta.getText().split("\n");
        lblLineas.setText("Lineas: "+arregloLineas.length);
        Boolean encendido = false;
        for (int x=0;x<arregloLineas.length;x++){
            if (arregloLineas[x].contains("queso")){
                String[] arr2 = arregloLineas[x].split(" ");
                System.out.println(arr2[0]);
            }
            if (arregloLineas[x].contains("manzanas")){
                String[] arr2 = arregloLineas[x].split(" ");
                System.out.println("unidad "+arr2[1]);
            }
            if (encendido){
                System.out.println(arregloLineas[x]);
            }
            if (arregloLineas[x].contains("***")){
                encendido=true;
            }
        }
    }
}
