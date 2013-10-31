public class CreatingMatrices {
    public static void main(String []args) {
        Matrix matrix = new Matrix(3,3);

        System.out.println(matrix);

        matrix.setRow(0,"1,2,3");
        System.out.println(matrix);

        matrix.setColumn(1, "4,5,6");
        System.out.println(matrix);

        matrix.setElement(2,2,10);
        System.out.println(matrix);

	matrix.prettyPrint();

	matrix.setMatrix("9,9,9;9,9,9;9,9,9");
	System.out.println(matrix);
    }
}
