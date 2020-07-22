package org.springframework.mylearntest.ioc.initmetod;

import net.objectlab.kit.datecalc.common
		.HolidayCalendar;
import net.objectlab.kit.datecalc.common.HolidayHandlerType;
import net.objectlab.kit.datecalc.joda.LocalDateCalculator;
import net.objectlab.kit.datecalc.joda.LocalDateKitCalculatorsFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings({"rawtypes" ,"unchecked"})
public class FXTradeDateCalculator {

	public static final DateTimeFormatter FRONT_DATE_FORMATTER =
			DateTimeFormatter.ofPattern("yyyyMMdd");
	private static final Set<LocalDate> holidaySet =
			new HashSet<LocalDate>();
	private static final String holidayKey = "JPY";

	private SqlMapClientTemplate sqlMapClientTemplate;

	public FXTradeDateCalculator(SqlMapClientTemplate sqlMapClientTemplate) {
	}

	public FXTradeDateCalculator() {
	}

	public void setupHolidays() {
		List holidays = getSystemHolidays();
		if(null == holidays || holidays.size() > 0) {
			for(int i=0,size=holidays.size();i<size;i++)
			{
				String holiday = (String)holidays.get(i);
				LocalDate date =
						(LocalDate) FRONT_DATE_FORMATTER.parse(holiday);
				holidaySet.add(date);
			}
		}
		LocalDateKitCalculatorsFactory.getDefaultInstance().registerHolidays(holidayKey, (HolidayCalendar<org.joda.time.LocalDate>) holidaySet);
	}

	public LocalDateCalculator getForwardDateCalculator() {
		return LocalDateKitCalculatorsFactory
			.getDefaultInstance().getDateCalculator(holidayKey, HolidayHandlerType.FORWARD);
	}

	public LocalDateCalculator getBackwardDateCalculator() {
		return LocalDateKitCalculatorsFactory.getDefaultInstance()
				.getDateCalculator(holidayKey, HolidayHandlerType.BACKWARD);
	}

	public List getSystemHolidays() {
		return getSqlMapClientTemplate().queryForList("personiBatis.holiday", null);
	}

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}
}