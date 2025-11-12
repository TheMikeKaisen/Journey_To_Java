

class HelloWorld{
    public static void main(String[] argument) {
        System.out.println("Hello world!");

        // to convert the code into bytecode and pass it to jvm: javac HelloWorld.java
        // to convert the bytecode to machine code and run the program: java HelloWorld
        // anything written after command is included as a string of arguments starting with index 0.
        // for ex: java HelloWorld arg0 arg1 arg2 ...
        System.out.println(argument[0]);
        System.out.println(argument[1]);
    }
}