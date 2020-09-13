package org.springframework.mylearntest.dao.test1;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/17 22:07
 */
public interface ICustomerDao {
	Customer findCustomerByPK(String customerId);

	void updateCustomerStatus(Customer customer);

}
