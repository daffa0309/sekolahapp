package com.example.sekolahapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sekolahapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
