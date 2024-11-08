package com.demodj.demo_examen.repository;

import com.demodj.demo_examen.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
