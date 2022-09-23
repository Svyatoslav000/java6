public class matrici {
    public static void main(String[] args) {
        int[][] mat1 = new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        int[][] mat2 = new int[][]
                {
                        {9, 8, 7},
                        {6, 5, 4},
                        {3, 2, 1}
                };
        meth4(mat1,mat2);//пункт а-сложение+вычитание

        int n=2;
        meth5(mat1,n);//пункт б - умножение на число


        meth6(mat1,mat2);//пункт ц-умножение матриц


        meth7(mat1);//пункт д - трансонированная матрица

        int m=3;
        meth8(mat1,m);//пункт е - возведение в степень
    }
    static void meth4(int[][] mat1,int[][] mat2){//сложение и вычитание матриц
        int[][] matsum = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matsum[i][j] = mat1[i][j] + mat2[i][j];
                System.out.print(matsum[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matsum[i][j] = mat1[i][j] - mat2[i][j];
                System.out.print(matsum[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



    static void meth5(int[][] mat1, int n){//умножение на число
        int[][] matnew = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matnew[i][j] = mat1[i][j] * n;
                System.out.print(matnew[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void meth6(int[][] mat1,int[][] mat2){//умножение матриц
        int[][] matproizv = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k=0;k<3;k++){
                    matproizv[i][j]+= mat1[i][k] * mat2[k][j];
                }
                System.out.print(matproizv[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void meth7(int[][] mat1){//трфнспонированние
        int[][] mattransp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mattransp[i][j] = mat1[j][i];
                System.out.print(mattransp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void meth8(int[][] mat1,int n) {//возведение в степень
        int[][] matproizv = new int[3][3];
        int[][] matproizv3 = new int[3][3];
        int m = n;
        while (n != 1) {
            int[][] matproizv2 = new int[][]
                    {
                            {0, 0, 0},
                            {0, 0, 0},
                            {0, 0, 0}
                    };
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j<3; j++) {
                    for (int k = 0; k<3; k++) {
                        if (m - n >= 1){
                            matproizv2[i][j] += matproizv[i][k]*mat1[k][j] ;
                        } else if (m==n){
                            matproizv[i][j] += mat1[i][k]*mat1[k][j];
                        }

                    }
                }
            }
            n--;
            matproizv3=matproizv2;
        }
        if (m==2){
            for (int i = 0; i<3; i++) {
                for (int j = 0; j<3; j++) {
                    System.out.print(matproizv[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            for (int i = 0; i<3; i++) {
                for (int j = 0; j<3; j++) {
                    System.out.print(matproizv3[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
