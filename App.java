
public class App{
    public static void main(String[] args){
        SchoolGradingSystem loadData;

        loadData = new SchoolGradingSystem();
        loadData.loadData();

        System.out.printf("%.2f\n",loadData.stat1());
        System.out.print(loadData.stat2()+"\n");
        System.out.println(loadData.stat3());
        System.out.println(loadData.stat4());

        
        
    }


}