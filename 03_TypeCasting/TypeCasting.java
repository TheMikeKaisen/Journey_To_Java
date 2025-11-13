


class TypeCasting{
    static void main() {

        // implicit / widening typecasting
        int a = 10;
        float b = a;
        long c = a;
        System.out.println(a + " " + b + " " + c);
        // java will convert the integer to float and long respectively.
        // automatic type conversions happen because there is no loss of data.


        // explicit typecasting
        float f = 3.14f;
//        int g = f; // will provide an error
//        long h = f;
        int g = (int) f;
        long h = (long) f;
        System.out.println(f + " " + g + " " + h);
        // here you have to manually convert the values
        // this happens because there was a loss of data in automatic type conversion
        // ( 3.14 when automatically converted would have value 3. so there loss of .14 )
        // thus when it comes to loss of data, implicit typecasting doesn't work



    }
}