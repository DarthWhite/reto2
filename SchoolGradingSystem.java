import java.util.Scanner;

    

public class SchoolGradingSystem extends GradingSystem {


    // Constructor de la clase SchoolGradingSystem
    public SchoolGradingSystem() {
    }

    //Declarando el metodo readData
    public void loadData() {        
        int entrada;
        //Creando la entrada al sistema
        Scanner captura=new Scanner(System.in);
    
        //Capturando entradas de calificaciones
        String enteroString = captura.nextLine();
        entrada = Integer.parseInt(enteroString);  
        
        //Vector para la matriz principal
        float[][] notas = new float[entrada][4];
        
        for (int i=0;i<entrada;i++){
            String entradaCal = captura.nextLine();
            String[] calificaciones = entradaCal.split(" ");
            for(int j=0;j<calificaciones.length;j++){
                 
                notas[i][j] = Float.parseFloat(calificaciones[j]);
            }
        }

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
        }
    }
    

}


