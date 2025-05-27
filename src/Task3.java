import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        String[] mass = createArray(5);
        printArray(mass);
        sortArray(mass);
        sortRewersArray(mass);


    }

    static String[] createArray(int lenght) {
        String[] array = new String[lenght];
        for (int i = 0; i < lenght; i++) {
            Random rand = new Random();
            int wordLenght = rand.nextInt(7) + 1;
            int randomWord = rand.nextInt(5) +1;
            int randomInt = rand.nextInt(25) + 65;
            String randomString = "" + (char) randomInt;
            for (int j = 0; j < randomWord; j++) {
                for (int k = 0; k < wordLenght; k++) {
                int randomInt1 =  rand.nextInt(25) + 97;
                randomString += (char) randomInt1;
                }
                if (j != randomWord - 1) {
                randomString += " ";
                }
            }
            array[i] = randomString;
        }
        return array;
    }

    static void printArray (String[] array) {
        for ( int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
        return;
    }

    static void sortArray(String[] array) {
        System.out.println("Начальный массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
        System.out.println("Отсортированный массив:");
        String[] array1 = Arrays.copyOf(array, array.length);
        Arrays.sort(array1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
              return Integer.compare(o1.split(" ").length, o2.split(" ").length);
            }
        });
        for ( int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "  ");
        }
        System.out.println();
        return;
    }

    static void sortRewersArray(String[] array) {
        System.out.println("Начальный массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
        System.out.println("Отсортированный массив:");
        String rewersSort = "";
        for (int i = 0; i < array.length; i++) {
            rewersSort += array[i].replace(" ", "");
        }
        String[] array1 = new String[rewersSort.length()];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = rewersSort.substring(i,i+1);
        }
        Arrays.sort(array1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        for (int i = array1.length-1; i >= 0; i--){
           System.out.print(array1[i]);
        }
        System.out.println();
        return;

    }

}
