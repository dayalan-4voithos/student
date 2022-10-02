package net.tao.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.tao.dao.StudentDao;
import net.tao.domain.Student;
import net.tao.dto.GenericResponseDto;
import net.tao.dto.PaginatedResponse;
import net.tao.dto.PaginationDto;
import net.tao.dto.StudentDto;
import net.tao.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public ResponseEntity<GenericResponseDto> saveOrUpdateStudent(StudentDto student) {
		GenericResponseDto response = new GenericResponseDto();
		try {
			Student studentEntity = studentDao.save(new Student(student));
			response.setMessage("Student added successfully!");
			response.setStatus(Boolean.TRUE);
			response.setResult(new StudentDto(studentEntity));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("Error Occured while saving or updating studnet!");
			response.setStatus(Boolean.FALSE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<GenericResponseDto> deleteStudent(StudentDto student) {
		GenericResponseDto response = new GenericResponseDto();
		try {
			studentDao.delete(new Student(student));

			response.setMessage("Deleted Successfully");
			response.setStatus(Boolean.TRUE);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("Error Occured while deleting student!");
			response.setStatus(Boolean.FALSE);
			response.setResult(student);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<GenericResponseDto> getAllStudents(PaginationDto pagination) {
		GenericResponseDto response = new GenericResponseDto();
		try {
			Pageable page = PageRequest.of(pagination.getPageNumber(), pagination.getPageSize());
			Page<Student> paginatedCitites = studentDao.findAll(page);

			List<StudentDto> students = new ArrayList<>();
			paginatedCitites.getContent().forEach(city -> students.add(new StudentDto(city)));
			pagination.setTotalPages(paginatedCitites.getTotalPages());
			PaginatedResponse result = new PaginatedResponse();
			result.setData(students);
			result.setPagination(pagination);
			response.setStatus(Boolean.TRUE);
			response.setMessage("Found");
			response.setResult(result);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setStatus(Boolean.FALSE);
			response.setMessage("Error Occured");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<GenericResponseDto> getStudentById(Integer id) {

		GenericResponseDto response = new GenericResponseDto();

		try {
			Optional<Student> student = studentDao.findById(id);
			if (student.isPresent()) {
				response.setStatus(Boolean.TRUE);
				response.setMessage("Found");
				response.setResult(new StudentDto(student.get()));

				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.setStatus(Boolean.TRUE);
				response.setMessage("Student not found!");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.setStatus(Boolean.FALSE);
			response.setMessage("Error Occured");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
