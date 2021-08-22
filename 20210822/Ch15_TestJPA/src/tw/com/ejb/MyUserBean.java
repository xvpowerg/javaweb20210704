package tw.com.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tw.com.jpa.MyUser;
@Stateless
public class MyUserBean implements MyUserBeanLocal {
	@Inject
	private EntityManager em;
	@Override
	public boolean createUser(MyUser myUser) {
		// TODO Auto-generated method stub
		try{
			em.persist(myUser);
		}catch(Exception ex) {
			System.out.println("createUser Exception:"+ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUser(MyUser myUser) {
		// TODO Auto-generated method stub
		try{em.merge(myUser);}catch(Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUser(MyUser myUser) {
		try{		
			myUser = em.merge(myUser);
			em.remove(myUser);			
		}
		catch(Exception ex) {
			System.out.println("Delete:"+ex);
			return false;		
		}
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public MyUser findMyUser(String account, String password) {
		// TODO Auto-generated method stub
		MyUser myUser = null;
		try {
			TypedQuery<MyUser> query = 
					em.createNamedQuery("findMyUser",MyUser.class);
			query.setParameter("account", account);
			query.setParameter("password", password);
			  myUser =  query.getSingleResult();	
		}catch(Exception ex) {
			System.out.println("Query Exception:"+ex);
		}
		
		//query.getResultList() //¥i¦hµ§
		return myUser;
	}

	@Override
	public MyUser findMyUserById(int id) {
		// TODO Auto-generated method stub
		MyUser myUser = null;
		try {
			myUser =  em.find(MyUser.class, id);	
		}catch(Exception ex) {
			System.out.println("findMyUserById:"+ex);
			return null;
		}		
		return myUser;
	}

}
