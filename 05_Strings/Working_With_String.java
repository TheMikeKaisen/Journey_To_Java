



class Working_With_String{
    static void main() {

        // NOTE: STRING IS NOT A PRIMITIVE DATA TYPE

        // to define a string, there are two methods
        // 1. using new keyword
        String str1 = new String("Mike");

        // 2. directly assigning the value
        String str2 = "Rahul";


        // Comparing String Values
        String str3 = new String("Karthik"); // memory1 allocated in heap
        String str4 = new String("Karthik"); // memory 2 allocated in heap

        // Though the value in both str3 and str4 are same their memory memory address aren't
        System.out.println(str3==str4);

        // BUUUTTTT
        String str5 = "Anthony";
        String str6 = "Anthony";
        System.out.println(str5==str6); // returns TRUE
        // WWHHYYYYY???
        // Inside Heap, there is something called String Pool
        // any value that we create, for ex. "karthik", "mike", "anthony", etc
        //  their values are kept inside string pool
        // so the next time the same string is written, the value is referred from string pool ( no extra memory allocated )

        // AGAIN BUUTTT
        // when you create string using new keyword, memory is allocated in heap as well as the string literal is kept inside string pool
        // which means using new keyword created 2 objects.









    }
}