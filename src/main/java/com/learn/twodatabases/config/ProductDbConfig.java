package com.learn.twodatabases.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
 * DataSource (productDataSource)
 * EntityManagerFactory (productEntityManagerFactory)
 * TransactionManager (productTransactionManager)
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "productEntityManagerFactory",
        transactionManagerRef = "productTransactionManager",
        basePackages = {"com.learn.twodatabases.repository.productdb"})
public class ProductDbConfig {

    @Primary
    @Bean(name = "productDataSource")
    @ConfigurationProperties(prefix = "product.datasource")
    public DataSource productDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "productEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("productDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.learn.twodatabases.entity.productdb")
                .persistenceUnit("productPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "productTransactionManager")
    public PlatformTransactionManager productTransactionManager(
            @Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManagerFactory) {
        return new JpaTransactionManager(productEntityManagerFactory);
    }
}