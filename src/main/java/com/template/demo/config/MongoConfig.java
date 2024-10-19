// package com.template.demo.config;

// import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
// import
// org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.transaction.PlatformTransactionManager;
// import
// org.springframework.transaction.annotation.EnableTransactionManagement;

// import javax.sql.DataSource;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Objects;

// @Configuration
// @EnableJpaRepositories(entityManagerFactoryRef = "mongoEntityManagerFactory",
// transactionManagerRef = "mongoTransactionManager", basePackages = {
// "com.template.demo.repository.MongoRepository" })
// @EnableTransactionManagement
// public class MongoConfig {

// protected Map<String, Object> jpaProperties() {
// Map<String, Object> props = new HashMap<>();
// props.put("hibernate.physical_naming_strategy",
// CamelCaseToUnderscoresNamingStrategy.class.getName());
// props.put("hibernate.implicit_naming_strategy",
// SpringImplicitNamingStrategy.class.getName());
// return props;
// }

// @Bean
// @ConfigurationProperties("spring.datasource.mongo")
// public DataSourceProperties mongoDataSourceProperties() {
// return new DataSourceProperties();
// }

// @Bean
// public DataSource mongoDataSource() {
// return mongoDataSourceProperties().initializeDataSourceBuilder().build();
// }

// @Bean
// public LocalContainerEntityManagerFactoryBean
// mongoEntityManagerFactory(EntityManagerFactoryBuilder builder,
// @Qualifier("mongoDataSource") DataSource dataSource) {
// return builder
// .dataSource(dataSource)
// .packages("com.template.demo.model.MongoModel")
// .properties(jpaProperties())
// .build();
// }

// @Bean
// public PlatformTransactionManager mongoTransactionManager(
// @Qualifier("mongoEntityManagerFactory")
// LocalContainerEntityManagerFactoryBean mongoEntityManagerFactory) {
// return new
// JpaTransactionManager(Objects.requireNonNull(mongoEntityManagerFactory.getObject()));
// }
// }