package org.springframework.mylearntest.dao.jdbc;

import java.sql.SQLException;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/17 22:59
 */
public interface IDAO {
	int updateSomething(String sql) throws SQLException, ClassNotFoundException;
}
