package ra.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.model.entity.Product;
import ra.repository.ProductRepository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Product").list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Product insert(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(product);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Product> findBySearchName(String proName) {
        Session session = sessionFactory.openSession();
        try{
            return session.createQuery("from Product  where proName like :proName")
                    .setParameter("proName",proName)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
