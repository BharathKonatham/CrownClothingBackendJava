package dev.Legends.runnerZ;

import dev.Legends.runnerZ.user.User;
import dev.Legends.runnerZ.user.UserHttpClient;
import dev.Legends.runnerZ.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class Application implements WebMvcConfigurer {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		log.info("started again");
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// Allow CORS for all controllers and endpoints
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:3000") // Your React app's URL
				.allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
				.allowedHeaders("*"); // Allow all headers
	}

//	@Bean
//	UserHttpClient userHttpClient(){
//		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
//		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
//		return  factory.createClient(UserHttpClient.class);
//	}

//	@Bean
//	CommandLineRunner runner(UserHttpClient client){
//		return args->{
//			List<User> users= client.findAll();
//			System.out.println(users);
//
//			User user = client.findById(1);
//			System.out.println(user);
//		};
//	}
}
