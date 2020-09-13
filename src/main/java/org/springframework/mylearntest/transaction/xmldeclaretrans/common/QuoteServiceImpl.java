/*
package org.springframework.mylearntest.transaction.xmldeclaretrans.common;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;

*/
/**
 * @Author: WhaleFall541
 * @Date: 2020/8/27 22:01
 *//*

public class QuoteServiceImpl implements IQuoteService {

	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, timeout = 20)
	@Override
	public Quote getQuote() {
		return (Quote) getJdbcTemplate().queryForObject("", new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Quote quote = new Quote();
				// ..
				return quote;
			}
		});
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, timeout = 20)
	@Override
	public Quote getQuoteByDateTime(DateTime datetime) {
		throw new NotImplementedException();
	}

	@Override
	public void saveQuote(Quote quote) {
		throw new NotImplementedException();
	}

	@Override
	public void updateQuote(Quote quote) {
		throw new NotImplementedException();
	}

	@Override
	public void deleteQuote(Quote quote) {
		throw new NotImplementedException();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setProxyInterfaces(String proxyInterfaces) {
	}
}
*/
