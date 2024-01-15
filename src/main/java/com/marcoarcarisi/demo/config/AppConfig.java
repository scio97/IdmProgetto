package com.marcoarcarisi.demo.config;

import com.marcoarcarisi.demo.algortitmo.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.marcoarcarisi.demo.dao","com.marcoarcarisi.demo.service","com.marcoarcarisi.demo.entity","com.marcoarcarisi.demo","com.marcoarcarisi.demo.rest","com.marcoarcarisi.demo.test"})
public class AppConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.marcoarcarisi.demo.dao","com.marcoarcarisi.demo.service","com.marcoarcarisi.demo.entity","com.marcoarcarisi.demo");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql","true");
        em.setJpaProperties(properties);
        return em;
    }

    @Bean(name = "contains")
    public Algoritmo getContains(){
        return new Contains();
    }

    @Bean(name = "contained")
    public Algoritmo getContained(){
        return new Contained();
    }

    @Bean(name = "lev1")
    public Algoritmo getLev1(){
        return new Levenshtein1();
    }
    @Bean(name = "lev2")
    public Algoritmo getLev2(){
        return new Levenshtein2();
    }


    @Bean (name = "algoritmo")
    public Algoritmo getAlgoritmo(){
        Algoritmo contains = getContains();
        Algoritmo contained = getContained();
        Algoritmo lev1 = getLev1();
        Algoritmo lev2 = getLev2();

        contains.setNext(contained);
        contained.setNext(lev1);
        lev1.setNext(lev2);

        return contains;
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&SqlSafeUpdates=true");
        dataSource.setUsername("root");
        dataSource.setPassword("3682");
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
