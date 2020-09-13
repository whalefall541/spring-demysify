package org.springframework.mylearntest.transaction.xmldeclaretrans.common;

import org.joda.time.DateTime;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/27 21:58
 */
public interface IQuoteService {
	Quote getQuote();
	Quote getQuoteByDateTime(DateTime datetime);
	void saveQuote(Quote quote);
	void updateQuote(Quote quote);
	void deleteQuote(Quote quote);
}
