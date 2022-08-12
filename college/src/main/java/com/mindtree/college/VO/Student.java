package com.mindtree.college.VO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private int age;
	private String gender;
	private String stream;
	private long clg_id;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age, String gender, String stream, long clg_id) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.stream = stream;
		this.clg_id = clg_id;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public long getClg_id() {
		return clg_id;
	}
	public void setClg_id(long clg_id) {
		this.clg_id = clg_id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", stream=" + stream
				+ ", clg_id=" + clg_id + "]";
	}
	
	

}
