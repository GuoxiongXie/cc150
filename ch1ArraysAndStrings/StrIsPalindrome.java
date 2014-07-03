public class StrIsPalindrome {
	public static boolean isPalindrome(String str) {
		if(str == null)
			return false;
		int strLength = str.length();
		
		for (int i=0; i<=(strLength-1-i); i++){
			
			//to make it case insensitive:
			char frontChar = Character.toLowerCase(str.charAt(i));
			char tailChar = Character.toLowerCase(str.charAt(strLength-1-i));
			
			if (!(frontChar == tailChar))
				return false;
		}
		return true;
	}
	
	
	public static boolean isPalindromeSpace(String str){
		if (str == null)
			return false;
		int strLength = str.length();
		int i=0;
		int tail = strLength-1;
		while (i<=tail){
			while (str.charAt(i)==' ')
				i++;
			while (str.charAt(tail)==' ')
				tail--;
			if (i>tail)
				break;
			if (!(str.charAt(i) == str.charAt(tail)))
				return false;
			
			i++;
			tail--;
		}
		return true;
	}
	
	public static void main (String[] args) {
		System.out.println(isPalindromeSpace("dOoD"));
	}
}