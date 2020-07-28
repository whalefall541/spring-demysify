package org.springframework.mylearntest.aop1.advice.perclass;

import kotlin.ranges.IntRange;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class DiscountMethodInterceptor implements MethodInterceptor {
	public static final Integer DEFAULT_DISCOUNT_RATIO = 80;
	public static final IntRange RATIO_RANGE = new IntRange(5, 95);

	private Integer discountRatio = DEFAULT_DISCOUNT_RATIO;
	private boolean campaignAvailable;

	public void setCampaignAvailable(boolean campaignAvailable) {
		this.campaignAvailable = campaignAvailable;
	}

	public Integer getDiscountRatio() {
		return discountRatio;
	}

	public void setDiscountRatio(Integer discountRatio) {
		this.discountRatio = discountRatio;
	}

	private boolean isCampaignAvailable() {
		return campaignAvailable;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object returnValue = invocation.proceed();
		if (RATIO_RANGE.contains(getDiscountRatio()) && isCampaignAvailable())
			return ((Integer) returnValue) * getDiscountRatio() / 100;
		return returnValue;
	}
}
