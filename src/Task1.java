public class Task1 {
    public static void main(String[] args) {
        int[][] matrix1 = createIdentityMatrix(5);
        int[][] matrix2 = createNullMatrix(5);
        int[][] matrix3 = summMatrix(matrix1, matrix1);
        int[][] matrix4 = multiplicationMatrix(matrix1, matrix3);
        int[][] matrix5 = multiplicationScalarMatrix(matrix3, 8);
        printMatrix(matrix1);
        printMatrix(matrix2);
        printMatrix(matrix3);
        printMatrix(matrix4);
        printMatrix(matrix5);
        System.out.println(determinantOfMatrix(matrix5));

    }

    static int[][] createIdentityMatrix(int matrixLenght) {
        int[][] matrix = new int[matrixLenght][matrixLenght];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    static int[][] createNullMatrix(int matrixLenght) {
        int[][] matrix = new int[matrixLenght][matrixLenght];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    static int[][] summMatrix(int matrix1[][], int matrix2[][]) {
        int[][] sMatrix = new int[matrix1.length][matrix1[0].length];
        if (matrix1.length == matrix2.length) {
            for (int i = 0; i < sMatrix.length; i++) {
                for (int j = 0; j < sMatrix.length; j++) {
                    sMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            return sMatrix;
        } else {
            throw new RuntimeException("матрицы разного размера, невозможно сложить");
        }
    }

    static int[][] multiplicationMatrix(int matrix1[][], int matrix2[][]) {
        int[][] mMatrix = new int[matrix1.length][matrix1[0].length];
        if (matrix1.length == matrix2[0].length) {
            for (int i = 0; i < mMatrix[0].length; i++) {
                for (int j = 0; j < mMatrix.length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {
                        mMatrix[i][j] = mMatrix[i][j] + matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            return mMatrix;
        } else {
            throw new RuntimeException("длина столбца первой матрицы не равна" +
                    " длине строки второй матрицы, " +
                    "невозможно выполнить умножение");
        }
    }

    static int[][] multiplicationScalarMatrix(int matrix[][], int scalar) {
        int[][] scalarMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                scalarMatrix[i][j] = matrix[i][j] * scalar;
            }
        }
        return scalarMatrix;
    }

    static int determinantOfMatrix(int matrix[][]) {
        if (matrix.length == matrix[0].length) {
            int result = 0;
            if (matrix.length == 1) {
                result = matrix[1][1];
                return result;
            } else if (matrix.length == 2) {
                result = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
                return result;
            } else {
                for (int i = 0; i < matrix.length; i++) {
                    int[][] temp = new int[matrix.length - 1][matrix.length - 1];
                    for (int j = 1; j < matrix.length; j++) {
                        for (int k = 0; k < matrix.length; k++) {
                            if (k < i) {
                                temp[j - 1][k] = matrix[j][k];
                            } else if (k > i) {
                                temp[j - 1][k - 1] = matrix[j][k];
                            }
                        }
                        result += matrix[0][i] * Math.pow(-1, (int) i) * determinantOfMatrix(temp);
                    }
                }
                return result;
            }
        } else {
            throw new RuntimeException("неправильный ввод, детерминант определён только для квадратных матриц");
        }
    }
    static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return;
    }
}


