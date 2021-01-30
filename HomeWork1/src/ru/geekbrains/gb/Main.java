//Небуко Анна
package ru.geekbrains.gb;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
    //=====2======
    //Примитивные типы данных - Stack
        boolean isMoodOk = true;
        byte age = 22; // -128 до 127 (1 байт)
        short populationOfMyTown = 15_014; //-32768 до 32767 (2 байта)
        int a = 101; // -2 млрд до 2 млрд (4 байта)
        long b = 101L; //8 байт (18 чифр после цифры с + и -)
        float c = 101.11F; // 4 байта
        double d = 101.11; // 8 байт
        char ch = 'f'; //символ в кодировке UTF-16 (2 байта) f ==102

    //Ссылочные типы данных - Heap
        String helloWorldShort = "Hello, World!";
        //String helloWorldLong = new String ("Hello, World!");
        Date now = new Date();

    //Вызовы функций:
        System.out.println("3: " + calculateEquation(1, 4, 5, 9));
        System.out.println("4: " + checkSumRange(7, 3));
        identifySignVoid (-3);
        System.out.println("Number is negative? " +identifySignBoolean ( -3));
        sayHello("Максим!");
        determineLeapYear((short) 2021);
    }
    //=====3======
    static float calculateEquation(float a, float b, float c, float d){
        return a * (b + (c / d));
    }
    //=====4======
    static boolean checkSumRange (int a, int b){
        boolean c = a + b > 9 && a + b < 21;
        return c;
    }
    //=====5======
    static void identifySignVoid (int a){
        if (a >= 0) System.out.println("Positive");
        else System.out.println("Negative");
    }
    //=====6=====
    static boolean identifySignBoolean (int a){
        if (a < 0) return true;
        else return false;
    }
    //=====7=====
    static void sayHello(String name){
        System.out.println("Hello, " + name);
    }
    //=====8=====
    static void determineLeapYear(short year){
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
            System.out.println("Year is leap!");
         else System.out.println("Year is not leap!");
    }
}
