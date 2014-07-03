public class FindPrimeUnderMax {
	public static void main(String[] args) {
		boolean[] primeArray = sieveOfEratosthenes(28);
		
		int len = primeArray.length;
		StringBuffer primeBuffer = new StringBuffer();
		
		for (int i=0; i<len; i++){
			if (primeArray[i]==true){
				primeBuffer.append(i);
				primeBuffer.append(' ');
			}
		}
		
		System.out.println(primeBuffer.toString());
	}
	
	public static boolean[] sieveOfEratosthenes(int max){
		boolean[] flags = new boolean[max+1];
		java.util.Arrays.fill(flags, Boolean.TRUE);
		flags[0] = false;
		flags[1] = false;
		
		for (int i=2; i*i<=max; i++){
			if (flags[i]==false)
				continue;
			for (int j=i; i*j<=max; j++){
				flags[i*j] = false;
			}
		}
		
		return flags;
	}
}