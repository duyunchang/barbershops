/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa;
/**
@Configuration
@ComponentScan
@EnableAutoConfiguration
 * */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import sample.data.jpa.dynamicDataSource.DynamicDataSourceRegister;

@SpringBootApplication
@EnableTransactionManagement//开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@ImportResource(locations={"classpath:app-*.xml"})//读取额外的xml配置文件
//@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
public class DataJpaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataJpaApplication.class, args);
	}
	 
}
