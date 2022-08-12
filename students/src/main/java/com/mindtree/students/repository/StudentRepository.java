package com.mindtree.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mindtree.students.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{


	Student findById(long id);


	@Query(value="SELECT * FROM student WHERE clg_id=:clg_id ORDER BY name ASC", nativeQuery = true)
	List<Student> getByClgId(@Param("clg_id") long clg_id);
	
	@Query(value="SELECT * FROM student WHERE clg_id=:clg_id ORDER BY age DESC", nativeQuery = true)
	List<Student> getStudentByCollegeWithDescAge(@Param("clg_id") long clg_id);

}
