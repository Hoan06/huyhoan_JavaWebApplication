package ra.repository;

import ra.model.entity.Appointment;

import java.util.List;

public interface AppointmentRepository {
    List<Appointment> findAll();
    Appointment insert(Appointment appointment);
    void updateStatus(Appointment appointment);
    Appointment findById(long id);
}
