package com.myapp.bean;

public class Student {

	int roll;
	String name;
	float per;
	public Student(int roll, String name, float per) {
		super();
		this.roll = roll;
		this.name = name;
		this.per = per;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPer() {
		return per;
	}
	public void setPer(float per) {
		this.per = per;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", per=" + per + "]";
	}
	
	
	
}
