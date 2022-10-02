package net.tao.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tao.dto.GenericResponseDto;
import net.tao.dto.PaginationDto;
import net.tao.dto.StudentDto;
import net.tao.service.StudentService;

@RestController
@RequestMapping("api/student/")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("saveOrUpdate")
	public ResponseEntity<GenericResponseDto> saveOrUpdateStudent(@RequestBody StudentDto student) {
		return studentService.saveOrUpdateStudent(student);
	}

	@DeleteMapping("deleteStudent")
	public ResponseEntity<GenericResponseDto> deleteStudent(@RequestBody StudentDto student) {
		return studentService.deleteStudent(student);
	}

	@PostMapping("getAllStudents")
	public ResponseEntity<GenericResponseDto> getAllStudnets(@RequestBody PaginationDto pagination) {
		return studentService.getAllStudents(pagination);
	}
	
	@GetMapping("getStudentById")
	public ResponseEntity<GenericResponseDto> getStudnetById(@PathParam(value = "id") Integer id) {
		return studentService.getStudentById(id);
	}
}
