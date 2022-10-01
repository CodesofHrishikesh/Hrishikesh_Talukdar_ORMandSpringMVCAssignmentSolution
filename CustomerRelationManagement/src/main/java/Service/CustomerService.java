package Service;






import java.util.List; 

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import entity.Customer;



@Service
public class CustomerService {


	private SessionFactory factory;
	private Session session;
	public CustomerService(SessionFactory factory) {
		System.out.println("Customer service");
		// TODO Auto-generated constructor stub
		this.factory = factory;
		try {
			this.session = factory.getCurrentSession();
		}
		catch(Exception e)
		{
			this.session = factory.openSession();
		}
		System.out.println("session created");
		System.out.println(this.session);
	}
	@Transactional
	public void saveOrUpdate(Customer customer)
	{
		System.out.println("save "+customer);
		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(customer);

		tx.commit();
	}

	
	@Transactional
	public boolean delete(int id)
	{
		try {
			Transaction tx = session.beginTransaction();
	
		Customer customer = session.get(Customer.class, id);
			session.delete(customer);
	
			tx.commit();
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	@Transactional
	public List<Customer> findAllCustomer()
	{
		Transaction tx = session.beginTransaction();
		
		List<Customer> customer = session.createQuery("from Customer").list();
				
		tx.commit();
		return customer;
	}
	public static List<Customer> findAllcustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	}


