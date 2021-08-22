package tw.com.db;

import java.sql.Connection;

public interface DBConnection {
	enum SQL_TYPE{
		MYSQL,
		MSSQL
	}
		public Connection getConnection();
		
		public static Connection  getConnection(SQL_TYPE type) {
				switch(type) {
				case MYSQL:
					return new MySQLConnection().getConnection();
				}
			
			return null;			
			
		}
		
		public static Connection  getConnection(String type) {
				switch(type) {
				case "MYSQL":
					return getConnection(SQL_TYPE.MYSQL);
				}
		
		return null;			
		
	}
}
