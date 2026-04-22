package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Appointment;
import ra.repository.AppointmentRepository;
import ra.service.AppointmentService;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }


    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.insert(appointment);
    }

    @Override
    public void updateStatusAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id);
        if (appointment != null && appointment.getStatus() == 0) {
            appointment.setStatus(1);
            appointmentRepository.updateStatus(appointment);
        }
    }
}
