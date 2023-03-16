package problem2;

public class Sample {
	// defining mth1
    public void mth1(){
        // calling mth2 inside mth1
        mth2();
        System.out.println("caller");
    }
    public void mth2(){
        try{
            // line 1
            throw new ArithmeticException();
//            return;
        }
        catch(Exception e){
            System.out.println("catch-mth2");
        }
        finally{
            System.out.println("finally-mth2");
        }
    }

    public static void main(String[] args) {
        Sample sampleObject = new Sample();
        sampleObject.mth1();
    }

}
