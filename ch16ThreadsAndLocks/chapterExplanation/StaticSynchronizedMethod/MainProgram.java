// cracking the coding interview page 156. Use for trying static synchronized methods.

public class MainProgram {
	
	public static void main(String[] args) {
		/*
		//calling the synchronized method on two different objects, can execute simultaneously
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();
		
		MyClass thread1 = new MyClass(obj1, "1");
		MyClass thread2 = new MyClass(obj2, "2");
		
		thread1.start();
		thread2.start();
		*/
		
		/*
		//calling the static synchronized methods (both foo and bar) on the same object, can NOT execute simultaneously
		MyObject commonObj = new MyObject();
		
		MyClass thread1 = new MyClass(commonObj, "1");
		MyClass thread2 = new MyClass(commonObj, "2");
		
		thread1.start();
		thread2.start();
		*/
		
		/*
		//calling the static synchronized methods (both foo and bar) on different objects, still can NOT execute simultaneously
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();		
		
		MyClass thread1 = new MyClass(obj1, "1");
		MyClass thread2 = new MyClass(obj2, "2");
				
		thread1.start();
		thread2.start();	
		*/
		
		//calling a static synchronized method (foo)
		//and calling a non-staic synchronized method using a different object, 
		//CAN execute simultaneously
		//conclusion: class lock and instance lock are separately obtained, they are controlling different levels
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();		
		
		MyClass thread1 = new MyClass(obj1, "1");
		MyClass thread2 = new MyClass(obj2, "2");
				
		thread1.start();
		thread2.start();
		
		/*
		//calling a static synchronized method (foo) and calling a non-static synchronized method on the same object, CAN execute simultaneously
		//conclusion: the class level lock and instance/object level lock are separate.
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();		
		
		MyClass thread1 = new MyClass(obj2, "1");
		MyClass thread2 = new MyClass(obj2, "2");
				
		thread1.start();
		thread2.start();
		*/
	}
	
}