package dayThree.daythree.excercise3;

public class DynamicStack implements Stack {

    int arr[],top;

    DynamicStack(){
        this.top = -1;
        this.arr = new int[0];
    }

    @Override
    public void push(int ele) {
        int temp[] = arr;
        arr = new int[arr.length+1];
        arr[++top] = ele;
        for(int i=0;i<arr.length-1;i++){
            arr[i] = temp[i];
        }
        System.out.println("Element "+ele+" pushed");
    }

    @Override
    public void pop() {
        if(top<0){
            
            System.out.println("Stack under flow");
        }else{
            System.out.println("Element "+arr[top]+" popped");
            top--;
        }
    }
    public static void main(String[] args) {
        DynamicStack ds = new DynamicStack();

        ds.push(1);
        ds.push(2);
        ds.push(3);
        ds.push(4);

        ds.pop();
        ds.pop();
        ds.pop();
        ds.pop();
        ds.pop();

    }
}
