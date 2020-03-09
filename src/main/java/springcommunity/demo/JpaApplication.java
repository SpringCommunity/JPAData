package springcommunity.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Có hai cách để config cho project dùng Spring Boot, một là các bạn dùng annotation SprinBootApplication, 
 * thì nó sẽ combine hết những annotation lại. Hai là sử dụng kết hợp ba  annotation lại để config @Configuration
 * @ComponentScan(basePackages={ "springcommunity.demo" }) , @EnableAutoConfiguration
 *
 */

@SpringBootApplication
public class JpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
}

