//CREATE TABLE accounts (
//    id INTEGER PRIMARY KEY,
 //   name TEXT NOT NULL,
 //   balance REAL NOT NULL
//);



import java.sql.*;
class BankDAO {
    private final String url = "jdbc:sqlite:bank.db";
    public void transferMoney(int fromId, int toId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url)) {
            conn.setAutoCommit(false);  // Start transaction
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                int debitRows = debitStmt.executeUpdate();
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                int creditRows = creditStmt.executeUpdate();
                if (debitRows == 1 && creditRows == 1) {
                   conn.commit();
                    System.out.println("Transfer successful.");
                } else {
                    conn.rollback();
                    System.out.println("Transfer failed: rolling back.");
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transfer error: transaction rolled back.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        }
    }
}
public class TransactionExample {
    public static void main(String[] args) {
        BankDAO bank = new BankDAO();
        bank.transferMoney(1, 2, 200.0);
    }
}
