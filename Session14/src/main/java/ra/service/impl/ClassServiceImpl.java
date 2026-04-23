package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Classes;
import ra.repository.ClassRepository;
import ra.service.ClassService;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;


    @Override
    public List<Classes> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public List<Classes> getAllOnlyClasses() {
        return classRepository.findAllOnlyClasses();
    }
}
