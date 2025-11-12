import java.sql.SQLOutput;

class DataTypes{
    static void main() {

        // 1. INTEGRAL NUMBERS
            // byte - 8 bit
            // short - 16 bit
            // int   - 32 bit
            // long  - 64 bit

        byte age = 20;
        // range of byte:
        System.out.println("byte: " + Byte.MIN_VALUE + "   " + Byte.MAX_VALUE);

        short sh = -8900;
        // short sh = -89000; will provide an error
        System.out.println("short: " + Short.MIN_VALUE + "   " + Short.MAX_VALUE);

        int num = 12345;
        System.out.println("int: " + Integer.MIN_VALUE + "   " + Integer.MAX_VALUE);

        long lng = 1234567999;
        System.out.println("long: " + Long.MIN_VALUE + "   " + Long.MAX_VALUE);


        // 2. DECIMAL NUMBERS
            // float - 32 bit / 4 byte
            // double - 64 bit / 8 byte

//        float f1 = 3.14; // will provide you with an error
        float f1 = 3.14f; // always add f or F to tell it is a float value
        // by default 3.14 is a double value

        double d1 = 3.14;



        // 3. CHARACTERS
            // char
            // string

        // char is used to store single character
        char ch1 = 'A';
        char ch2 = '3';
        char ch3 = '$';

        // to know the numerical value of character
        System.out.println((int) ch1);
        System.out.println((int) ch2);
        System.out.println((int) ch3);

        // range of numerical values for characters / total number of characters
        System.out.println("character: " + (int) Character.MIN_VALUE + "   " + (int) Character.MAX_VALUE);

        // to print character value of a number
        System.out.println((char) 10084);
        char heart = 10084; // type casting
        System.out.println(heart);


    }
}