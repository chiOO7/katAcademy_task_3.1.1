package web.config;

import javax.persistence.*;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.model.User;

import java.util.Properties;

@Configuration
//@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = {"web.services"})
@EnableTransactionManagement
public class JPAConfig {

//    private final Environment env;

//    @PersistenceUnit(unitName="task231DB")
//    EntityManagerFactory emf;

//    public JPAConfig(Environment env) {
//        this.env = env;
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/task231DB?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1987");
        return dataSource;
    }

    @Bean
    public Properties jpaProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return props;
    }

    protected HibernateJpaVendorAdapter getHibernateJpaVendorAdapter()
    {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl( false );
//        vendorAdapter.setDatabase();
//        vendorAdapter.setDatabasePlatform( this.databasePlatform );
        return vendorAdapter;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource( dataSource() );
        factoryBean.setPersistenceUnitName("task231DB");
        factoryBean.setPackagesToScan("web/model");
        factoryBean.setJpaVendorAdapter( getHibernateJpaVendorAdapter() );
        factoryBean.setJpaProperties( jpaProperties() );




//        factoryBean.setDataSource(dataSource());


//        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());



//        factoryBean.setJpaProperties(props);
//

//        factoryBean.afterPropertiesSet();


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("task231DB", props);





//        HibernatePersistenceProvider provider = new HibernatePersistenceProvider();


//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setPersistenceUnitName("persistenceUnitName");
//        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        factoryBean.afterPropertiesSet();
//
//        EntityManagerFactory factory = factoryBean.getNativeEntityManagerFactory();







        return factoryBean;
    }

//    @Bean
//    public HibernateTransactionManager getTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFactory().getObject());
//        return transactionManager;
//    }

//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//        factoryBean.setPersistenceUnitName("task231DB");
//
//
//        return factoryBean;
//    }
//
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
