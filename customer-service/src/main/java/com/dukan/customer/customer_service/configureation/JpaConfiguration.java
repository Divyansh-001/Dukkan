package com.dukan.customer.customer_service.configureation;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:application.properties")
public class JpaConfiguration 
{
	@Value("${databaseDetails.url}")
	private String url;
	
	@Value("${databaseDetails.userName}")
	private String userName;
	
	@Value("${databaseDetails.password}")
	private String password;
	
	@Value("${databaseDetails.driverClassName}")
	private String driverClassName;

	@Bean
	public DataSource dataSource()
	{
		 System.out.println(url  +" "+userName+" "+password+" "+driverClassName );

		 HikariConfig hikariConfig = new HikariConfig();
		 hikariConfig.setJdbcUrl(url);
		 hikariConfig.setUsername(userName);
		 hikariConfig.setPassword(password);
		 hikariConfig.setDriverClassName(driverClassName);
		 hikariConfig.setMaximumPoolSize(10);
		 hikariConfig.setMinimumIdle(5);		 
		 return new HikariDataSource(hikariConfig);
	}
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
     //   properties.setProperty("spring.jpa.hibernate.ddl-auto", "update");
        
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.dukan.customer.customer_service.entity"); // Package where your JPA entities are located
        em.setJpaProperties(properties);
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }
    
	@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
