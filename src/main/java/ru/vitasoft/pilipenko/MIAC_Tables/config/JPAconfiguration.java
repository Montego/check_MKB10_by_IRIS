//package ru.vitasoft.pilipenko.MIAC_Tables.config;
//
//import org.hibernate.cfg.Environment;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//import ru.vitasoft.pilipenko.MIAC_Tables.TestTask1Application;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackageClasses = TestTask1Application.class)
//public class JPAconfiguration implements TransactionManagementConfigurer {
//    @Value("${dataSource.driverClassName}")
//    private String driver;
//    @Value("${dataSource.url}")
//    private String url;
//    @Value("${dataSource.username}")
//    private String username;
//    @Value("${dataSource.password}")
//    private String password;
//    @Value("${hibernate.dialect}")
//    private String dialect;
//    @Value("${hibernate.hbm2ddl.auto}")
//    private String hbm2ddlAuto;
//    @Value("${hibernate.show_sql}")
//    private Boolean show_sql;
//
//
//    @Bean
//    public DataSource configureDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(configureDataSource());
//        entityManagerFactoryBean.setPackagesToScan("ru.vitasoft.pilipenko");
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        Properties jpaProperties = new Properties();
//        jpaProperties.put(Environment.DIALECT, dialect);
//        jpaProperties.put(Environment.HBM2DDL_AUTO, hbm2ddlAuto);
//        jpaProperties.put(Environment.SHOW_SQL, show_sql);
//        entityManagerFactoryBean.setJpaProperties(jpaProperties);
//
//        return entityManagerFactoryBean;
//    }
//
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new JpaTransactionManager();
//    }
//}
