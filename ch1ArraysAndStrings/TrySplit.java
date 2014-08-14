public class TrySplit {
    public static void main(String[] args){
	String str = "  hello  there! How   u doin?";   //prints    ,,hello,,there!,How,,,u,doin?,
	String[] strArr = str.split(" ");

	for (String s : strArr)
	    System.out.print(s+",");
    }
}