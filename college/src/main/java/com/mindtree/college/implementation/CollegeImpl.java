package com.mindtree.college.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.college.VO.Student;
import com.mindtree.college.VO.RequestTemplate;
import com.mindtree.college.entity.College;
import com.mindtree.college.repository.CollegeRepository;
import com.mindtree.college.service.CollegeService;
@Component
public class CollegeImpl implements CollegeService{
	@Autowired
	CollegeRepository clgRepo;
	@Autowired
	RestTemplate restTemplate;
	

	@Override
	public College add(College clg) {
		// TODO Auto-generated method stub
		return clgRepo.save(clg);
	}

	@Override
	public List<College> list() {
		// TODO Auto-generated method stub
		return clgRepo.findAll();
	}
	@Override
	public College update(long id, String name) {
		College clg = clgRepo.findById(id);
		clg.setName(name);
		return clgRepo.save(clg);
	}


	@Override
	public College searchById(long id) {
		// TODO Auto-generated method stub
		if(clgRepo.findById(id)==null) {
		return null;
		}
		return clgRepo.findById(id);
	}

	@Override
	public List<RequestTemplate> listWithStd() {
		// TODO Auto-generated method stub
		List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
		List<College> allClg = this.list();
		Iterator<College> ir = allClg.iterator();
		while(ir.hasNext())
		{
			College clg = ir.next();
			ResponseEntity<Student[]> response =
					  restTemplate.getForEntity(
							  "http://STUDENT-SERVICE/student/student-with-ascname/"+clg.getId(),
					  Student[].class);
			Student[] students = response.getBody();
			List<Student> stds = Arrays.asList(students);
 			RequestTemplate RTm = new RequestTemplate();
			RTm.setCollege(clg);
			RTm.setStudentList(stds);
			fullList.add(RTm);
		}
		return fullList;
	}

	@Override
	public RequestTemplate specificClgStudent(long clg_id) {
		
		// TODO Auto-generated method stub
College college  = this.searchById(clg_id);
		
		ResponseEntity<Student[]> response =
				  restTemplate.getForEntity(
						  "http://STUDENT-SERVICE/student/student-with-desc-age/"+college.getId(),
				  Student[].class);
		Student[] student = response.getBody();
		List<Student> students = Arrays.asList(student);
		RequestTemplate requestTemplate = new RequestTemplate();
		
		requestTemplate.setCollege(college);
		requestTemplate.setStudentList(students);

		return requestTemplate;
	}

}
