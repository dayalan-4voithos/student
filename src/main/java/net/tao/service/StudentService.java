package net.tao.service;

import org.springframework.http.ResponseEntity;

import net.tao.dto.GenericResponseDto;
import net.tao.dto.PaginatedResponse;
import net.tao.dto.PaginationDto;
import net.tao.dto.StudentDto;

public interface StudentService {
	public ResponseEntity<GenericResponseDto> saveOrUpdateStudent(StudentDto student);

	public ResponseEntity<GenericResponseDto> deleteStudent(StudentDto student);

	public ResponseEntity<GenericResponseDto> getAllStudents(PaginationDto pagination);

	public ResponseEntity<GenericResponseDto> getStudentById(Integer id);

}
