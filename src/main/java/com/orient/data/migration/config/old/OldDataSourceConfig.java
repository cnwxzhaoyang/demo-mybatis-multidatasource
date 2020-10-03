package com.orient.data.migration.config.old;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@MapperScan(basePackages = OldDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "oldSqlSessionFactory")
public class OldDataSourceConfig {

    //精确到old目录，以便与其他数据源分开
    static final String PACKAGE = "com.orient.data.migration.dao.old";
    static final String MAPPER_LOCATION="classpath:mapper/old/*.xml";


    @Value("${old.datasource.url}")
    private String url;

    @Value("${old.datasource.username}")
    private String user;

    @Value("${old.datasource.password}")
    private String password;

    @Value("${old.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "oldDataSource")
    public DataSource oldDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "oldTransactionManager")
    public DataSourceTransactionManager oldTransactionManager() {
        return new DataSourceTransactionManager(oldDataSource());
    }

    @Bean(name = "oldSqlSessionFactory")
    public SqlSessionFactory oldSqlSessionFactory(@Qualifier("oldDataSource") DataSource oldDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(oldDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(OldDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
