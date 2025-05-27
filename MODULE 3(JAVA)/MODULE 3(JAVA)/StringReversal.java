import java.util.Scanner;
public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);
        String reversedWithBuilder = sb.reverse().toString();
        String reversedWithLoop = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedWithLoop += input.charAt(i);
        }
        System.out.println("Reversed (using StringBuilder): " + reversedWithBuilder);
        System.out.println("Reversed (using loop): " + reversedWithLoop);
        scanner.close();
    }
}
