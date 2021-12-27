package com.freemarker.springbootfreemarker;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class SpringbootfreemarkerApplication {



  public static void main(String[] args) {

    SpringApplication.run(SpringbootfreemarkerApplication.class, args);

  }

  @Bean(name = "freemarkerConfiguration")
  public Configuration config() {
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);

    cfg.setTemplateLoader(new ClassTemplateLoader(Resource.class, "/templates"));
    cfg.setDefaultEncoding("UTF-8");
    //cfg.setTemplateExceptionHandler(RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    cfg.setWrapUncheckedExceptions(true);

    return cfg;
  }

}
