package org.springframework.mylearntest.ioc.propconfig;

import org.springframework.stereotype.Component;

@Component
public class SomeBean {
	int age;

	String name;

	@Override
	public String toString() {
		return "SomeBean{" +
				"age=" + age +
				", name='" + name + '\'' +
				'}';
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void doSomething() {
		System.out.println("**********************************");
		System.out.println("doSomething");
		System.out.println("**********************************");
	}
}
