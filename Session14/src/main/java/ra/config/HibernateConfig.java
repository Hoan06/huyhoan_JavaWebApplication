package ra.config;

import jakarta.transaction.TransactionManager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("ra.model.entity");
        Properties prop = new Properties();
        prop.put("hibernate.show_sql" , env.getProperty("hibernate.show_sql"));
        prop.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
        prop.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        prop.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        sessionFactory.setHibernateProperties(prop);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory.getObject());
        return transactionManager;
    }
}
