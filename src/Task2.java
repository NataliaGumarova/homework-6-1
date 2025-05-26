public class Task2 {
    public static void main(String[] args) {
        int[] mass = {1, 4, 7, 4, 9, 7};
        int[][] mass1 = {
                {6, 9, 7},
                {6, 8, 9},
                {8, 9, 0}
        };
        String[] mass2 = {"Я у дома","Посеял, взрастил карааи, —",
                "И увяли ее лепестки...", "Но не будет мне это уроком сейчас,",
                "Я посею опять карааи!"};
        float[][] mass3 = {
                {67.975f, 87.9776f},
                {65.95643f, 9.4356f},
                {4.9876f, 8.766f}
        };
        printArray(mass);
        printArray(mass1);
        printArray(mass2);
        printArray(mass3);
    }

    static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        return;
    }

    static void printArray (String array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return;
    }

    static void printArray (int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
        return;
    }

    static void printArray (float array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
        return;
    }
}
