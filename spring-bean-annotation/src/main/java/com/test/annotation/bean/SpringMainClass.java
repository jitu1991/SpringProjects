package com.test.annotation.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.test.annotation.bean");
		context.refresh();
		//System.out.println("application context refreshed");

		MyDaoBean myDaoBean = context.getBean(MyDaoBean.class);
		System.out.println(myDaoBean);

		MyFileSystemBean myFileSystemBean = context.getBean(MyFileSystemBean.class);
		System.out.println(myFileSystemBean);

		MyFileSystemBean myFileSystemBean1 = context.getBean(MyFileSystemBean.class);
		System.out.println(myFileSystemBean1);
	}
}
