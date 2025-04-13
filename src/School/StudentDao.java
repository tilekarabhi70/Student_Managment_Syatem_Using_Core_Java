package School;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements DaoInterface<Student, Integer> {

	@Override
	public Collection<Student> viewAllStudent() {
		Collection<Student> listOfStudent=new ArrayList<Student>();
		try (Connection conn=JdbcUtils.buildConnection();
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from students")
				){
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String email=rs.getString(4);
				String course=rs.getString(5);
				
				Student std= new Student(id,name,age,email,course);
				listOfStudent.add(std);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listOfStudent;
	}

	@Override
	public Student retriveStudentById(Integer id) {
		Student std=null;
		String sqlQuery="select * from students where id=?";
		
		try (Connection conn=JdbcUtils.buildConnection();
				PreparedStatement stmt=conn.prepareStatement(sqlQuery);
				
				)
		{
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				int sid=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String email=rs.getString(4);
				String course=rs.getString(5);
				
				std=new Student(sid,name,age,email,course);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return std;
	}


	@Override
	public void addStudent(Student t)  {
		String sqlQuery="insert into students values(?,?,?,?,?)";
		
		try(Connection conn=JdbcUtils.buildConnection();
				PreparedStatement stmt=conn.prepareStatement(sqlQuery);
				
				) {
			int id=t.getId();
			String name=t.getName();
			int age=t.getAge();
			String email=t.getEmail();
			String course=t.getCourse();
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setString(4, email);
			stmt.setString(5, course);
			
			int count=stmt.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStudentDetails(Student t) {
		String sqlquery="update students set name=?,age=?,email=?,course=? where id=?";
		
		try(Connection conn=JdbcUtils.buildConnection();
				PreparedStatement stmt=conn.prepareStatement(sqlquery);
				){
		int id=t.getId();	
		String name=t.getName();
		int age=t.getAge();
		String email=t.getEmail();
		String course=t.getCourse();
		
		stmt.setInt(5, id);
		stmt.setString(1, name);
		stmt.setInt(2, age);
		stmt.setString(3, email);
		stmt.setString(4, course);
		
		int count=stmt.executeUpdate();
		System.out.println(count);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteStudent(Integer id) {
		String SqlQuery="delete from students where id=?";
		
		try (Connection conn =JdbcUtils.buildConnection();
				PreparedStatement stmt =conn.prepareStatement(SqlQuery);
				
				){
			stmt.setInt(1, id);
			int count=stmt.executeUpdate();
			System.out.println(count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
