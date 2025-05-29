import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        //определение треугольника в виде массива чисел
        int size = 8;
        Random rand = new Random();
        int[][] triangle = new int[size][];
        // определение размеров строк
        for (int i = triangle.length - 1; i >= 0; i--) {
            int size1 = i + 1;
            triangle[i] = new int[size1];
        }
        // заполнение массива
        for (int i = triangle.length - 1; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = rand.nextInt(100);
            }
        }
        outputArray(triangle);
        System.out.println(maxWay(triangle));
    }

    static void outputArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            // пробелы для симметричного вывода
            for (int k = (array.length - i); k > 0; k--) {
                System.out.print("  ");
            }
            for (int j = 0; j < array[i].length; j++) {
                // условия для вывода чисел первого десятка(0-9):
                // дополнительный пробел в перед числом во второй половине строки
                // дополнительный пробел после числа в первой половине строки
                if (array[i][j] < 10 && j >= array[i].length / 2) {
                    System.out.print("  " + array[i][j] + " ");
                } else if (array[i][j] < 10 && j < array[i].length / 2) {
                    System.out.print(" " + array[i][j] + "  ");
                    // вывод двузначных чисел
                } else {
                    System.out.print(" " + array[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static String maxWay(int[][]array) {
        // создание массива строк для определения пути
        String[][] way = new String[array.length][];
        for (int i = array.length - 1; i >= 0; i--) {
            int size1 = i + 1;
            way[i] = new String[size1];
        }
        // заполнение последней строки массива "" для корректного вывода
        int w = array.length - 1;
        for (int j = 0; j < way[w].length;j++) {
            way[w][j] = " ";
        }
        // заполнение массива снизу вверх значениями сумм(выбираем маскимальную из 2х)
        for (int i = (array.length - 1); i >= 0; i--) {
            for (int j = 0; j < array[i].length-1; j++) {
                int a = array[i][j] + array[i - 1][j];
                int b = array[i][j + 1] + array[i - 1][j];
                if (a >= b) {
                    array[i - 1][j] = a;
                    way[i -1][j] = " влево" + way[i][j];
                } else {
                    array[i - 1][j] = b;
                    way[i - 1][j] = " вправо" + way[i][j+1];
                }
            }
        }
        String maxWay = String.valueOf(array[0][0]);
        way[0][0] = way[0][0] + ", сумма чисел равна " + maxWay;
        return way[0][0];
    }
}