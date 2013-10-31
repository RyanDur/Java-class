public class MatrixChecker {
    public boolean isSymmetrical(int[] arr) {
        for(int i = 0; i < arr.length/2; i++) {
            if(arr[i] != arr[arr.length-(i+1)]) {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetrical(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(i != j && arr[i][j] == arr[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTrangular(int[][] arr) {
	for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(i > j && arr[i][j] == 0) {
                    return true;
                }
            }
        }
	return false;
    }

    public boolean isTriangular(int[][] arr) {
        return false;
    }
}
