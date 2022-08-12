package com.mindtree.students.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.students.VO.ResponseTemplate;
import com.mindtree.students.entity.Student;

@Service
public interface StudentService {

	Student add(Student std);

	List<Student> list();

	ResponseTemplate stdWithClg(long stdId);

	Student searchById(long id);
	Student assignCollege(long stdId, long clgId);

	List<Student> getByClgId(long clg_id);

	List<Student> getStudentByCollegeWithDescAge(long clg_id);
	

}
