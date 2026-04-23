package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Student;
import ra.repository.StudentRepository;
import ra.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public boolean addStudent(Student student) {
        return studentRepository.insertStudent(student);
    }
}
