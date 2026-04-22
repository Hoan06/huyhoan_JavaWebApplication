package ra.service;

import ra.model.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment save(Appointment appointment);
    void updateStatusAppointment(Long id);
}
