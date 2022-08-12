package com.mindtree.students.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.students.VO.College;
import com.mindtree.students.VO.ResponseTemplate;
import com.mindtree.students.entity.Student;
import com.mindtree.students.repository.StudentRepository;
import com.mindtree.students.service.StudentService;
@Component
public class StudentImpl implements StudentService {
	@Autowired
	private StudentRepository stdRepo;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Student add(Student std) {
		return stdRepo.save(std);
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return stdRepo.findAll();
	}
	public Student searchById(long id) {
		return stdRepo.findById(id);
	}

	@Override
	public ResponseTemplate stdWithClg(long stdId) {
		// TODO Auto-generated method stub
		ResponseTemplate RT = new ResponseTemplate();
		Student std = stdRepo.findById(stdId);
		
		long clg_id = std.getClg_id();
		College clg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+clg_id, College.class);
		RT.setCollege(clg);
		RT.setStudent(std);
		return RT;
	}

	@Override
	public Student assignCollege(long stdId, long clgId) {
		// TODO Auto-generated method stub
		Student std = stdRepo.findById(stdId);
		College clg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+clgId, College.class);
		if(std==null || clg==null)
		{
			return null;
		}
		std.setClg_id(clgId);
		stdRepo.save(std);
		return std;
	}

	@Override
	public List<Student> getByClgId(long clg_id) {
		// TODO Auto-generated method stub
		return stdRepo.getByClgId(clg_id);
	}

	@Override
	public List<Student> getStudentByCollegeWithDescAge(long clg_id) {
		// TODO Auto-generated method stub
		return stdRepo.getStudentByCollegeWithDescAge(clg_id);
	}

}
