package first;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class MyConn {
	
	 private Connection conn=null;
	 public Connection getC()
	 {
		 return conn;
	 }
public void connection (){
		
		try{
			//Get connection
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/cursuri","root","");
			//create statement
			//Statement myStmt = conn.createStatement();
			//execute sql query
			// ResultSet myRs=myStmt.executeQuery("select * from student");
			 //process results
			// while(myRs.next()){
			//	 System.out.println(myRs.getString("name"));
			// }
		if(conn!=null){
			System.out.println("conn succ");
			
			JOptionPane.showMessageDialog(null, "succes");
			//return true;
		}
		
		}catch(Exception e)
		{
			System.out.println("not conn");
			JOptionPane.showMessageDialog(null, "error");
			//return false;
		}
		
		//return false;
	}
	private static MyConn instance;
	public static MyConn getInstance(){
		if(instance == null){
			instance = new MyConn();
		
	}
		return instance;
}
}
