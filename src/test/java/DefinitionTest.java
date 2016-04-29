import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @After
  public void tearDown() {
    Definition.clear();
  }

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("greet someone");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithStatement_String() {
    Definition myDefinition = new Definition("greet someone");
    assertEquals("greet someone", myDefinition.getMeaning());
  }
  
  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("greet someone");
    Definition secondDefinition = new Definition("expressing sarcasm or anger");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("greet someone");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_definitionInstantiateWithAnID_1() {
    Definition myDefinition = new Definition("expressing sarcasm or anger");
    assertEquals(1, myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("greet someone");
    Definition secondDefinition = new Definition("expressing sarcasm or anger");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenDefinitionNotFound_null() {
    assertTrue(Definition.find(999) == null);
  }

}
