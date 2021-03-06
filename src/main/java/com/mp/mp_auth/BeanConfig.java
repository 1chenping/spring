package com.mp.mp_auth;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Hello world!
 *
 */
//@SpringBootApplication
@MapperScan("com.mp.mp_auth.domain.db")
@Service
public class BeanConfig 
{
	
	    /**
	     * DataSource配置
	     * @return
	     */
	    @Bean
	    @ConfigurationProperties(prefix="spring.datasource")
	    public DataSource dataSource() {
	        return new org.apache.tomcat.jdbc.pool.DataSource();
	    }
	 
	    /**
	     * 提供SqlSeesion
	     * @return
	     * @throws Exception
	     */
	    @Bean
	    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
	 
	        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	        
	        sqlSessionFactoryBean.setDataSource(dataSource());
	 
	        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	 
	        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
	 
	        return sqlSessionFactoryBean.getObject();
	    }
	 
	    @Bean
	    public PlatformTransactionManager transactionManager() {
	        return new DataSourceTransactionManager(dataSource());
	    }
}
