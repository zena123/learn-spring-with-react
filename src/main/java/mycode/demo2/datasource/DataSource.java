// package mycode.demo2.datasource;

// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.zaxxer.hikari.HikariDataSource;

// @Configuration
// public class DataSource {
//     @Bean
//     @ConfigurationProperties("app.datasource")   // from .yml file
//     public HikariDataSource hikariDataSource(){
//         return DataSourceBuilder
//         .create()
//         .type(HikariDataSource.class)
//         .build();
//     }
    
// }
