package tw.com.db.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tw.com.bean.MyUser;
import tw.com.db.DBConnection;
import tw.com.db.DbInfo;

public interface UserDao {
	
	
    default boolean createUser(MyUser user) {
    	try(Connection conn = DBConnection.getConnection(DbInfo.getDbType());
    		Statement stm = conn.createStatement();){
    		stm.executeUpdate("INSERT INTO (name,age) VALUES("+user.getName()+","+user.getAge()+")");
    		
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
    		return false;
		}
    	
    	return true;    	
    }
    
    default MyUser queryMyUser(int id) {
    	MyUser  myUser = null;
    	try(Connection conn = DBConnection.getConnection(DbInfo.getDbType());
        		Statement stm = conn.createStatement();){
        		ResultSet resultSet = 
        				stm.executeQuery("SELECT * FROM user WHERE id="+id);
        		if (resultSet.next() == false) {
        			return null;
        		}else {
        			String idStr = resultSet.getString("id");
        			String name = resultSet.getString("name");
        			int age = resultSet.getInt("age");
        			myUser = new MyUser();
        			myUser.setId(idStr);
        			myUser.setName(name);
        			myUser.setAge(age);
        			
        		}
        		
        	} catch (SQLException e) {
    			// TODO Auto-generated catch block
        		return myUser;
    		}
        	
        	return myUser;  
    	
    }
    
}
