package probloem1;

public class OddOrEven {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("HI HELLo");
            int number = 1;
            while(number<=100){
                if(number%2==0){
                    System.out.println("Even number : "+number++);
                }
            }
        }).start();
    }
}
