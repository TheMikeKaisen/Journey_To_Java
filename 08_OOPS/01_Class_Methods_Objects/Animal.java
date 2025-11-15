// Define a class named Animal6

public class Animal
{
    // Declare instance variables
    int no_of_eyes; // Variable to store the number of eyes
    String color; // Variable to store the color of the animal

    // Method to display the details of an animal
    public void details(String name)
    {
        System.out.println("-------Details of " + name + "-------");
        System.out.println("Eyes : " + no_of_eyes);
        System.out.println("Color : " + color);
    }

    // Main method - program entry point
    public static void main(String[] args)
    {
        // Create an object 'jumbo' of Animal6 and assign values
        Animal jumbo = new Animal();
        jumbo.no_of_eyes = 2;
        jumbo.color = "Brown";
        jumbo.details("Jumbo"); // Call details method for 'jumbo'

        // Create another object 'buzo' of Animal6 and assign values
        Animal buzo = new Animal();
        buzo.no_of_eyes = 2;
        buzo.color = "Black";
        buzo.details("Buzo"); // Call details method for 'buzo'
    }
}