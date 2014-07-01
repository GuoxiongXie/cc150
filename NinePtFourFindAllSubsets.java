/* 9.4 return all subsets of a set; this is my combinaorics solution */
import java.util.ArrayList;

public class NinePtFourFindAllSubsets {
    public static void main(String args[]){
	ArrayList<Integer> set = new ArrayList<Integer>();
	for (int i=1; i<11; i++) {
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
	
    }

    
}