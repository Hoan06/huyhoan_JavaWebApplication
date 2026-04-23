package ra.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class HibernateConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) throws IOException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("ra.model.entity");

        Properties prop = new Properties();
        prop.setProperty("hibernate.show_sql", env.getProperty("hibernate.show-sql"));
        prop.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
        prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        prop.setProperty("hibernate.format_sql", env.getProperty("hibernate.format-sql"));
        sessionFactory.setHibernateProperties(prop);
        sessionFactory.afterPropertiesSet();
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}