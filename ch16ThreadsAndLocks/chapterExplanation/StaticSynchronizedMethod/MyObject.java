// cracking the coding interview page 156. Use for trying static synchronized methods.

public class MyObject {
	public static synchronized void foo(String name){
		try {
			System.out.println("Thread "+name+".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread "+name+".foo(): ending");
		} catch (InterruptedException exc){
			System.out.println("Thread " +name+": interrupted.");
		}
	}
	
	public static synchronized void bar(String name){
		try {
			System.out.println("Thread "+name+".bar(): starting");
			Thread.sleep(3000);
			System.out.println("Thread "+name+".bar(): ending");
		} catch (InterruptedException exc){
			System.out.println("Thread " +name+": interrupted.");
		}
	}
	
	public synchronized void nonStaticSynchronizedMethod(String name){
		try {
			System.out.println("Thread "+name+".nonStaticSynchronizedMethod(): starting");
			Thread.sleep(3000);
			System.out.println("Thread "+name+".nonStaticSynchronizedMethod(): ending");
		} catch (InterruptedException exc){
			System.out.println("Thread " +name+": interrupted.");
		}
	}
}