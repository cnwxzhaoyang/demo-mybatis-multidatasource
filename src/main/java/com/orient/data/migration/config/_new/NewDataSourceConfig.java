package com.orient.data.migration.config._new;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @see
 * @since JDK1.8
 * date 2020/10/3 15:34
 */
@Configuration
@MapperScan(basePackages = NewDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "newSqlSessionFactory")
public class NewDataSourceConfig {

    //精确到new目录，以便与其他数据源分开
    static final String PACKAGE = "com.orient.data.migration.dao._new";
    static final String MAPPER_LOCATION="classpath:mapper/_new/*.xml";


    @Value("${new.datasource.url}")
    private String url;

    @Value("${new.datasource.username}")
    private String user;

    @Value("${new.datasource.password}")
    private String password;

    @Value("${new.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "newDataSource")
    @Primary
    public DataSource newDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "newTransactionManager")
    @Primary
    public DataSourceTransactionManager newTransactionManager() {
        return new DataSourceTransactionManager(newDataSource());
    }

    @Bean(name = "newSqlSessionFactory")
    @Primary
    public SqlSessionFactory newSqlSessionFactory(@Qualifier("newDataSource") DataSource newDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(newDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(NewDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
