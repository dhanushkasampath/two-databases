package com.learn.twodatabases.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Now we’ll get to the actual Spring configuration. We’ll first set up two configuration classes — one for the Customer and the other for the Product.
 *
 * In each configuration class, we’ll need to define the following interfaces for User:
 *
 * DataSource (customerDataSource)
 * EntityManagerFactory (customerEntityManagerFactory)
 * TransactionManager (customerTransactionManager)
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "customerEntityManagerFactory",
        transactionManagerRef = "customerTransactionManager",
        basePackages = {"com.learn.twodatabases.repository"})
public class CustomerDbConfig {

    @Bean(name = "customerDataSource")
    @ConfigurationProperties(prefix = "customer.datasource")
    public DataSource customerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "customerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("customerDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.learn.twodatabases.entity").persistenceUnit("customer")
                .build();
    }

    @Bean(name = "customerTransactionManager")
    public PlatformTransactionManager customerTransactionManager(
            @Qualifier("customerEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
        return new JpaTransactionManager(customerEntityManagerFactory);
    }

}
