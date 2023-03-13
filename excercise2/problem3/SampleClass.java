class SampleClass{

    // defining mth1
    public void mth1(){
        // calling mth2 inside mth1
        mth2();
        System.out.println("caller");
    }
    public void mth2(){
        try{
            // line 1
            System.exit(0);
            // return;
        }
        catch(Exception e){
            System.out.println("catch-mth2");
        }
        finally{
            System.out.println("finally-mth2");
        }
    }

    public static void main(String[] args) {
        SampleClass sampleObject = new SampleClass();
        sampleObject.mth1();
    }

}
