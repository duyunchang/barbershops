package sample.data.jpa;
/**
@Configuration
@ComponentScan
@EnableAutoConfiguration
 * */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;  
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
//@ConfigurationProperties(value="classpath:application*.properties",prefix="config")
//@ImportResource(locations={"classpath:app-*.xml"})//读取额外的xml配置文件
//@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
public class ServletInitializer extends SpringBootServletInitializer {  
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServletInitializer.class, args);
		System.out.println("start========================================");
	}
	
    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(ServletInitializer.class);  
    }  

}
