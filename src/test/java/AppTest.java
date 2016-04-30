import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import java.util.ArrayList;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary Creator");
    assertThat(pageSource()).contains("Farnoosh Johnson Code Review2");
  }

  @Test
  public void wordsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Hello");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
  }

  @Test
  public void twoWordsDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Hello");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
    click("a", withText("go back"));
    fill("#word").with("Java");
    submit(".btn");
    click("a", withText("go back"));
    assertThat(pageSource()).contains("Hello");
    assertThat(pageSource()).contains("Java");
    }

  @Test
  public void wordShowPageDisplayGoback() {
    goTo("http://localhost:4567/");
    fill("#word").with("Hello");
    submit(".btn");
    click("a", withText("go back"));
    assertThat(pageSource()).contains("Hello");
  }

  @Test
  public void twoWordsShowPageDisplayGoBack() {
    goTo("http://localhost:4567/");
    fill("#word").with("Hello");
    submit(".btn");
    click("a", withText("go back"));
    assertThat(pageSource()).contains("Hello");
    fill("#word").with("World");
    submit(".btn");
    click("a", withText("go back"));
    assertThat(pageSource()).contains("Hello");
    assertThat(pageSource()).contains("World");
  }

  @Test
  public void wordShowAddDefinitionFormDisplay() {
    goTo("http://localhost:4567/");
    fill("#word").with("Hello");
    submit(".btn");
    click("a", withText("Add definition for this word"));
    assertThat(pageSource()).contains("Add a Definition to Hello");
  }

  @Test
  public void TwowordsShowAddDefinitionSuccess() {
    goTo("http://localhost:4567/words");
    fill("#word").with("Java");
    submit(".btn");
    click("a", withText("Add definition for this word"));
    assertThat(pageSource()).contains("Add a Definition to Java");
    click("a", withText("View Word List"));
    fill("#word").with("Cat");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
  }

}
