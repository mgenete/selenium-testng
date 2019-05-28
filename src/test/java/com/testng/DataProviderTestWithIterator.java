package com.testng;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

class Student {
	String name;
	int age;
	String gender;
	
	public Student(String name, int age, String gender) {
		this.gender=gender;
		this.name=name;
		this.age=age;
	}
	
	
}

public class DataProviderTestWithIterator {

	@DataProvider
	public Iterator<Student> studentDetail() {
		ArrayList<Student> st = new ArrayList<Student>();
		st.add(new Student("Mike", 20, "M"));
		st.add(new Student("Sally", 19, "F"));
		st.add(new Student("Rando", 22, "M"));
		
		return st.iterator();
		
	}
	
	@Test (dataProvider = "studentDetail")
	public void validateStudentDetail(Student student) {
		Iterator<Student> data = studentDetail();
		System.out.print(data.toString());
	}
}
