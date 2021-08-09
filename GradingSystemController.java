import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GradingSystemController extends SchoolGradingSystem{
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEntryInt;

    @FXML
    private TextArea txtEntryFloat;

    @FXML
    private Button btnCalculate;

    @FXML
    private TextArea txtResult;

    @FXML
    void calculate(ActionEvent event) {        
        //Capturando entradas de calificaciones
        int entrada = Integer.parseInt(this.txtEntryInt.getText()); 
        
        //Vector para la matriz principal
        float[][] notas = new float[entrada][4];
                
        for (int i=0;i<entrada;i++){
            String prueba=this.txtEntryFloat.getText();
            String[] calificacion = prueba.split("\n");//Creando un vector apartir de un split en salto de linea
            
            for (int x=0;x<calificacion.length;x++){
                String[] calificaciones = calificacion[x].split(" "); //Creando la matriz  partir del vector de salto de linea con un split
                for(int j=0;j<calificaciones.length;j++){
                    
                    notas[x][j] = Float.parseFloat(calificaciones[j]);//Asignando valores a la matriz
                }
            }
        }
        //Condcional para crear vectores
        for(float[] x : notas){
            //Organizando vector para varianza
            float var = x[3];
            cal.add(var);
            //Organizando vector para la pregunta ¿Cuál es la materia con el mejor desempeño promedio para el género femenino?
            if(x[1]==1.0){
                if (x[2] == 1.0){
                    vecGeo.add(x[3]);
                }
                else if (x[2] == 2.0){
                    vecMat.add(x[3]);
                }
                else if (x[2] == 3.0){
                    vecInf.add(x[3]);
                }
            }
            //Organizando vector para ¿Cuál es el estudiante con el mejor desempeño para la materia geografía?
            if (x[0] == 1.0 && x[2] == 1.0){
                matGeo[0]=matGeo[0]+x[3];                
            }else if (x[0] == 2.0 && x[2] == 1.0){
                matGeo[1]=matGeo[1]+x[3];                
            }else if (x[0] == 3.0 && x[2] == 1.0){
                matGeo[2]=matGeo[2]+x[3];                
            }else if (x[0] == 4.0 && x[2] == 1.0){
                matGeo[3]=matGeo[3]+x[3];                
            }else if (x[0] == 5.0 && x[2] == 1.0){
                matGeo[4]=matGeo[4]+x[3];                
            }else if (x[0] == 6.0 && x[2] == 1.0){
                matGeo[5]=matGeo[5]+x[3];
            }            
        }//FIn condicional para crear vectores  

        SchoolGradingSystem obj1 = new SchoolGradingSystem();
        
        Float r1 = obj1.respuesta1();

        this.txtResult.setText(r1+"Casi pero no");



    }

    

    @FXML
    void initialize() {
        assert txtEntryInt != null : "fx:id=\"txtEntryInt\" was not injected: check your FXML file 'GradingSystemController.fxml'.";
        assert txtEntryFloat != null : "fx:id=\"txtEntryFloat\" was not injected: check your FXML file 'GradingSystemController.fxml'.";
        assert btnCalculate != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'GradingSystemController.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GradingSystemController.fxml'.";

    }
}
