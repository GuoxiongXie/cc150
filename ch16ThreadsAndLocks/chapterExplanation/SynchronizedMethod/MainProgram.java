// cracking the coding interview page 156. Use for trying static synchronized methods.

public class MainProgram {
	
	public static void main(String[] args) {
		/*
		//calling the same synchronized method on two different objects, can execute simultaneously
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();
		
		MyClass thread1 = new MyClass(obj1, "1");
		MyClass thread2 = new MyClass(obj2, "2");
		
		thread1.start();
		thread2.start();
		*/
		
		/*
		//calling the same synchronized method on the same object, can NOT execute simultaneously
		MyObject commonObj = new MyObject();
		
		MyClass thread3 = new MyClass(commonObj, "3");
		MyClass thread4 = new MyClass(commonObj, "4");
		
		thread3.start();
		thread4.start();
		*/
		
		/*
		//calling 2 different synchronized method on the same object, can NOT execute simultaneously
		MyObject commonObj = new MyObject();
		
		MyClass thread1 = new MyClass(commonObj, "1");
		MyClass thread2 = new MyClass(commonObj, "2");
		
		thread1.start();
		thread2.start();
		*/
		
		//calling one synchronized method and one non-synchronized method on the same object, CAN execute simultaneously
		//just remove one of the "synchronized" in function foo or bar to test
		MyObject commonObj = new MyObject();
				
		MyClass thread1 = new MyClass(commonObj, "1");
		MyClass thread2 = new MyClass(commonObj, "2");
		
		thread1.start();
		thread2.start();
	}
	
}