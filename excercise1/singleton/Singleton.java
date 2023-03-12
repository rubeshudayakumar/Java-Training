package excercise1.singleton;

public class Singleton {
    public static Singleton obj = null; 

    int size = 5;
    
    private Singleton(){
        System.out.println("Object constructed");
    }

    public static Singleton createObject(){
        if(obj==null){
            obj = new Singleton();
            return obj;
        }
        System.out.println("Previous object returned");
        return obj;
    }

    public void printMessage(){
        System.out.println("welcome to singleton class! the value is "+size);
    }

    public static void main(String[] args) {
        Singleton singletonObject = Singleton.createObject();
        singletonObject.printMessage();

        singletonObject.size = 10; 

        Singleton anotherSingletonObject = Singleton.createObject();
        anotherSingletonObject.printMessage();

    }
    
}
