public class Matrix {

    private int[][] matrix;

    public Matrix(int x,int y) {
        matrix = new int[x][y];
        initializeTo(1);
    }

    public void setElement(int x,int y, int value) {
        if(valid(x, y)) {
            matrix[x][y] = value;
        }
    }

    public void setRow(int row, String list) {
        String[] splitList = list.split(",");
        if(valid(row, splitList.length-1)) {
            for(int i = 0; i < matrix[row].length; i++) {
                matrix[row][i] = Integer.parseInt(splitList[i]);
            }
        }
    }

    public void setColumn(int column, String list) {
        String[] splitList = list.split(",");
        if(valid(column, splitList.length-1)) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][column] = Integer.parseInt(splitList[i]);
            }
        }
    }

    public void prettyPrint() {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
		System.out.print("\t"+ matrix[i][j] +"\t");
            }
	    System.out.println("");
        }
    }

    public String toString() {
        String result = "[";
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(j == matrix[i].length-1) {
                    result += matrix[i][j];
                } else {
                    result += matrix[i][j] + ",";
                }

            }
            if(i != matrix.length-1) {
                result += ";";
            }
        }
        return result + "]";
    }

    private boolean valid(int x, int y) {
        return matrix.length > x && matrix[x].length > y;
    }

    private void initializeTo(int value) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value;
            }
        }
    }
}
