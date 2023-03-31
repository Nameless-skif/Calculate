package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class ConvertedRoman {
    TreeMap<String,Integer> romanChar = new<String,Integer> TreeMap();//Для перевода в римские цифры
    public void ConvertedRoman(){
        romanChar.put("I",1);
        romanChar.put("II",2);
        romanChar.put("III",3);
        romanChar.put("IV",4);
        romanChar.put("V",5);
        romanChar.put("VI",6);
        romanChar.put("VII",7);
        romanChar.put("VIII",8);
        romanChar.put("IX",9);
        romanChar.put("X",10);
        romanChar.put("XI",11);
        romanChar.put("XII",12);
        romanChar.put("XIII",13);
        romanChar.put("XIV",14);
        romanChar.put("XV",15);
        romanChar.put("XVI",16);
        romanChar.put("XVII",17);
        romanChar.put("XVIII",18);
        romanChar.put("XIX",19);
        romanChar.put("XX",20);
        romanChar.put("-I",-1);
        romanChar.put("-II",-2);
        romanChar.put("-III",-3);
        romanChar.put("-IV",-4);
        romanChar.put("-V",-5);
        romanChar.put("-VI",-6);
        romanChar.put("-VII",-7);
        romanChar.put("-VIII",-8);
        romanChar.put("-IX",-9);
        romanChar.put("-X",-10);
        romanChar.put("-XI",-11);
        romanChar.put("-XII",-12);
        romanChar.put("-XIII",-13);
        romanChar.put("-XIV",-14);
        romanChar.put("-XV",-15);
        romanChar.put("-XVI",-16);
        romanChar.put("-XVII",-17);
        romanChar.put("-XVIII",-18);
        romanChar.put("-XIX",-19);
        romanChar.put("-XX",-20);
    }

    TreeMap<Integer,String> arabChar = new<Integer,String> TreeMap(); //Для перевода в арабские цифры
    public void ConvertedArab(){
        arabChar.put(1,"I");
        arabChar.put(2,"II");
        arabChar.put(3,"III");
        arabChar.put(4,"IV");
        arabChar.put(5,"V");
        arabChar.put(6,"VI");
        arabChar.put(7,"VII");
        arabChar.put(8,"VIII");
        arabChar.put(9,"IX");
        arabChar.put(10,"X");
        arabChar.put(11,"XI");
        arabChar.put(12,"XII");
        arabChar.put(13,"XIII");
        arabChar.put(14,"XIV");
        arabChar.put(15,"XV");
        arabChar.put(16,"XVI");
        arabChar.put(17,"XVII");
        arabChar.put(18,"XVIII");
        arabChar.put(19,"XIX");
        arabChar.put(20,"XX");
    }

    //если обе строки включают римские цифры то true(проверка на римские цифры)
    public  boolean checkRomanStrings(String str1, String str2){
        return (romanChar.containsKey(str1) &&romanChar.containsKey(str2));
    }

    //если обе строки не включают романские цифры то true(проверка на арабские цифры)
    public  boolean checkNotRomanStrings(String str1, String str2){
        return ( (romanChar.containsKey(str1)!=true) && (romanChar.containsKey(str2)!=true));
    }

    public void sumRoman(String str1, String str2) throws ArithmeticException{
        Integer x1 = romanChar.get(str1);//Ищем в map соответсвующий ключ(класса String) и записываем в x соответствующее ему значение
        Integer x2 = romanChar.get(str2);
        if( x1 <11  && x2<11 && x1 >-11 && x2 >-11){
            if( (x1+x2)>0){
                System.out.println("Результат = " + (arabChar.get(x1+x2))); //
            }
            else throw new ArithmeticException("Результат <= 0");

        }
        else throw new ArithmeticException("Число больше 10");

    }

    public  void ymnozRoman(String str1, String str2)  throws ArithmeticException{
        Integer x1 = romanChar.get(str1);//Ищем в map соответсвующий ключ(класса String) и записываем в x соответствующее ему значение
        Integer x2 = romanChar.get(str2);
        if( x1 <11  && x2<11 && x1 >-11 && x2 >-11){
            if( (x1*x2)>0){

                System.out.println("Результат = " + (toRoman(x1*x2))); //
            }
            else throw new ArithmeticException("Результат <= 0");

        }
        else throw new ArithmeticException("Число больше 10");

    }

    public void delenueRoman(String str1, String str2) throws ArithmeticException{
        Integer x1 = romanChar.get(str1);//Ищем в map соответсвующий ключ(класса String) и записываем в x соответствующее ему значение
        Integer x2 = romanChar.get(str2);
        if( x1 <11  && x2<11 && x1 >-11 && x2 >-11){
            if( (x1/x2)>0){
                System.out.println("Результат = " + (arabChar.get(x1/x2))); //
            }
            else throw new ArithmeticException("Результат <= 0");

        }
        else throw new ArithmeticException("Число больше 10");

    }

    public  void raznostRoman (String str1, String str2) throws ArithmeticException{
        Integer x1 = romanChar.get(str1);//Ищем в map соответсвующий ключ(класса String) и записываем в x соответствующее ему значение
        Integer x2 = romanChar.get(str2);
        if( x1 <11  && x2<11 && x1 >-11 && x2 >-11){
            if( (x1-x2)>0){
                System.out.println("Результат = " + (arabChar.get(x1-x2))); //
            }
            else throw new ArithmeticException("Результат <= 0");

        }
        else throw new ArithmeticException("Число больше 10");

    }




    // Следующие Treemap map и метод toRoman сделан для реализации метода умножения римских цифр
    static  TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    {
        map.put(3000, "MMM");
        map.put(2000, "MM");
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public  static  String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }


    /*public void testRomanConversion() {   //Проверка метода toRoman

        for (int i = 1; i<= 100; i++) {
            System.out.println(i+"\t =\t "+ConvertedRoman.toRoman(i));
        }

    }  */

}
