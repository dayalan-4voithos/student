package net.tao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.tao.domain.Student;

public interface StudentDao extends PagingAndSortingRepository<Student, Integer>, JpaRepository<Student, Integer> {

}
