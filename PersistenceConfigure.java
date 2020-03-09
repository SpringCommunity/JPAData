/*package springcommunity.demo.configure;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

@Configuration
public class PersistenceConfigure {
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String pass;
	
	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceBeanPostProcessor() {
	    return new PersistenceAnnotationBeanPostProcessor();
	}
	
	 @Bean(destroyMethod = "close")
         public DataSource dataSource() {
         BasicDataSource dataSource = new BasicDataSource();
         dataSource.setDriverClassName(driver);
         dataSource.setUrl(url);
         dataSource.setUsername(user);
         dataSource.setPassword(pass);
         return dataSource;
     }
	 
	   @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
	         LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	         entityManagerFactoryBean.setDataSource(dataSource());
	         entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	         return entityManagerFactoryBean;
	     }
}
*/