package net.gsk.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.gsk.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	
	//change the below parameters based in the DBMS 
	public  static final String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlieshopping";
	public  static final String DATABASE_DRIVER="org.h2.Driver";
	public  static final String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	public  static final String DATABASE_USERNAME="sa";
	public  static final String DATABASE_PASSWORD="";
	
	@Bean("dataSource")
	public DataSource getDataSource(){
		//providing the database connection information
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	//Session factory bean will be aviable 
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.gsk.shoppingbackend.dto");
		SessionFactory session=builder.buildSessionFactory();
		return session;
		
	}

	//All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		
		Properties prop=new Properties();
		prop.put("hibernate.dialect", DATABASE_DIALECT);
		prop.put("hibernate.show_sql","true");
		prop.put("hibernate.format_sql","true");
		return prop;
	}
	
	//Transaction Manager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}