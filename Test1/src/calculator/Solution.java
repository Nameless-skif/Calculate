package calculator;
class Solution {

    // Во всех методах проверяем, удовлетворяют ли операнды условию: -11< x < 11 и вычисляем
    public void sum(Integer x1, Integer x2) throws ArithmeticException{
        if( x1 <11  && x2<11 && x1 >-11 && x2 >-11) {
            System.out.println("Результат = " + (x1+x2));
        }

        else throw new ArithmeticException("Число больше 10");

    }

    public void ymnozh(Integer x1, Integer x2) throws ArithmeticException{
        if( x1 <11 && x2<11 && x1>-11 && x2>-11) {
            System.out.println("Результат = " +(x1* x2));
        }
        else throw new ArithmeticException("Число больше 10");
    }

    public void delenue(Integer x1, Integer x2) throws ArithmeticException{
        if( x1 <11 && x2<11 && x1>-11 && x2>-11) {
            System.out.println("Результат = " +(x1/ x2));
        }
        else throw new ArithmeticException("Число больше 10");
    }

    public  void subtraction(Integer x1, Integer x2)  throws ArithmeticException{
        if( x1 <11 && x2<11 && x1>-11 && x2>-11) {
            System.out.println("Результат = " +(x1- x2));
        }
        else throw new ArithmeticException("Число больше 10");
    }


}
