package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Controller {
    @FXML
    TextArea txtReceta, txtIngredientes, txtPreparacion, txtPreguntas;
    @FXML protected void initialize(){
        try {
            File f=new File("./src/sample/Receta.txt");
            BufferedReader br=new BufferedReader(new FileReader(f));
            String txt= "";
            while ((txt=br.readLine())!=null){
                txtReceta.appendText("\n"+txt);
            }
        }catch (Exception e){
            txtReceta.setText(e.getMessage());
        }
    }
    public void procesar (ActionEvent event){
        String[] arregloLineas = txtReceta.getText().split("\n");
        Boolean i1 = false;
        Boolean i2=false;
        int grchile=0;
        int can=0;
        double ing = 0;
        ArrayList<String> prueba = new ArrayList<String>();
        for (int y=0;y<arregloLineas.length;y++) {
            if (i2){
                txtPreparacion.appendText(arregloLineas[y]+"\n");
            }
            if (arregloLineas[y].contains("Preparación")){
                i2=true;
            }else if(arregloLineas[y].contains("PERSONAS")){
                String[] arr2=arregloLineas[y].split(" ");
                can=Integer.parseInt(arr2[0]);
                txtPreguntas.appendText("El cuarto paso del procedimiento es: "+arregloLineas[27]+"\n");
                txtPreguntas.appendText("--------------------------------------------------"+"\n");
                break;
            }
        }
        for (int x=0;x<arregloLineas.length;x++) {
            if (i1){
                txtIngredientes.appendText(arregloLineas[x]+"\n");
                String[] arr3= arregloLineas[x].split(" ");
                if (arr3[0].equals("sal")){
                    txtPreguntas.appendText("sal"+"\n");
                    txtPreguntas.appendText("--------------------------------------------------"+"\n");
                    txtPreguntas.appendText("Ingredientes asados: " + prueba + "\n");
                    txtPreguntas.appendText("--------------------------------------------------"+"\n");
                }else{
                    ing=Double.parseDouble(arr3[0]);
                    ing=(ing*can)/60;
                    txtPreguntas.appendText(arregloLineas[x].replace(arr3[0],ing+""));
                    txtPreguntas.appendText("\n");
                }

            }
            if (arregloLineas[x].contains("_______")){
                i1=true;
            }else if(arregloLineas[x].contains("sal")){
                txtPreguntas.appendText("El total de gramos de chile es: " +grchile+"\n");
                break;
            }
            if (arregloLineas[x].contains("chile")){
                String[] arr1 = arregloLineas[x].split(" ");
                grchile+= Integer.parseInt(arr1[0]);
            }
            if (arregloLineas[x].contains("asado") || arregloLineas[x].contains("asada") || arregloLineas[x].contains("asadas")|| arregloLineas[x].contains("asados")) {
                prueba.add(arregloLineas[x]);
            }
        }
    }
}
