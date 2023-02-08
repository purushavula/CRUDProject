package jdbceg4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A {
	Connection con =null;
	java.sql.Statement s=null;
	PreparedStatement ps=null;
	public void f1() {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","purush");
				String qry="select dno from dept";
				s= con.createStatement();
				
				ResultSet rs=s.executeQuery(qry);
				while(rs.next()) {
					System.out.println(rs.getInt("dno"));
				}
				rs.close();
				s.close();
				con.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			
		}
	public void f2(int no) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","purush");
			String qry="select * from dept where dno=?";
			ps=con.prepareStatement(qry);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			System.out.println(rs.getInt("dno"));
			System.out.println(rs.getString("dname"));
			System.out.println(rs.getString("dlocation"));
			System.out.println(rs.getInt("dstrength"));


			}
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
public void f3(int dno,String dname) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","purush");
			String qry="update dept set dname=? where dno=?";
			ps=con.prepareStatement(qry);
			
			ps.setString(1,dname);
			ps.setInt(2, dno);
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
	
	

		
		
	}


