package query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datamodel.Student;

/**
 * StudentDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Tanner Beaulieu, and starter base via Ramesh Fadatare at https://github.com/RameshMF/jsp-servlet-jdbc-mysql-crud-tutorial
 *
 */
public class StudentDAO {
	private String jdbcURL = "jdbc:mysql://ec2-18-191-229-159.us-east-2.compute.amazonaws.com:3306/MyDBBeaulieu1006?useSSL=false";
	private String jdbcUsername = "newmysqlremoteuser";
	private String jdbcPassword = "mypassword";

	private static final String INSERT_USERS_SQL = "INSERT INTO students" + "  (name, university, major, grade) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,university,major,grade from students where id =?";
	private static final String SELECT_ALL_USERS = "select * from students";
	private static final String DELETE_USERS_SQL = "delete from students where id = ?;";
	private static final String UPDATE_USERS_SQL = "update students set name = ?,university= ?, major =?, grade=? where id = ?;";

	public StudentDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(Student student) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getUniversity());
			preparedStatement.setString(3, student.getMajor());
			preparedStatement.setString(4, student.getGrade());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Student selectUser(int id) {
		Student student = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String university = rs.getString("university");
				String major = rs.getString("major");
				String grade = rs.getString("grade");
				student = new Student(id, name, university, major, grade);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student;
	}

	public List<Student> selectAllUsers() {

		List<Student> students = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String university = rs.getString("university");
				String major = rs.getString("major");
				String grade = rs.getString("grade");
				students.add(new Student(id, name, university, major, grade));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return students;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(Student student) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, student.getName());
			statement.setString(2, student.getUniversity());
			statement.setString(3, student.getMajor());
			statement.setString(4, student.getGrade());
			statement.setInt(5, student.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
