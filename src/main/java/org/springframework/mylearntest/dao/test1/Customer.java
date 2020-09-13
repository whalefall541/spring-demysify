package org.springframework.mylearntest.dao.test1;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/17 22:09
 */
public class Customer {
	String customerId;
	String status;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setCampainStatus(CampainStatus disable) {
		this.status = disable.name();
	}
}
