package com.clc.config;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@Configuration  
//@EnableWebMvc
@ComponentScan({ "com.clc.*" })
@PropertySource(value = { "classpath:database.properties" })
public class SpringBean {

	@Value("${jdbc.driverClassName}")
	String driverClassName;
	@Value("${jdbc.url}")
	String dbUrl;
	@Value("${jdbc.username}")
	String dbUserName;
	@Value("${jdbc.password}")
	String password;
	@Value("${hibernate.dialect}")
	String hbmDialectPropertyValue;
	@Value("${hibernate.show_sql}")
	String hbmShowSqlPropertyValue;
	@Value("${hibernate.format_sql}")
	String hbmFormatSqlPropertyValue;
	@Value("${hibernate.ddl}")
	String hbmDdlAutoPropertyValue;

	static {
		System.out.println("Loading of BeanXMl");
	}
	String hbmDialectProperty = "hibernate.dialect";
	String hbmShowSqlProperty = "hibernate.show_sql";
	String hbmFormatSqlProperty = "hibernate.format_sql";
	String hbmDdlAutoProperty = "hibernate.hbm2ddl.auto";

	@Bean // create object with new -- to spring container madhe add kara --
			// LocalsessionFactory
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.clc.*" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("driverClassName : " + driverClassName);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(password);
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(hbmDialectProperty, hbmDialectPropertyValue);
		properties.put(hbmShowSqlProperty, hbmShowSqlPropertyValue);
		properties.put(hbmFormatSqlProperty, hbmFormatSqlPropertyValue);
		properties.put(hbmDdlAutoProperty, hbmDdlAutoPropertyValue);
		return properties;
	}

	 @Bean
	 public ViewResolver viewResolver() {
	 InternalResourceViewResolver viewResolver = new
	 InternalResourceViewResolver();
	 viewResolver.setViewClass(JstlView.class);
	 viewResolver.setPrefix("/WEB-INF/views/");
	 viewResolver.setSuffix(".jsp");
	 return viewResolver;
	 }

	@Value("${spring.mail.host}")
	String host;
	@Value("${spring.mail.port}")
	int port;
	@Value("${spring.mail.username}")
	String username;
	@Value("${spring.mail.password}")
	String springpassword;
	@Value("${spring.mail.properties.mail.smtp.auth}")
	String authValue;
	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	String enableValue;
	@Value("${spring.mail.debug}")String debug;

	String auth = "mail.smtp.auth";
	String enable = "smtp.starttls.enable";

	@Bean
	public JavaMailSender javaMailService() throws AddressException, MessagingException {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		javaMailSender.setUsername("dhanshrimane23@gmail.com");
		javaMailSender.setPassword("dhanu920911");

		Properties properties = new Properties();
		properties.setProperty("spring.mail.protocol", "smtp");
		properties.setProperty(auth, authValue);
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.debug", debug);
		properties.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		javaMailSender.setJavaMailProperties(properties);

		System.out.println("properties....."+properties.getProperty(auth));
		System.out.println("properties....."+properties.getProperty("spring.mail.protocol"));
	
		System.out.println(javaMailSender.toString());

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		 try {
		 MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		 helper.setFrom("dhanshrimane23@gmail.com");
		 helper.setTo("gdjgs@gmail.com");
		 helper.setSubject("Test Mail");
		 String content = "Hello..";
		 helper.setText(content, true);
//		 javaMailSender.send(mimeMessage);
		 } catch (MessagingException mse) {
		 mse.printStackTrace();
		 }
		
	
		return javaMailSender;
	}
}
