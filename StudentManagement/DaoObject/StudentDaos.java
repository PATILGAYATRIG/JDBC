package com.myapp.dao;

import java.util.List;

import com.myapp.bean.Student;

public interface StudentDaos {
	
	int updateRecord(int roll,float per);
	int deleteRecord(int roll);
	Student fetchReocordByRno(int roll);
	int saveDate(Student s);
	List<Student> fechAllData();
	
	
	
	

}
