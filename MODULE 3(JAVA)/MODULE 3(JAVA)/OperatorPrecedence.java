public class OperatorPrecedence {
    public static void main(String[] args) {
        
        int result1 = 10 + 5 * 2;
        System.out.println("Result of 10 + 5 * 2 = " + result1); // 10 + (5 * 2) = 20

        
        int result2 = (10 + 5) * 2;
        System.out.println("Result of (10 + 5) * 2 = " + result2); // (10 + 5) * 2 = 30

        
        int result3 = 100 / 10 + 4 * 3;
        System.out.println("Result of 100 / 10 + 4 * 3 = " + result3); // (100 / 10) + (4 * 3) = 10 + 12 = 22

        
        int result4 = 20 - 3 + 2;
        System.out.println("Result of 20 - 3 + 2 = " + result4); // Left to right: (20 - 3) + 2 = 17 + 2 = 19
    }
}
