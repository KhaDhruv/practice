package com.coforge.student.service;

import com.coforge.student.model.Student;
import com.coforge.student.repo.StudentRepository;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentImpl implements IStudentService{
    @Autowired
    StudentRepository repository;

    @Override
    public List< Student> save(List<Student> student) {

       List< Student> saveStudent=repository.saveAll(student);
        return saveStudent;
    }

    @Override
    public List<Student> findAllStuden() {
        List<Student> allStudents=repository.findAll();
        return allStudents;
    }

    @Override
    public Student findStudentById(Integer id) {
        Optional<Student> studentById=repository.findById(id);
       return studentById.get();

    }

    @Override
    public void deleteStudentById(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public void updateStudentData(Student student) {

        repository.save(student);

    }

    @Override
    public boolean isExist(Integer id) {

        boolean b=repository.existsById(id);
        return false;
    }
}
