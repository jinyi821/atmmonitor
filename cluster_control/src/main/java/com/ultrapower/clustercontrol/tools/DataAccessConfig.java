package com.ultrapower.clustercontrol.tools;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Created by chj on 2017/3/30.
 */
@Configuration("jdbcConfig")
@PropertySource("classpath:application.yml")
public class DataAccessConfig {
	@Value("${spring.datasource.name}")
	private String name;  //数据库命名唯一名字
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.initial-size}")
	private int initialSize;
	@Value("${spring.datasource.min-idle}")
	private int minIdle;
	@Value("${spring.datasource.max-active}")
	private int maxActive;
	@Value("${spring.datasource.max-wait}")
	private int maxWait;
	@Value("${spring.datasource.time-between-eviction-runs-millis}")
	private int timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.min-evictable-idle-time-millis}")
	private int minEvictableIdleTimeMillis;
	@Value("${spring.datasource.validation-query}")
	private String validationQuery;
	@Value("${spring.datasource.test-while-idle}")
	private boolean testWhileIdle;
	@Value("${spring.datasource.test-on-borrow}")
	private boolean testOnBorrow;
	@Value("${spring.datasource.test-on-return}")
	private boolean testOnReturn;
	@Value("${spring.datasource.pool-prepared-statements}")
	private boolean poolPreparedStatements;
	@Value("${spring.datasource.max-pool-prepared-statement-per-connection-size}")
	private int maxPoolPreparedStatementPerConnectionSize;
	//@Value("${spring.datasource.filters}")
	//private String filters;
	//@Value("${spring.datasource.connectionProperties}")
	//private String connectionProperties;
	//@Value("${spring.datasource.useGlobalDataSourceStat}")
	//private boolean useGlobalDataSourceStat;
	
	@Bean(name="mainDatashare") // 声明其为Bean实例
	@Primary // 在同样的DataSource中，首先使用被标注的DataSource
	public DataSource dataSource() {
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(this.url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
		
		//configuration
		datasource.setInitialSize(initialSize);
		datasource.setMinIdle(minIdle);
		datasource.setMaxActive(maxActive);
		datasource.setMaxWait(maxWait);
		datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		datasource.setValidationQuery(validationQuery);
		datasource.setTestWhileIdle(testWhileIdle);
		datasource.setTestOnBorrow(testOnBorrow);
		datasource.setTestOnReturn(testOnReturn);
		datasource.setPoolPreparedStatements(poolPreparedStatements);
		datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		//datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
		/*try {
			datasource.setFilters(filters);
			datasource.setProxyFilters(Arrays.asList(statFilter()));
		} catch (SQLException e) {
			System.err.println("druid configuration initialization filter: " + e);
		}
		datasource.setConnectionProperties(connectionProperties);*/
		
		return datasource;
	}

	/*@Bean
	public Filter statFilter() {
		StatFilter filter = new StatFilter();
		filter.setSlowSqlMillis(5000);
		filter.setLogSlowSql(true);
		filter.setMergeSql(true);
		return filter;
	}*/
	
	/**
     * 获取数据库连接
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return this.dataSource().getConnection();
    }
	

}
