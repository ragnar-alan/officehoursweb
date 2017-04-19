package com.epam.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by boros on 2017. 04. 17..
 */
@Configuration
public class DataSourceConfiguration {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;

    @Bean()
    public DataSource getDataSource() {
        BasicDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }

    @Bean
    @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }

    @Bean
    public AnnotationSessionFactoryBean getSessionFactory()
    {
        AnnotationSessionFactoryBean asfb = new AnnotationSessionFactoryBean();
        asfb.setDataSource(getDataSource());
        asfb.setHibernateProperties(getHibernateProperties());
        asfb.setPackagesToScan(new String[]{"com.sivalabs"});
        return asfb;
    }

    @Bean
    public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);

        return properties;
    }
}
