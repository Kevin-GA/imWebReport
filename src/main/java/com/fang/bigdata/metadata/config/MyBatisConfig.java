package com.fang.bigdata.metadata.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/3/9.
 */
@Configuration
@MapperScan(basePackages = {"com.fang.bigdata.metadata.dao", "com.fang.bigdata.metadata.daoimpala", "com.fang.bigdata.metadata.daoub"})
public class MyBatisConfig implements EnvironmentAware {
//    @Autowired
//    DbPropertiesMap dbPropertiesMap;
    @Bean
    @Primary
    public DynamicDataSource dataSource() throws Exception {
        DataSource dataSource_Mysql = dataSource_Mysql();
        DataSource dataSource_Kylin = dataSource_Kylin();
        DataSource dataSource_Kylin_Newsfb = dataSource_Kylin_Newsfb();
        DataSource dataSource_Impala_Dwd = dataSource_ImpalaDwd();
        DataSource dataSource_UB = dataSource_ub();
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DatabaseType.MYSQL, dataSource_Mysql);
        targetDataSource.put(DatabaseType.KYLIN, dataSource_Kylin);
        targetDataSource.put(DatabaseType.KYLIN_NEWSFB, dataSource_Kylin_Newsfb);
        targetDataSource.put(DatabaseType.IMPALA_DWD, dataSource_Impala_Dwd);
        targetDataSource.put(DatabaseType.UB, dataSource_UB);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(dataSource_Mysql);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);
        fb.setPlugins(new Interceptor[]{new MybatisLogInterceptor()});
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//添加XML目录

        return fb.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

    @RefreshScope
    DataSource dataSource_Mysql() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("datasource.mysql.driverclass"));
        props.put("url", env.getProperty("datasource.mysql.url"));
        props.put("username", env.getProperty("datasource.mysql.username"));
//        props.put("password", env.getProperty("datasource.mysql.password"));
        props.put("password", env.getProperty("datasource.mysql.password"));
        props.put("filters", env.getProperty("datasource.mysql.filters"));
        props.put("maxActive", env.getProperty("datasource.mysql.maxActive"));
        props.put("initialSize", env.getProperty("datasource.mysql.initialSize"));
        props.put("maxWait", env.getProperty("datasource.mysql.maxWait"));
        props.put("minIdle", env.getProperty("datasource.mysql.minIdle"));
        props.put("timeBetweenEvictionRunsMillis", env.getProperty("datasource.mysql.timeBetweenEvictionRunsMillis"));
        props.put("minEvictableIdleTimeMillis", env.getProperty("datasource.mysql.minEvictableIdleTimeMillis"));
        props.put("validationQuery", env.getProperty("datasource.mysql.validationQuery"));
        props.put("testWhileIdle", env.getProperty("datasource.mysql.testWhileIdle"));
        props.put("testOnBorrow", env.getProperty("datasource.mysql.testOnBorrow"));
        props.put("testOnReturn", env.getProperty("datasource.mysql.testOnReturn"));
        props.put("poolPreparedStatements", env.getProperty("datasource.mysql.poolPreparedStatements"));
        props.put("maxOpenPreparedStatements", env.getProperty("datasource.mysql.maxOpenPreparedStatements"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @RefreshScope
    DataSource dataSource_Kylin() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("datasource.kylin.driverclass"));
        props.put("url", env.getProperty("datasource.kylin.url")+env.getProperty("datasource.kylin.urltail"));
        props.put("username", env.getProperty("datasource.kylin.username"));
//        props.put("password", env.getProperty("datasource.kylin.password"));

        props.put("password", env.getProperty("datasource.kylin.password"));
        props.put("filters", env.getProperty("datasource.kylin.filters"));
        props.put("maxActive", env.getProperty("datasource.kylin.maxActive"));
        props.put("initialSize", env.getProperty("datasource.kylin.initialSize"));
        props.put("maxWait", env.getProperty("datasource.kylin.maxWait"));
        props.put("minIdle", env.getProperty("datasource.kylin.minIdle"));

        props.put("timeBetweenEvictionRunsMillis", env.getProperty("datasource.kylin.timeBetweenEvictionRunsMillis"));
        props.put("minEvictableIdleTimeMillis", env.getProperty("datasource.kylin.minEvictableIdleTimeMillis"));
        props.put("validationQuery", env.getProperty("datasource.kylin.validationQuery"));
        props.put("testWhileIdle", env.getProperty("datasource.kylin.testWhileIdle"));
        props.put("testOnBorrow", env.getProperty("datasource.kylin.testOnBorrow"));
        props.put("testOnReturn", env.getProperty("datasource.kylin.testOnReturn"));
//        props.put("poolPreparedStatements", env.getProperty("datasource.kylin.poolPreparedStatements"));
//        props.put("maxOpenPreparedStatements", env.getProperty("datasource.kylin.maxOpenPreparedStatements"));

        return DruidDataSourceFactory.createDataSource(props);
    }

    @RefreshScope
    DataSource dataSource_Kylin_Newsfb() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("datasource.kylin.driverclass"));
        props.put("url", env.getProperty("datasource.kylin.url")+env.getProperty("datasource.kylin_newsfb.urltail"));
        props.put("username", env.getProperty("datasource.kylin.username"));
//        props.put("password", env.getProperty("datasource.kylin.password"));
        props.put("password", env.getProperty("datasource.kylin.password"));

        props.put("filters", env.getProperty("datasource.kylin.filters"));
        props.put("maxActive", env.getProperty("datasource.kylin.maxActive"));
        props.put("initialSize", env.getProperty("datasource.kylin.initialSize"));
        props.put("maxWait", env.getProperty("datasource.kylin.maxWait"));
        props.put("minIdle", env.getProperty("datasource.kylin.minIdle"));

        props.put("timeBetweenEvictionRunsMillis", env.getProperty("datasource.kylin.timeBetweenEvictionRunsMillis"));
        props.put("minEvictableIdleTimeMillis", env.getProperty("datasource.kylin.minEvictableIdleTimeMillis"));
        props.put("validationQuery", env.getProperty("datasource.kylin.validationQuery"));
        props.put("testWhileIdle", env.getProperty("datasource.kylin.testWhileIdle"));
        props.put("testOnBorrow", env.getProperty("datasource.kylin.testOnBorrow"));
        props.put("testOnReturn", env.getProperty("datasource.kylin.testOnReturn"));

        return DruidDataSourceFactory.createDataSource(props);
    }

    @RefreshScope
    DataSource dataSource_ImpalaDwd() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("datasource.impala_dwd.driverclass"));
        props.put("url", env.getProperty("datasource.impala_dwd.url"));
        props.put("username", env.getProperty("datasource.impala_dwd.username"));
//        props.put("password", env.getProperty("datasource.mysql.password"));
        props.put("password", env.getProperty("datasource.impala_dwd.password"));
        props.put("filters", env.getProperty("datasource.impala_dwd.filters"));
        props.put("maxActive", env.getProperty("datasource.impala_dwd.maxActive"));
        props.put("initialSize", env.getProperty("datasource.impala_dwd.initialSize"));
        props.put("maxWait", env.getProperty("datasource.impala_dwd.maxWait"));
        props.put("minIdle", env.getProperty("datasource.impala_dwd.minIdle"));
        props.put("timeBetweenEvictionRunsMillis", env.getProperty("datasource.impala_dwd.timeBetweenEvictionRunsMillis"));
        props.put("minEvictableIdleTimeMillis", env.getProperty("datasource.impala_dwd.minEvictableIdleTimeMillis"));
        props.put("validationQuery", env.getProperty("datasource.impala_dwd.validationQuery"));
        props.put("testWhileIdle", env.getProperty("datasource.impala_dwd.testWhileIdle"));
        props.put("testOnBorrow", env.getProperty("datasource.impala_dwd.testOnBorrow"));
        props.put("testOnReturn", env.getProperty("datasource.impala_dwd.testOnReturn"));
        props.put("poolPreparedStatements", env.getProperty("datasource.impala_dwd.poolPreparedStatements"));
        props.put("maxOpenPreparedStatements", env.getProperty("datasource.impala_dwd.maxOpenPreparedStatements"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @RefreshScope
    DataSource dataSource_ub() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("datasource.ub.driverclass"));
        props.put("url", env.getProperty("datasource.ub.url"));
        props.put("username", env.getProperty("datasource.ub.username"));
//        props.put("password", env.getProperty("datasource.mysql.password"));
        props.put("password", env.getProperty("datasource.ub.password"));
        props.put("filters", env.getProperty("datasource.ub.filters"));
        props.put("maxActive", env.getProperty("datasource.ub.maxActive"));
        props.put("initialSize", env.getProperty("datasource.ub.initialSize"));
        props.put("maxWait", env.getProperty("datasource.ub.maxWait"));
        props.put("minIdle", env.getProperty("datasource.ub.minIdle"));
        props.put("timeBetweenEvictionRunsMillis", env.getProperty("datasource.ub.timeBetweenEvictionRunsMillis"));
        props.put("minEvictableIdleTimeMillis", env.getProperty("datasource.ub.minEvictableIdleTimeMillis"));
        props.put("validationQuery", env.getProperty("datasource.ub.validationQuery"));
        props.put("testWhileIdle", env.getProperty("datasource.ub.testWhileIdle"));
        props.put("testOnBorrow", env.getProperty("datasource.ub.testOnBorrow"));
        props.put("testOnReturn", env.getProperty("datasource.ub.testOnReturn"));
        props.put("poolPreparedStatements", env.getProperty("datasource.ub.poolPreparedStatements"));
        props.put("maxOpenPreparedStatements", env.getProperty("datasource.ub.maxOpenPreparedStatements"));
        return DruidDataSourceFactory.createDataSource(props);
    }


    Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}