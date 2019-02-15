package Chapter1;

public class Q7 {
	/*****   Include the main() for testing and debugging  *****/
	public static void main(String[] args){
		
		System.out.println("MxN matrix:");
		System.out.println("0, 1, 2,\n3, 4, 5,\n");

		

		int[][] mat = {{0,1,2},{3,4,5}};
		
		System.out.println("MxN matrix rotated 90 degrees:");
		rotate90deg(mat);
		
	}
	
	// Q7 solution
	public static void rotate90deg(int[][] mat1){
		int mat2[][] = new int[mat1[0].length][mat1.length]; 
		for(int i = 0; i < mat1.length; i++){
			for(int j = 0; j < mat1[0].length; j++){
				mat2[j][mat1.length - 1 - i] = mat1[i][j];
			}
		}
		printMatrix(mat2);
	}
	
	//print matrix
	private static void printMatrix(int[][] mat){
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j] + ", ");
			}
			System.out.println("\n");
		}
	}
}
