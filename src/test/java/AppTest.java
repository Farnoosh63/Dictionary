import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

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

  // @Test
  //   public void categoryIsDisplayedTest() {
  //   goTo("http://localhost:4567/categories/new");
  //   fill("#name").with("Household chores");
  //   submit(".btn");
  //   click("a", withText("All categories"));
  //   assertThat(pageSource()).contains("Household chores");
  //   }
//
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
//
//   @Test
//   public void categoryShowPageDisplaysName() {
//     goTo("http://localhost:4567/categories/new");
//     fill("#name").with("Household chores");
//     submit(".btn");
//     click("a", withText("All categories"));
//     click("a", withText("Household chores"));
//     assertThat(pageSource()).contains("Household chores");
//   }
//
//   @Test
//   public void categoryDefinitionsFormIsDisplayed() {
//     goTo("http://localhost:4567/categories/new");
//     fill("#name").with("Shopping");
//     submit(".btn");
//     click("a", withText("All categories"));
//     click("a", withText("Shopping"));
//     click("a", withText("Add a new task"));
//     assertThat(pageSource()).contains("Add a task to Shopping");
//   }
//
}
