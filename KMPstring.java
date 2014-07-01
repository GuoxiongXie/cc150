/***************************************************************
 *
 *  Compilation:  javac KMP.java
 *  Execution:    java KMP pattern text
 *
 *  Reads in two strings, the pattern and the input text, and
 *  searches for the pattern in the input text using the
 *  KMP algorithm.
 *
 *  % java KMP abracadabra abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad 
 *  pattern:               abracadabra          
 *
 *  % java KMP rab abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad 
 *  pattern:         rab
 *
 *  % java KMP bcara abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad 
 *  pattern:                                   bcara
 *
 *  % java KMP rabrabracad abacadabrabracabracadabrabrabracad 
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:                        rabrabracad
 *
 *  % java KMP abacad abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern: abacad
 *
 ***************************************************************/

public class KMPstring {
    private final int R;       // the radix: standard ASCII+ extended ASCII defines 256 unique chars
    private int[][] dfa;       // the KMP automoton

    private String pat;        // or the pattern string

    // create the DFA from a String
    public KMPstring(String pat) {	//pat is the pattern which we want to find
        this.R = 256;			//standard ASCII+ extended ASCII defines 256 unique chars
        this.pat = pat;

        // build DFA from pattern, only from pattern, txt will only be used in search
        //j denotes the current state
        //X denotes the simulate state pat[1..j-1]
        int M = pat.length();
        dfa = new int[R][M]; 
        dfa[pat.charAt(0)][0] = 1; //since in for loop below, we start with j=1, we needa set the first matched char: if pat.charAt(0) = 'a', then dfa[97][0] = 1
        for (int X = 0, j = 1; j < M; j++) {	//j denotes the current state, control the columns
            for (int c = 0; c < R; c++) //c is all the possible chars in txt; control the rows
                dfa[c][j] = dfa[c][X];     // Copy mismatch cases. Imagine it starts at X and see what state it lands when seeing c
            
            dfa[pat.charAt(j)][j] = j+1;   // Set match case: in the inner for loop, we also copy the unmatched case to the matched case, so in this step, we update the match to jump to next state 
            							//if in state j and next char c == pat.charAt(j), go to state j+1 (now first j+1 chars of pattern have been matched)
            X = dfa[pat.charAt(j)][X];     // Update restart state before going to the next state j++. X is used for mismatch simulation, see line 49; when updating X, we also check where the state will be when at state X and seeing pat.charAt(j)
        } 
    } 

    // return offset of first match; N if no match
    public int search(String txt) {

        // simulate operation of DFA on text
        int M = pat.length();
        int N = txt.length();
        int i, j;
        
        //state = number of characters in pattern that have been matched
        for (i = 0, j = 0; i < N && j < M; i++) {  //j denotes the current state we are at. j=0 means start from state 0, no match at all
            j = dfa[txt.charAt(i)][j];		//the DFA stores j values to indicate the next state when a particular char is encountered
        }
        if (j == M) return i - M;    // found
        return N;                    // not found
    }


    // test client
    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];

        KMPstring kmp1 = new KMPstring(pat);
        int offset1 = kmp1.search(txt);


        // print results
        System.out.println("text:    " + txt);

        System.out.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            System.out.print(" ");
        System.out.println(pat);
        
        //print DFA:
        for (int i=0; i<kmp1.dfa.length; i++) {
        	for (int j=0; j<kmp1.dfa[0].length; j++)
        		System.out.print(kmp1.dfa[i][j]+" ");
        	System.out.println();
        }

    }
}
