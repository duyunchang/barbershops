package sample.data.jpa.config.cross_domain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

@Configuration
public class MyWebAppConfigurer  extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(MyWebAppConfigurer.class);

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    	  configurer.favorPathExtension(true)
          .favorParameter(false)
          .ignoreAcceptHeader(false)
          .useJaf(false)
          .defaultContentType(MediaType.ALL);
    	  
    	
//        configurer.defaultContentType(MediaType.TEXT_HTML)
//        .ignoreAcceptHeader(true);
    }

    /*
     * Configure ContentNegotiatingViewResolver
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

        resolvers.add(new JsonViewResolver());

        resolver.setViewResolvers(resolvers);
        return resolver;
    }

}
