import java.util.HashMap;
import java.util.Scanner;

public class StudentHashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int id;

        System.out.println("Add student ID and name entries (type 'done' to stop):");

        while (true) {
            System.out.print("Enter student ID (integer): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter an integer.");
                continue;
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            studentMap.put(id, name);
        }

        
        System.out.print("\nEnter an ID to retrieve the student's name: ");
        try {
            int searchId = Integer.parseInt(scanner.nextLine());
            if (studentMap.containsKey(searchId)) {
                System.out.println("Student Name: " + studentMap.get(searchId));
            } else {
                System.out.println("No student found with ID " + searchId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
        }

        scanner.close();
    }
}
