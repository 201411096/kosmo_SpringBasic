package exercise.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercise.order.domain.Customer;
import exercise.order.repository.CustomerRepository;

//@Component("service")
@Service("service")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;



	@Override
	public void saveCustomer(Customer customer) {
		repository.save(customer);
	}


	@Override
	public void deleteCustomer(long id) {
		repository.delete(id);
	}
}
