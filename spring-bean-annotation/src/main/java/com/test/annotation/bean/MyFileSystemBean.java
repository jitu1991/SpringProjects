package com.test.annotation.bean;

public class MyFileSystemBean {
	@Override
	public String toString() {
		return "MyFileSystemBean" + this.hashCode();
	}
	
	public void init() {
		System.out.println("init method");
	}
	
	public void destroy() {
		System.out.println("Destroy method");
	}
}
