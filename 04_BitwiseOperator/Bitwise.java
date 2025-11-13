



class Bitwise{
    static void main() {


        // to know the BINARY REPRESENTATION of a number
        int a = 5;
        System.out.println(Integer.toBinaryString(a)); // 101

        // Bitwise operator cannot work with decimal or floating values
        // operands --> byte short int long
        // and &
        // or |
        // xor ^
        // not ~
        // left shift <<
        // right shift >>
        // unsigned right shift >>>

        // AND operator
        int num = 5 & 4;
        System.out.println("5 & 4: " + num);

        // OR operator
        int num2 = 5 | 4;
        System.out.println("5 | 4: " + num2);

        // XOR operator
        int num3 = 5 ^ 4;
        System.out.println("5 ^ 4: " + num3);

        // Right Shift
        int num5 = 5 >> 1; // shift bits by one digit
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(num5));

    }
}