package tw.com.db;

public class DbInfo {
		private static String dbName;
		private static String dbAccount;
		private static String dbPassword;
		private static String dbType;
		
		 static String getDbName() {
			return dbName;
		}
		 static void setDbName(String dbName) {
			DbInfo.dbName = dbName;
		}
		 static String getDbAccount() {
			return dbAccount;
		}
		 static void setDbAccount(String dbAccount) {
			DbInfo.dbAccount = dbAccount;
		}
		 static String getDbPassword() {
			return dbPassword;
		}
		 static void setDbPassword(String dbPassword) {
			DbInfo.dbPassword = dbPassword;
		}
		public static String getDbType() {
			return dbType;
		}
		 static void setDbType(String dbType) {
			DbInfo.dbType = dbType;
		}
		
}
