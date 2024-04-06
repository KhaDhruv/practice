package com.coforge.student.service;

import com.coforge.student.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> save(List<Student> student);
    List<Student> findAllStuden();
    Student findStudentById(Integer id);
    void deleteStudentById(Integer id);
    void updateStudentData(Student student);

    boolean isExist(Integer id);
}
