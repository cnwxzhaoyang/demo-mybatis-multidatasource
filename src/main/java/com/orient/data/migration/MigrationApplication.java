package com.orient.data.migration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.orient.data.migration.dao._new","com.orient.data.migration.dao.old"})
public class MigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MigrationApplication.class, args);
    }

}
