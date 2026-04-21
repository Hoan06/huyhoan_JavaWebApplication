package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dto.DoctorDTO;
import ra.model.entity.Doctor;
import ra.repository.DoctorRepository;
import ra.service.IDoctorService;

import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findByPhone(String phone) {
        return doctorRepository.findByPhone(phone).stream().toList();
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
}
