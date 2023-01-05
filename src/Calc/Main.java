package Calc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите два числа от 1 до 10 (арабских или римских) и арифмитеческую операцию (+, -, /, *) между ними");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

     static String calc(String input) throws Exception {
        int number1 = 0;
        int number2 = 0;
        String operator;
        String result;
        boolean isRoman = false;
        int totalInt = 0;
        input = input.replace(" ", "");
        operator = searchOperator((input));
        if (operator == null) {
            throw new Exception("Введен не верный знак. Введите знак +, -, /, *");
        }
        String operation[] = input.split("[+\\-/*]");
        if (operation.length != 2) throw new Exception("Введено не два числа. Введите два числа");

        if (operation[0].contains(".")||operation[0].contains(",") ||operation[1].contains(".")||operation[1].contains(","))
        {
            throw new Exception("Введите целые положительные числа");
        }

        if (isRoman(operation[0])&&(isRoman(operation[1]))){
//            System.out.println("Числа римские");
            number1 = convertRomanArab(operation[0]);
            number2 =convertRomanArab(operation[1]);
            isRoman = true;
        }
        else if (!isRoman(operation[0])&&(!isRoman(operation[1]))){
              {
//            System.out.println("Числа арабские");
                number1 = Integer.parseInt(operation[0]);
                number2 = Integer.parseInt(operation[1]);
            }
        }
        else {
            throw new Exception ("Введены неверные данные или Вы используете римское и арабское числа");
        }
        if (number1 <1 || number1 >10 ||number2 <1 || number2 >10){
            throw new Exception("Числа должны быть от 1 по 10 включительно");
         }

        switch (operator) {
            case "+":
                totalInt = number1 + number2;
                break;
            case "-":
                totalInt = number1 - number2;
                break;
            case "/":
                if (number2 == 0)
                {
                    throw new Exception ("на \"0\" делить нельзя");
                }
                else {
                totalInt = number1 / number2;
                break;}

            case "*":
                totalInt = number1 * number2;
                break;
        }
            if (totalInt <= 0 && isRoman==true)
            {
                throw new Exception ("Результат вычисления в римских цифрах не может быть меньше 1");
            } else if (isRoman==true) {
                result = convertArabRoman(totalInt);
            } else {
            result = totalInt + "";
            }
            return result;
        }



    static boolean isRoman(String s) {
        for (Roman roman: Roman.values()) {
            if (roman.name().equals(s)){
                return true;
            }
        }
        return false;
    }
    static int convertRomanArab(String s) {
        for (Roman roman: Roman.values()) {
            if (roman.name().equals(s)){
                return roman.ordinal();
            }
        }
        return 0;
}
    static String convertArabRoman(int a){
        for (Roman roman: Roman.values()){
            if (roman.ordinal()==a){
                return roman.name();
            }
        }
        return null;
    }

    static String searchOperator (String userData) throws Exception {
            if (userData.contains("+")) {
                return "+";
            } else if (userData.contains("-")) {
                return "-";
            } else if (userData.contains("/")) {
                return "/";
            } else if (userData.contains("*")) {
                return "*";
            } else return null;
        }
    }


enum Roman {
    O, I, II, III, IV, V, VI, VII, VIII, IX, X, XI,XII,XIII,XIV,XV,XVI,XVII,XVIII,XIX,XX,XXI,XXII,XXIII,XXIV,XXV,XXVI,
    XXVII, XXVIII, XXIX, XXX, XXXI, XXXII, XXXIII, XXXIV, XXXV, XXXVI, XXXVII, XXXVIII, XXXIX, XL,XLI, XLII, XLIII, XLIV,
    XLV, XLVI, XLVII, XLVIII, XLIX, L, LI, LII, LIII, LIV, LV, LVI, LVII, LVIII, LIX, LX, LXI,LXII,LXIII,LXIV,LXV,LXVI,
    LXVII,LXVIII,LXIX,LXX,LXXI,LXXII,LXXIII,LXXIV,LXXV,LXXVI,LXXVII, LXXVIII, LXXIX, LXXX, LXXXI, LXXXII, LXXXIII, LXXXIV,
    LXXXV, LXXXVI, LXXXVII, LXXXVIII, LXXXIX, XC, XCI, XCII,XCIII,XCIV, XCV, XCVI, XCVII, XCVIII, XCIX, C;

}