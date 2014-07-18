// cracking the coding interview page 156. Use for trying static synchronized methods.

public class MyClass extends Thread {
	private String name;
	private MyObject myObj;
	
	//constructor
	public MyClass(MyObject obj, String n){
		name = n;
		myObj = obj;
	}
	
	public void run(){
		if (name.equals("1")) myObj.foo(name);
		else if (name.equals("2")) myObj.bar(name);
	}
}

