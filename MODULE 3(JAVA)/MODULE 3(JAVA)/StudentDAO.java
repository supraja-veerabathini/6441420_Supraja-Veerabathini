import java.sql.*;
class StudentDAO {
    private final String url = "jdbc:sqlite:school.db";
    public void insertStudent(String name, int age) {
        String sql = "INSERT INTO students(name, age) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Insert failed:");
            e.printStackTrace();
        }
    }
    public void updateStudentAge(int id, int newAge) {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {  
            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
        System.out.println("Student updated successfully.");
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Update failed:");
            e.printStackTrace();
        }
    }
}
public class JDBCInsertUpdateExample {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.insertStudent("Charlie", 21);
        dao.updateStudentAge(1, 25); // Assumes ID 1 exists
    }
}
