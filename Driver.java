package first;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import java.sql.*;


public class Driver {
	
	static Scanner reader = new Scanner(System.in);
	static MyConn c=new MyConn();
	static Connection conn=null;
	
public static boolean connection (){
		
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
			
		}
		return true;
		
		}catch(Exception e)
		{
			System.out.println("not conn");
			JOptionPane.showMessageDialog(null, "error");
			return false;
		}
		
	
	}
public  static boolean addStud(String id,String name, String birth, String adress) {
        
		String sql = "INSERT INTO student(idstudent,name,birthdate,adress) VALUES('" + id + "','" + name + "','" + birth + "','" + adress + "')";
        try {
           
            Statement s = conn.prepareStatement(sql);
            s.execute(sql);
            JOptionPane.showMessageDialog(null, "succes student added");
            return true;
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "error at adding");
            e.printStackTrace();
            return false;
        }
     
}
public  static boolean addCourse(String id,String name, String teacher, String year) {
        
		String sql = "INSERT INTO course(course_id,name,teacher,study_year) VALUES('" + id + "','" + name + "','" + teacher + "','" + year + "')";
        try {
           
            Statement s = conn.prepareStatement(sql);
            s.execute(sql);
            JOptionPane.showMessageDialog(null, "succes course added");
            return true;
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "error at adding course");
            e.printStackTrace();
            return false;
        }
     
    }
public static boolean addEnroll(String id, String date,String id_s, String id_c) {
	
	String sql = "INSERT INTO enrollment(idenrollment,dataInrolare,idstudent,courseid) VALUES('" + id + "','" + date + "','" + id_s + "','" + id_c + "')";
	try {
	    Statement s = conn.prepareStatement(sql);
	    s.execute(sql);
	    JOptionPane.showMessageDialog(null, "enrollment added");
	    return true;
	} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "error to enrollment");
	        ex.printStackTrace();
	        return false;
	}
}
public static Boolean updateStud(String name,String newname,String newaddress){
	
	String sql="UPDATE student SET name='"+newname+"', adress='"+newaddress+"'WHERE student.name='"+name+"'";
	try
	{	
		Statement s=conn.prepareStatement(sql);
		s.execute(sql);
		JOptionPane.showMessageDialog(null, "student updated with succes");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error updating student");
		e.printStackTrace();
		return false;
	}
}
public static Boolean deleteCurs(String numeCurs){
	
	String sql="DELETE FROM course WHERE course.name ='"+numeCurs+"'";
		
	try
	{
		Statement s=conn.prepareStatement(sql);
		s.execute(sql);
		JOptionPane.showMessageDialog(null, "succes");	
			return true;
			
	}
	catch(Exception e)
	{
			System.out.println("can't delete");
			JOptionPane.showMessageDialog(null, "error");
			e.printStackTrace();
			return false;
			
	}
}
public static Boolean updateCourse(String name,String newteacher,String newyear){
	
	String sql="UPDATE course SET teacher='"+newteacher+"', study_year='"+newyear+"'WHERE course.name='"+name+"'";
	try
	{	
		Statement s=conn.prepareStatement(sql);
		s.execute(sql);
		JOptionPane.showMessageDialog(null, "course updated");
	return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error updating course");
		e.printStackTrace();
		return false;
	}
}
public static Boolean showInfoStudent(String name){
	
	try
	{	
		Statement Stat = conn.createStatement();
		//execute sql query
		 ResultSet myRs=Stat.executeQuery("SELECT * FROM student WHERE student.name='"+name+"'");
		 //process results
		 while(myRs.next()){
			 System.out.println(myRs.getString("idstudent")+" "+myRs.getString("name")+" "+myRs.getString("birthdate")+" "+myRs.getString("adress"));
		 }
		JOptionPane.showMessageDialog(null, "student info list");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error student info");
		e.printStackTrace();
		return false;
		}
	}
public static Boolean showInfoCourse(String name){
	try
		{	
		
		Statement Stat = conn.createStatement();
		
		 ResultSet myRs=Stat.executeQuery("SELECT * FROM course WHERE course.name='"+name+"'");
		 //process results
		 while(myRs.next()){
			 System.out.println(myRs.getString("course_id")+" "+myRs.getString("name")+" "+myRs.getString("teacher")+" "+myRs.getString("study_year"));
		 }
		JOptionPane.showMessageDialog(null, "course info list");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error Course info");
		e.printStackTrace();
		return false;
		}
	}
public static Boolean showEnrollments(String name){
	try
		{	
		
		Statement Stat = conn.createStatement();
		
		 ResultSet myRs=Stat.executeQuery("SELECT * FROM student s, course c,enrollment ee WHERE c.course_id=ee.courseid and s.idstudent=ee.idstudent and c.name='"+name+"'");
		
		 while(myRs.next()){
			 System.out.println(myRs.getString("name"));
		 }
		JOptionPane.showMessageDialog(null, "students enrollments info ");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error students enr info");
		e.printStackTrace();
		return false;
		}
	}
public static Boolean deleteStud(String name){
	//altfel da exception
	String sql1="DELETE FROM enrollment WHERE enrollment.idstudent in(SELECT idstudent FROM student WHERE name ='"+name+"')";
	String sql="DELETE FROM student WHERE student.name ='"+name+"'";
try
	{	
	Statement s1=conn.prepareStatement(sql1);
	s1.execute(sql1);
	Statement s=conn.prepareStatement(sql);
	s.execute(sql);
	JOptionPane.showMessageDialog(null, "student deleted");
	return true;
}
catch(Exception e)
{
	JOptionPane.showMessageDialog(null, "error deleting student");
	e.printStackTrace();
	return false;
	}
}
	
public static void main (String[] args){
		
		int input;
		connection();
		do{
			System.out.println("Optiune:");
			
			
			System.out.println("1 Add student");
			System.out.println("2 Update student");
			System.out.println("3 Delete student");
			System.out.println("4 Add enrollment");
			System.out.println("5 Update course");
			System.out.println("6 Delete course");
			System.out.println("7 Display student info");
			System.out.println("8 Print course info");
			System.out.println("9 List of students enrolled on a given course");
			System.out.println("10  add Course ");
			System.out.println("11 Iesiti din Crud");
			input=reader.nextInt();
			reader.nextLine();
		switch(input)
		{
		
		case 1 :
			String id,name,birth,address = null;
			System.out.println("Dati id-ul studentului:");
			id=reader.nextLine();
			System.out.println("Dati numele-ul studentului:");
			name=reader.nextLine();
			System.out.println("Dati data nasterii-ul studentului:");
			birth=reader.nextLine();
			System.out.println("Dati adressa-ul studentului:");
			address=reader.nextLine();
			addStud(id,name,birth,address);
			break;
		case 2 :
			String studName,name_st,address1=null;
			System.out.println("Give student name:");
			studName=reader.nextLine();
			System.out.println("Student new name:");
			name_st=reader.nextLine();
			System.out.println("The new address:");
			address1=reader.nextLine();
			updateStud(studName,name_st,address1);
			break;
		case 3 :
			String studentN;
			System.out.println("student name for delete:");
			studentN=reader.nextLine();
			deleteStud(studentN);
			break;
		case 4 :
			String idenr,dateEnr,courseId,studentId;
			System.out.println("Give enrollment id:");
			idenr=reader.nextLine();
			System.out.println("Give enrolment date:");
			dateEnr=reader.nextLine();
			System.out.println("student id for enrolment:");
			studentId=reader.nextLine();
			System.out.println("course id for enrolment:");
			courseId=reader.nextLine();
			
			addEnroll(idenr,dateEnr,studentId,courseId);
			break;
		
		case 5 :
			String courseNa1,teacher1,year=null;
			System.out.println("Course name to update:");
			courseNa1=reader.nextLine();
			System.out.println("Give course new teacher:");
			teacher1=reader.nextLine();
			System.out.println("Give course new study year:");
			year=reader.nextLine();
			updateCourse(courseNa1,teacher1,year);
			break;
		case 6 :
			String numecurs;
			System.out.println("Alegeti numele cursului:");
			numecurs=reader.nextLine();
			deleteCurs(numecurs);
			break;
		case 7 :
			String studName1;
			System.out.println("student name info display:");
			studName1=reader.nextLine();
			showInfoStudent(studName1);
			break;
		case 8 :
			String courseName2;
			System.out.println("course name for info:");
			courseName2=reader.nextLine();
			showInfoCourse(courseName2);
			break;
		case 9 :
			String courseName3;
			System.out.println("Give course name for displaying students enrolled:");
			courseName3=reader.nextLine();
			showEnrollments(courseName3);
			break;
		case 10 :
			String idcourse,nameCourse,teacher,date = null;
			System.out.println("Dati id-ul cursului:");
			idcourse=reader.nextLine();
			System.out.println("Dati numele-ul cursului:");
			nameCourse=reader.nextLine();
			System.out.println("Dati numele profesorului:");
			teacher=reader.nextLine();
			System.out.println("Dati anul de studiu:");
			date=reader.nextLine();
			addCourse(idcourse,nameCourse,teacher,date);
			break;
		default: break;
		}
		}while(input!=11);
	}
}
