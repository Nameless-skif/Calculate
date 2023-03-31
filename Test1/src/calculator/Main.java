package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Input");
        String inStr = scan.nextLine();  // тут хранится то, что мы ввели с клавиатуры
        String noSpace = inStr.replaceAll("\\s+", "");// убираем все пробелы(если они есть) из строки

        try {
            checkingCondition(noSpace);   // Проверка входной строки на запрещенные символы
            decisionAritmeticOperation(definitionArithmeticOperation(noSpace), noSpace);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }


    // Определение знака арифметической операции(+,-,*,/), либо его отсутствие. Выдаем код операции
    public static int definitionArithmeticOperation(String str) throws ArithmeticException{ //Определяем знак арифметической операции

        int numberArithmeticOperation = 0;
        String[] arithmetic = {"+", "*", "/", "-"};

        for (int i = 0; i < arithmetic.length; i++) {

            if (str.contains(arithmetic[i]) == true) {         // проверка наличия символов арифм. операции
                numberArithmeticOperation = i + 1;
                break;
            }
        }
        if(numberArithmeticOperation==0) throw new ArithmeticException("Строка не является математической операцией");
        //System.out.println("Номер арифметической операции = " + numberArithmeticOperation);
        return numberArithmeticOperation;
    }


    // Смотрим, находятся ли операнды были в пределах -11<x<11, проверяем римские или арабские цифры, вычисляем выражение
    public static void decisionAritmeticOperation(int k, String str) throws ArithmeticException {    // передаем номер арифм. операции и строку примера


        Solution solutionEx = new Solution();
        ConvertedRoman converOne = new ConvertedRoman();
        converOne.ConvertedRoman();
        converOne.ConvertedArab();
        switch (k) {

            case 1://Сложение

                String [] sum = str.split("\\+");  //Делим строку по знаку"+" и записываем в массив(массив из двух строк)

                if (converOne.checkRomanStrings(sum[0], sum[1])) { //Проверяем записаны оба числа римскими цифрами
                   try {
                       converOne.sumRoman(sum[0], sum[1]);
                   }
                    catch (ArithmeticException e){
                        System.out.println(e.getMessage());//Ошибки если больше 10 или <=0
                    }
                } else if (converOne.checkNotRomanStrings(sum[0], sum[1])) { //Проверяем записаны оба числа арабскими цифрами
                    try {
                        solutionEx.sum(Integer.parseInt(sum[0]), Integer.parseInt(sum[1]));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }

                } else throw new ArithmeticException("Не правильная запись");// одно число арабскими цифрами, другое римскими
                break;



            case 2://Умножение

                String[] ymnozh = str.split("\\*");
                
                if (converOne.checkRomanStrings(ymnozh[0], ymnozh[1])) { //Проверяем записаны ли оба числа римскими цифрами
                   try {
                       converOne.ymnozRoman(ymnozh[0], ymnozh[1]);
                   }
                    catch (ArithmeticException e){
                        System.out.println(e.getMessage());//Ошибки если входящие числа больше 10 или ответ <=0
                    }

                } else if (converOne.checkNotRomanStrings(ymnozh[0], ymnozh[1])) { //Проверяем записаны ли оба числа арабскими цифрами
                    try {
                        solutionEx.ymnozh(Integer.parseInt(ymnozh[0]), Integer.parseInt(ymnozh[1]));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }

                } else throw new ArithmeticException("Не правильная запись");
                break;

            case 3://Деление

                String[] del = str.split("\\/");

                if (converOne.checkRomanStrings(del[0], del[1])) { //Проверяем записаны ли оба числа римскими цифрами
                    try {
                        converOne.delenueRoman(del[0], del[1]);
                    }
                    catch (ArithmeticException e){
                        System.out.println(e.getMessage());//Ошибки если входящие числа больше 10 или ответ <=0
                    }

                } else if (converOne.checkNotRomanStrings(del[0], del[1])) { //Проверяем записаны ли оба числа арабскими цифрами
                    try {
                        solutionEx.delenue(Integer.parseInt(del[0]), Integer.parseInt(del[1]));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                } else throw new ArithmeticException("Не правильная запись");
                break;

            case 4://Вычитание

                if (str.contains("--")) {   //проверяем, если в строке "--" -> true
                    int lastIndex = str.lastIndexOf("--");//запоминаем индекс
                   // System.out.println("индекс последнего - = " + lastIndex);
                    String st1 = str.replace("--", "+");// заменяем -- на знак +. Дальше как в case 1
                    String[] sum1 = st1.split("\\+");

                    if (converOne.checkRomanStrings(sum1[0], sum1[1])) { //Проверяем записаны оба числа римскими цифрами
                        try {
                            converOne.sumRoman(sum1[0], sum1[1]);
                        }
                        catch (ArithmeticException e){
                            System.out.println(e.getMessage());//Ошибки если входящие числа больше 10 или ответ <=0
                        }
                    } else if (converOne.checkNotRomanStrings(sum1[0], sum1[1])) { //Проверяем записаны оба числа арабскими цифрами
                        try {
                            solutionEx.sum(Integer.parseInt(sum1[0]), Integer.parseInt(sum1[1]));
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }

                    } else throw new ArithmeticException("Не правильная запись");

                } else {
                    int lastIndex1 = str.lastIndexOf("-");
                    // Далее мы делим строку на подстроки
                    // Первая - от 0 индекса до индекса последного минуса; Вторая - от последнего индекса +1 до конца

                    if (converOne.checkRomanStrings(str.substring(0, lastIndex1), str.substring(lastIndex1 + 1))) { //Проверяем записаны оба числа римскими цифрами
                        try {
                            converOne.raznostRoman(str.substring(0, lastIndex1), str.substring(lastIndex1 + 1));
                        }
                        catch (ArithmeticException e){
                            System.out.println(e.getMessage());//Ошибки если входящие числа больше 10 или ответ <=0
                        }

                    } else if (converOne.checkNotRomanStrings(str.substring(0, lastIndex1), str.substring(lastIndex1 + 1))) { //Проверяем записаны оба числа арабскими цифрами
                        try {
                            solutionEx.subtraction(Integer.parseInt(str.substring(0, lastIndex1)), Integer.parseInt(str.substring(lastIndex1 + 1)));
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                    } else throw new ArithmeticException("Не правильная запись");
                    break;
                }

        }
    }


    // Проверка входной строки на запрещенные символы
    public static void checkingCondition(String str) throws ArithmeticException {  //если возвращает true, продолжаем решение, если др то выводим соответсвующую ошибку

        String[] notArithmetic = {".", ",", ";", ":", "=", "_", ")", "(", "!", "@", "#", "$", "%", "^"};  //Массив для проверки наличия запрещенных символов
        for (int i = 0; i < notArithmetic.length; i++) {
            if ((str.contains(notArithmetic[i])))
                throw new ArithmeticException("Строка не удовлетворяет условию"); // проверка наличия символов
        }
        //Проверка наличия более одного знака арифмет операции(8+8+9; 9/6/6 и тд)
        if ((str.indexOf("+") != str.lastIndexOf("+")) || (str.indexOf("*") != str.lastIndexOf("*")) || (str.indexOf("/") != str.lastIndexOf("/")))
            throw new ArithmeticException("Строка не удовлетворяет условию");

        // -//- для знака "-"
        // withoutMin для случая когда на первым элементом идет "-" :  -4--4  -> 4--4
        String withoutMin = str.substring(1);//Новая строка для проверки на кол-во знака "-"(убирает первый элемент строки)
        if((withoutMin.indexOf("-")+1)!=withoutMin.lastIndexOf("-")&&(withoutMin.indexOf("-")!=withoutMin.lastIndexOf("-")))
            throw new ArithmeticException("Строка не удовлетворяет условию");
        if((str.contains("+")&&str.contains("*")) || (str.contains("+")&&str.contains("/")) || (str.contains("/")&&str.contains("*")))
            throw new ArithmeticException("Строка не удовлетворяет условию");
    }


}







