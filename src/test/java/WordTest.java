import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {
    Word.clear();
    // Definition.clear();
  }

  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Hello");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWord_wordInstantiatesWithOneWord_Hello() {
    Word testWord = new Word("Hello");
    assertEquals("Hello", testWord.getWord());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Hello");
    Word secondWord = new Word("Java");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_emptiesAllWordList_0() {
    Word testWord = new Word("Hello");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void getId_wordInstantiateWithAnId_1() {
    Word testWord = new Word("Hello");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
    Word firstWord = new Word("Home");
    Word secondWord = new Word("Java");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }
//
//   @Test
//   public void find_returnsNullWhenNoWordFound_null() {
//     assertTrue(Word.find(999) == null);
//   }
//
//   @Test
//   public void addDefinition_addsDefinitionToList_true() {
//     Word testWord = new Word("Home");
//     Definition testDefinition = new Definition("Mow the lawn");
//     testWord.addDefinition(testDefinition);
//     assertTrue(testWord.getDefinitions().contains(testDefinition));
//   }
}
