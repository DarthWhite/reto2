
import java.util.Vector;   

public class GradingSystem {


    // Constructor de la clase GradingSystem
    public GradingSystem() {
    }

    

    //Declarando vectores para responder las preguntas
    Vector<Float> cal = new Vector<Float>(){};
    Vector<Float> vecGeo = new Vector<Float>(){};
    Vector<Float> vecMat = new Vector<Float>(){};
    Vector<Float> vecInf = new Vector<Float>(){};
    float[] matGeo = new float[]{0,0,0,0,0,0};

    //Declarando los estudiantes
    String[] datos = new String[]{"armando","nicolas","daniel","maria","marcela","alexandra"};

    //Metodo question1 que responde la pregunta ¿Cuál es la varianza de las calificaciones para todo el grupo?
    public float stat1(){
        //Varianza
        GradingSystem.varianza var_res = new varianza();
        float varResultado=var_res.var(cal);
        return varResultado;
    }
    //Metodo question2 que responde la pregunta ¿Cuántos exámenes tienen una calificación Excelente?
    public int stat2(){
        //Condicional Para la pregunta ¿Cuántos exámenes tienen una calificación Excelente?
        GradingSystem.funciones objCal = new funciones();
        int notaExc=0;
        for ( Float x : cal){
            String z = objCal.rangoNotas(x);
            if(z.equals("Excelente")){
                notaExc=notaExc+1;
            }
        }
        return notaExc;
    }
    //Metodo question3 que responde la pregunta ¿Cuál es la materia con el mejor desempeño promedio para el género femenino?
    public String stat3(){
        funciones objCal = new funciones();
        //Sumando vectores para mujeres
        float calGeo = objCal.sum(vecGeo)/vecGeo.size();
        float calMat = objCal.sum(vecMat)/vecMat.size();
        float calInf = objCal.sum(vecInf)/vecInf.size();
        //Creando vector para definir cual es la calificacion mayor        
        float[] vecMaterias = new float[]{calGeo,calMat,calInf};
        
        //Respues a ¿Cuál es la materia con el mejor desempeño promedio para el género femenino?
        String matFem="";
        if (objCal.num_max(vecMaterias) == vecMaterias[0]){
            matFem="geografia";
        }else if (objCal.num_max(vecMaterias) == vecMaterias[1]){
            matFem="matematicas";
        }else if (objCal.num_max(vecMaterias) == vecMaterias[2]){
            matFem="informatica";
        }
        return matFem;
    }
    //Metodo question4 que responde la pregunta ¿Cuál es el estudiante con el mejor desempeño para la materia geografía?
    public String stat4(){
        funciones objCal = new funciones();
        //¿Cuál es el estudiante con el mejor desempeño para la materia geografía?
        float geoAlta=objCal.num_max(matGeo);
        
        int geoPos= 0;//Variable para asignar la posicion del alumno

        //Ciclo for para encontrar la posicion del alumno
        for (int i=0;i<matGeo.length;i++){
            if (matGeo[i]==geoAlta){
                geoPos=i;
            }
        }
        return datos[geoPos];
    }



    //---------------------------------------------------------------------------
    //Clase para encontrar No. Mayor y Tipo de nota
    public static class funciones{
        //Funcion para encontrar la cantidad de notas excelentes
        static String rangoNotas(float datos){
            if (datos>=0 && datos<=30){
                return "Deficiente";
            }else if (datos>=30 && datos<=60){
                return "Insuficiente";
            }else if (datos>=60 && datos<=80){
                return "Regular";
            }else if (datos>=80 && datos<=90){
                return "Sobresaliente";
            }else if (datos>=80 && datos<=100){
                return "Excelente";
            }
            return null;
        }
        //Funcion para encontrar el numero maximo en un vector
        static Float num_max(float[] numeros){
            if (numeros.length >0){
                Float mayor = numeros[0];
                
                for (Float n : numeros){
                    if (n > mayor){
                        mayor = n;
                    }
                }               
                return mayor;
            }else{
                return null;
            }
        }
        //Funcion para sumar vectores
        static Float sum(Vector<Float> vector){
            float total=0;
            for (int i=0;i<vector.size();i++){
                total=vector.elementAt(i)+total;
            }
            return total;

        }
    }
    public static class varianza{
        static funciones objVar = new funciones();
        
        //Funcion para varianza
        static float var(Vector<Float> varianza ){
            float calculo = 0;
            int n = varianza.size();
            float promedio = objVar.sum(varianza)/n;

            for (int i=0; i<n; i++){
                Float suma =(float) Math.pow(varianza.elementAt(i)-promedio, 2);
                calculo = calculo + suma;
            }
            
            
            return calculo/n;

        }
    }
    
    


}