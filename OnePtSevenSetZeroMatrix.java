//practice 1.7 page 180

public class OnePtSevenSetZeroMatrix {
	public static void main(String[] args){
		int[][] matrix = new int[][] {{1,8,3},{3,1,2},{0,7,8},{9,7,8}};
		setZeros(matrix);
		
		int numOfRows = matrix.length;
		int numOfCols = matrix[0].length;
		for (int i=0; i<numOfRows; i++) {
			for (int j=0; j<numOfCols; j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
				if (j == numOfCols-1)
					System.out.print('\n');
			}
		}
	}
	
	public static void setZeros(int[][] matrix){
		int numOfRows = matrix.length;
		int numOfCols = matrix[0].length;
		
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;
		
		//check the zeros location
		for(int i=0; i<numOfRows; i++){
			for(int j=0; j<numOfCols; j++){
				//check the first row
				if (i==0 && matrix[i][j]==0)
					firstRowHasZero = true;
				//check the first column
				if (j==0 && matrix[i][j]==0)
					firstColHasZero = true;
				//check the elements not in first row or first column
				if (i>0 && j>0){
					if (matrix[i][j] == 0){
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}
		}
		
		//replace the rows and columns with 0s
		nullify(matrix, firstRowHasZero, firstColHasZero);
	}
	
	public static void nullify(int[][] matrix, boolean firstRowHasZero, boolean firstColHasZero){
		int numOfRows = matrix.length;
		int numOfCols = matrix[0].length;
		
		//set 0s in cols
		for(int i=1; i<numOfRows; i++){
			if(matrix[i][0] == 0){
				for(int j=1; j<numOfCols; j++)
					matrix[i][j] = 0;
			}
		}
		
		//set 0s in rows
		for(int k=1; k<numOfCols; k++){
			if(matrix[0][k] == 0){
				for(int l=1; l<numOfRows; l++)
					matrix[l][k] = 0;
			}
		}
		
		//set 0s in first row
		if(firstRowHasZero == true){
			for(int a=0; a<numOfCols; a++)
				matrix[0][a] = 0;
		}
		
		//set 0s in first col
		if(firstColHasZero == true){
			for(int b=0; b<numOfRows;b++)
				matrix[b][0] = 0;
		}
	}
}