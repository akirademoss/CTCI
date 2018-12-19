public class RotateMatrix{
	
	public static void main(String[] args){
		
		int[][] mat = {{0,1,2},{3,4,5}};
		
		rotate90deg(mat);
		
	}
	
	public static void rotate90deg(int[][] mat1){
		int mat2[][] = new int[mat1[0].length][mat1.length]; 
		for(int i = 0; i < mat1.length; i++){
			for(int j = 0; j < mat1[0].length; j++){
				mat2[j][mat1.length - 1 - i] = mat1[i][j];
			}
		}
		printMatrix(mat2);
	}
	
	private static void printMatrix(int[][] mat){
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j] + ", ");
			}
			System.out.println("\n");
		}
	}
}