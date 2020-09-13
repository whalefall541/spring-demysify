package org.springframework.mylearntest.dao.test1;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/17 22:19
 */
public class JdbcCustomerDao implements ICustomerDao{

	@Override
	public Customer findCustomerByPK(String customerId) {
		return null;
	}

	@Override
	public void updateCustomerStatus(Customer customer) {

	}
}
