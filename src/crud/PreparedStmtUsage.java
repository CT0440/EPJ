package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStmtUsage {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established");
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter ID: ");
			int id = scan.nextInt();
			scan.nextLine();
			
			System.out.println("Enter Name: ");
			String name = scan.nextLine();
			
			System.out.println("Enter Salary: ");
			int salary = scan.nextInt();
			
			String insertData = "insert into ct(id, name, salary) values(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(insertData);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, salary);
			
			int rows = pstmt.executeUpdate();
			System.out.println(rows + "rows Updated");
			System.out.println("Inserted Data Successfully!");
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
