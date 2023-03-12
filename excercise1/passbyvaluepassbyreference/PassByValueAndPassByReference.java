package excercise1.passbyvalueandpassbyreference;

public class PassByValueAndPassByReference {
	
	public static void passByValue(byte b,short s,int i,long l,float f,double d,char c,boolean bool) {
		b = 15;
		s = 15;
		i = 15;
		l = 15l;
		f = 15.5f;
		d = 15.5d;
		c = 'a';
		bool = false;
	}
	
	public static void passByReference(ObjectValue obj,int[] arr) {
		obj.size = 15;
		arr[0] = 0;
	}
	
	public static void main(String[] args) {
		byte b = 10;
		short s = 10;
		int i = 10;
		long l = 10l;
		float f = 10.0f;
		double d = 10.5d;
		char c = 'b';
		boolean bool = true;
		
		System.out.println("<-----Values before call by value----->");
		
		System.out.println("byte : b ->"+b);
		System.out.println("short : s ->"+s);
		System.out.println("int : i ->"+i);
		System.out.println("long : l ->"+l);
		System.out.println("float : f ->"+f);
		System.out.println("double : d ->"+d);
		System.out.println("char : c ->"+c);
		System.out.println("boolean : bool ->"+bool);
		
		passByValue(b, s, i, l, f, d, c, bool);
		
		System.out.println("<-----Values after call by value----->");
		
		System.out.println("byte : b -> "+b);
		System.out.println("short : s -> "+s);
		System.out.println("int : i ->"+i);
		System.out.println("long : l ->"+l);
		System.out.println("float : f ->"+f);
		System.out.println("double : d ->"+d);
		System.out.println("char : c ->"+c);
		System.out.println("boolean : bool ->"+bool);
		
		ObjectValue obj = new ObjectValue(10);
		int arr[] = new int[] {1,2,3,4,5};
		System.out.println("<-----Values before call by reference----->");
		
		System.out.println("Array values.....");
		
		for(int j=0;j<arr.length;j++) {
			System.out.print(arr[j]+" ");
		}
		
		System.out.println("\nObject value : "+obj.size);
		
		passByReference(obj, arr);
		
		System.out.println("<-----Values after call by reference----->");
		
		System.out.println("Array values.....");
		
		for(int j=0;j<arr.length;j++) {
			System.out.print(arr[j]+" ");
		}
		
		System.out.println("\nObject value : "+obj.size);
		
	}
}

