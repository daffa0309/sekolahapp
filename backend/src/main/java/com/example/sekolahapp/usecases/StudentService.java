package com.example.sekolahapp.usecases;

import com.example.sekolahapp.model.Student;
import com.example.sekolahapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        studentRepository.delete(student);
    }
}

