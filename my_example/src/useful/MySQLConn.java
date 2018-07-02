package useful;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MySQLConn {

	private static final String DRIVERNAME="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/java?serverTimezone=GMT&useSSL=false";
	private static final String USERNAME="java";
	private static final String USERPASSWORD="java000";
	private static final String SQL0="CREATE TABLE mays(id int null);";
	
	public static void main(String[] args) {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("加载驱动成功！");
			Connection con=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			System.out.println("连接成功！");
			PreparedStatement pstmt=con.prepareStatement(SQL0);
			boolean b=pstmt.execute();
			if(b){
				System.out.println("春姑娘");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
