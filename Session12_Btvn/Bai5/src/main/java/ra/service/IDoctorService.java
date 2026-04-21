package ra.service;

import ra.model.dto.DoctorDTO;
import ra.model.entity.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> findAll();
    void save(Doctor doctor);
    void update(Doctor doctor);
    Doctor findById(Long id);
    List<Doctor> findByPhone(String phone);
}
