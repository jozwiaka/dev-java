package mypackage.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mypackage.entity.Customer;


//DAO = Data Access Object = separates a data
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject the sessionFactory from sring-mvc-crud-demo-servlet.xml
	//<bean id="sessionFactory"
	//class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	//@Transactional //Removing because Service is a layer, which communicates with Controller
	//WebBrowser->Controller<->Service<->DAO<->Database
	//WebBrowser->Controller->JSPPages->WebBrowser
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by firstName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}


	@Override
	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}


	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}


	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:id_Customer");
		query.setParameter("id_Customer", id);
		query.executeUpdate();
	}
	
}
