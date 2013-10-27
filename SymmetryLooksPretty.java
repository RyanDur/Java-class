public class SymmetryLooksPretty {

    public static void main(String []args) {
        MatrixChecker mc = new MatrixChecker();
        int[] symmetrical = {1,2,3,2,1};
        int[] notSymmetrical = {1,2,3,4,5};

        System.out.println(mc.isSymmetrical(symmetrical));
        System.out.println(mc.isSymmetrical(notSymmetrical));

        int[][] biSysmmetrical = {{1,2,6},{3,4,5},{6,7,8}};
        int[][] biNotSymmetrical = {{5,2,6},{4,2,9},{3,2,7}};
        System.out.println(mc.isSymmetrical(biSysmmetrical));
        System.out.println(mc.isSymmetrical(biNotSymmetrical));

        int[][] triangular = {{1,1,1},{0,1,1},{1,1,1}};
        int[][] notTriangular = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(mc.isTrangular(triangular));
        System.out.println(mc.isTrangular(notTriangular));
    }
}
