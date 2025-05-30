public class Task6 {
    public static void main(String[] args) {
        String text = "()ikjg{ghff[]hhg(jj)fgf gfg}hh()";
        String text1 = "(ikj((g{((})) ghff[]hhg(jj)fgf gfg}hh)";
        String text2 = "( [ a) b]";
        System.out.println(validText(text));
        System.out.println(validText(text1));
        System.out.println(validText(text2));
    }

    static String validText(String text) {
        String text1 = "";
        String textNotError = "Правильная строка";
        String textError = "";
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            //если встречается открывающая скобка
            if (array[i] == '(' ||array[i] == '{' || array[i] == '[') {
                text1 = text1 + array[i];
                // если скобка закрывающая
            } else if (array[i] == ')' || array[i] == '}'|| array[i] == ']') {
                   // если строка пустая,добавляем скобку в строку для ошибок
                if (text1.isEmpty()) {
                       textError = textError + array[i];
                   } else {
                    // если скобка не является парой для последней в строке
                       char lastOpen = text1.charAt(text1.length()-1);
                       if (isPair(lastOpen,array[i]) == false) {
                           textError = textError + pair(array[i]);
                           // если скобка является парой для последней в строке, обрезаем строку на 1 символ
                       } else {
                           text1 = text1.substring(0, text1.length() - 1);
                       }
                   }
            }
        }
        if(text1.isBlank()) {
            return textNotError;
        }else {
            if (text1.length() > 0){
                String cloneText1 = "";
                char[] arr = text1.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    cloneText1 = cloneText1 + pair(arr[i]);
                }
               return "Ошибка: отсутствие " + cloneText1 + textError;
            } else {
            return "Ошибка: отсутствие " + textError;
            }
        }

    }

    static boolean isPair(char open, char close) {
        if (open == '(' && close == ')' ||
                open == '{' && close == '}' ||
                open == '[' && close == ']') {
            return true;
        } else {
            return false;
        }
    }

    static char pair(char close) {
        if (close == ')') {
            return '(';
        } else if (close == '}') {
            return '{';
        } else if (close == ']'){
            return '[';
        } else if (close == '('){
            return ')';
        } else if (close == '{') {
            return '}';
        } else {
            return ']';
        }
    }
}
