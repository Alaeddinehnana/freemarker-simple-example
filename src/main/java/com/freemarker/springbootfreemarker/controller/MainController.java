package com.freemarker.springbootfreemarker.controller;

import com.freemarker.springbootfreemarker.model.Person;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private static List<Person> persons = new ArrayList<Person>();

  static {
    persons.add(new Person("Bill", "Gates"));
    persons.add(new Person("Steve", "Jobs"));
  }

  // Injectez (inject) de l'application.properties.
  @Value("${welcome.message}")
  private String message;

  @Value("${error.message}")
  private String errorMessage;

  @Qualifier("freemarkerConfiguration")
  @Autowired
  private Configuration configuration;


  @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
  public String index(Model model) throws IOException, TemplateException {
    Template template = configuration.getTemplate("index.ftl");
    Map<String, Object> input = new HashMap<>();
    Person person = new Person("ala", "hnana");
    input.put("person", person);
    Writer out = new StringWriter();
    template.process(input, out);
    String html = out.toString();
    return html;
  }

}
