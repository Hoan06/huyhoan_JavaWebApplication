package ra.repository.impl;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import ra.model.entity.Student;
import ra.repository.StudentRepository;

import java.sql.Connection;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private SessionFactory  sessionFactory;

    @Override
    public boolean insertStudent(Student student) {
        Session session = sessionFactory.openSession();
        try {
//            session.doWork(conn -> conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE)); // ví dụ mức độ cô lập
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
