package tw.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection  implements DBConnection {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/"+DbInfo.getDbName()+"?serverTimezone=CST&useSSL=false&allowPublicKeyRetrieval=true";
		Connection conn = null;
		try{ 
			conn = DriverManager.getConnection(url,DbInfo.getDbAccount(),DbInfo.getDbPassword());
	      }catch(SQLException ex) {
			System.out.println(ex);
		  }
		return conn;
	}

}
