package com.itwill.datasource.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@Configuration
 - 스프링부트가 초기화하면서 설정파일의 @Bean 이있는 모든메쏘드를 호출한후 
   반환객체를 스프링빈으로등록한다. 
 
 */


@Configuration
public class DataSourceConfig {
	/*
	@Bean
	  -메쏘드호출후에 반환되는 객체를 빈으로등록한다.
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		/*
		 * spring boot 3.2.X 이후는 실행안됨
		 */
		System.out.println("###### DataSourceConfig.dataSource()");
		return DataSourceBuilder
				.create()
				.type(BasicDataSource.class)
				.build();
	}
}