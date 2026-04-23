package ra.repository.impl;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import ra.model.entity.Classes;
import ra.repository.ClassRepository;

import java.util.List;

@Repository
public class ClassRepositoryImpl implements ClassRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Classes> findAll() {
        Session session = sessionFactory.openSession();
        List<Classes> list = null;
        try {
            session.beginTransaction();
            list = session.createQuery("from Classes").list();
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<Classes> findAllOnlyClasses() {
        Session session = sessionFactory.openSession();
        try {
            return session.createNativeQuery("select * from classes" , Classes.class).list();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            session.close();
        }
        return null;
    }
}
