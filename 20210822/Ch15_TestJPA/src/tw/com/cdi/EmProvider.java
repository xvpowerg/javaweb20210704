package tw.com.cdi;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmProvider {
	//PersistenceContext 透過容器維護"交易"
	@PersistenceContext
	@Produces
	private EntityManager em;
	
}
