package org.springframework.mylearntest.aop1.weaver.selfdefinetargetsource;

import org.springframework.aop.TargetSource;
import org.springframework.mylearntest.aop1.weaver.baseoninterface.ITask;

/**
 * @Author: whalefall
 * @Date: 2020/7/27 22:27
 */
@SuppressWarnings("rawtypes")
public class AlternativeTargetSource implements TargetSource {
	private ITask alternativeTask1;
	private ITask alternativeTask2;

	private int counter;

	public AlternativeTargetSource(ITask task1, ITask task2) {
		this.alternativeTask1 = task1;
		this.alternativeTask2 = task2;
	}

	@Override
	public Object getTarget() throws Exception {
		try {
			if (counter % 2 == 0)
				return alternativeTask2;
			else
				return alternativeTask1;
		} finally {
			counter ++;
		}
	}

	@Override
	public  Class getTargetClass() {
		return ITask.class;
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public void releaseTarget(Object arg0) throws Exception {

	}
}
