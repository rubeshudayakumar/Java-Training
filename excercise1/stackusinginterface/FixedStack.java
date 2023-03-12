package dayThree.daythree.excercise3;

public class FixedStack implements Stack{
    public static int size = 5;

    public int arr[],top;

    FixedStack(){
        this.top = 0;
        this.arr = new int[size];
        top = 0;
    }

    @Override
    public void push(int ele) {
        if(top<size){
            arr[top++] = ele;
            System.out.println("Element"+ele+" pushed!");
        }
        else{
            top = size;
            System.out.println("Stack overflow");
        }
        
    }

    @Override
    public void pop() {
        if(top>0){
            top--;
            System.out.println("Element"+arr[top]+" popped");
        }
        else{
            top = 0;
            System.out.println("Stack underflow");
        }
    }

    public static void main(String[] args) {
        FixedStack fs = new FixedStack();
        
        // pushing the elements
        fs.push(1);
        fs.push(2);
        fs.push(3);
        fs.push(4);
        fs.push(5);

        // will throw the message because fixed stack size
        fs.push(6);

        // popping the elements
        fs.pop();
        fs.pop();
        fs.pop();
        fs.pop();
        fs.pop();

        // will throw message because of underflow
        fs.pop();

    }

}
