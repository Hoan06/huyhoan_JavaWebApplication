package ra.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.model.entity.Appointment;
import ra.repository.AppointmentRepository;

import java.util.List;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Appointment> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Appointment").list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Appointment insert(Appointment appointment) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(appointment);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void updateStatus(Appointment appointment) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.merge(appointment);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Appointment findById(long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.find(Appointment.class, id);
        } finally {
            session.close();
        }
    }
}
