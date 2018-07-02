package useful;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conn {

	private static final String DRIVERNAME="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;Database=java0";
	private static final String USERNAME="java";
	private static final String USERPASSWORD="java000";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVERNAME);
			System.out.println("加载驱动成功");
			Connection con=DriverManager.getConnection(URL,USERNAME ,USERPASSWORD );
			System.out.println("获取连接成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
