/* 9.4 return all subsets of a set; this is my combinaorics solution
   Note that in this solution, 1 << set.size() to compute 2^n only works
   if n<=31, because we can not perform 31 bit shift on an 32 bit int */

import java.util.ArrayList;

public class NinePtFourFindAllSubsets {
    public static void main(String args[]){
	ArrayList<Integer> set = new ArrayList<Integer>();
	for (int i=1; i<4; i++) {
	    Integer anInteger = new Integer(i);
	    set.add(anInteger);
	}
	ArrayList<ArrayList<Integer>> allSubsetsArr = getSubsets(set);

	for (int i=1; i<allSubsetsArr.size(); i++){
	    ArrayList<Integer> subsetArr = allSubsetsArr.get(i);
	    for (int j=0;j<subsetArr.size();j++)
		System.out.print(subsetArr.get(j).intValue()+" ");
	    System.out.println();
	}
    }

    //the solution
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
	int uppperCap = 1 << set.size(); //compute 2^n
	ArrayList<ArrayList<Integer>> allSubsetsArr = new ArrayList<ArrayList<Integer>>();
	for(int i=0;i<upperCap;i++){
	    ArrayList<Integer> subset = convertIntToSet(i, set);
	    allSubsetsArr.add(subset);
	}
	return allSubsetsArr;
    }

    public static ArrayList<Integer> convertIntToSet(int combination, ArrayList<Integer> set){
	ArrayList<Integer> subsetArr = new ArrayList<Integer>();
	int setIndex = 0; //associate the binary with the set
	for (int i=combination; i>0; i>>=1){
	    if ((i&1)==1)
		subsetArr.add(set.get(setIndex));
	    setIndex++;
	}
	return subsetArr;  //when combination is 0000, just return empty arraylist(empty set)
    }

    
}