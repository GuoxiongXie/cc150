public class MyKMP {

    public static int matchPattern(String pat, String txt) {
        int[][] fsm = new int[256][pat.length()];
        buildFsm(pat,fsm);
        return findMatchPosition(txt, pat, fsm);
    }

    public static void buildFsm(String pat, int[][] fsm){
        //start at state j=0 first, initialize all to 0s                                                                                                                                                    
        fsm[pat.charAt(0)][0] = 1;

        //for j>0, the idea is that we've match 1~j-1, so we can simulate the fsm to fill in the next step                                                                                                  
        //including mismatch and match cases                                                                                                                                                                
        int patLength = pat.length();
        int simState = 0;

        for (int j=1; j<patLength;j++) {
            for (int i=0; i<256; i++){
                fsm[i][j] = fsm[i][simState]; //mismatch case                                                                                                                                               
            }
            fsm[pat.charAt(j)][j] = j+1; //match case                                                                                                                                                       
            simState = fsm[pat.charAt(j)][simState]; //update simState                                                                                                                                      
        }
    }

    public static int findMatchPosition(String txt, String pat, int[][] fsm){
        int txtLen = txt.length();
        int patLen = pat.length();
        int curState = 0;

        for (int i=0; i<txtLen; i++) {
            curState = fsm[txt.charAt(i)][curState];
            if (curState == patLen)
                return i-patLen+1;
        }
        return -1; //-1 means no match                                                                                                                                                                      
    }

    public static void main(String args[]) {
        System.out.println(matchPattern("jake", "abcdefjakek"));
    }
}
