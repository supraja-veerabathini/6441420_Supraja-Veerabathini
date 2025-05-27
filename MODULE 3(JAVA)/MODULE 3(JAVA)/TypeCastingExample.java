public class TypeCastingExample {
    public static void main(String[] args) {
        
        double myDouble = 9.75;

        
        int myInt = (int) myDouble;
        System.out.println("Double value: " + myDouble);
        System.out.println("After casting to int: " + myInt);

        
        int anotherInt = 7;

        
        double anotherDouble = anotherInt;
        System.out.println("Int value: " + anotherInt);
        System.out.println("After casting to double: " + anotherDouble);
    }
}
