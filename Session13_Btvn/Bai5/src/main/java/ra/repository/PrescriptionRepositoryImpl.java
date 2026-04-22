package ra.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.model.entity.Prescription;

import java.util.List;

@Repository
public class PrescriptionRepositoryImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Prescription> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("SELECT DISTINCT p FROM Prescription p LEFT JOIN FETCH p.details", Prescription.class).list();
        } finally {
            session.close();
        }
    }

    public List<Prescription> searchByPatientCode(String code) {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("SELECT DISTINCT p FROM Prescription p LEFT JOIN FETCH p.details WHERE p.patientCode LIKE :code", Prescription.class)
                    .setParameter("code", "%" + code + "%")
                    .list();
        } finally {
            session.close();
        }
    }

    public void save(Prescription prescription) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.persist(prescription);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}