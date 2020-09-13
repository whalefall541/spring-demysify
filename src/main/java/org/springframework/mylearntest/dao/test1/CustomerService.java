package org.springframework.mylearntest.dao.test1;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/17 22:10
 */
public class CustomerService {
	private ICustomerDao customerDao;

	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void disableCustomerCampain(String customerId) {
		Customer customer = getCustomerDao().findCustomerByPK(customerId);
		customer.setCampainStatus(CampainStatus.DISABLE);
		getCustomerDao().updateCustomerStatus(customer);
	}


}
