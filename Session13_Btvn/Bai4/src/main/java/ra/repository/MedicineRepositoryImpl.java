package ra.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.model.entity.Medicine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicineRepositoryImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Medicine> findExpiredMedicines() {
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM Medicine m WHERE m.expiryDate < :today";

            return session.createQuery(hql, Medicine.class)
                    .setParameter("today", LocalDate.now())
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }
}
