public class ProblemSixMain {
    public static void main(String[] args) {
        try{
            Base base = new Derived();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}
