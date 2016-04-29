import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;

public class App {
  public static void main(String[] args) {

    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
      port = Integer.parseInt(process.environment().get("PORT"));
    } else {
      port = 4567;
    }
    setPort(port);

    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String inputtedString = request.queryParams("word");
      Word userInput = new Word(inputtedString);

      model.put("word", userInput);
      model.put("template", "templates/word-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word wordInput = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", wordInput);
      model.put("template", "templates/definition-list.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("words/:id/definitions/new", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       Word word = Word.find(Integer.parseInt(request.params(":id")));
       model.put("word", word);
       model.put("template", "templates/definitionform.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());


    post("/definitions", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      String inputteddefinition = request.queryParams("definition");
      Definition newDefinition = new Definition(inputteddefinition);
      word.addDefinition(newDefinition);
      model.put("word", word);
      model.put("template", "templates/definition-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
  }
}
