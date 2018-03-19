package Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class CorrelationEffortNoteTest {

  String csvLowerBound = "CSV/TEST_EFFORTNOTE/LowerBound.csv";
  String csvUpperBound = "CSV/TEST_EFFORTNOTE/UpperBound.csv";
  String csvInvalide = "CSV/TEST_EFFORTNOTE/Invalide.csv";
  CSVReader reader = new CSVReader();

  /***
   * Test de correlation avec des donnees plus petite
   */
  @Test
  public void testCorrelationLowerBound() {
     System.out.println("\n\tTest: Correlation Lower Bound");
    IMethodeMath correlation = new CorrelationEffortNote();
    reader.setPath(csvLowerBound);
    List<String> listData = reader.read(null);
    correlation.calculer(listData, 0.0);
    String[] split = correlation.getString().split(";");
    String[] arrayValue = {"-0.19842","0.14409","-0.09214","-0.05657","0.19227","-0.03043"};
    boolean pass = true;
    
    for(int i = 0; i < split.length;i++)
    {
      split[i] = split[i].replaceAll(";", "");
      if(!split[i].equals(arrayValue[i]))
        pass = false;
    }


    if (pass) {
      System.out.println(
          "Succes: Les valeurs correspondent aux valeurs attendues.");
    } else {
      System.out.println("Erreur: Les valeurs testes ne correspondent pas aux valeurs attendues.");
      fail("Les valeurs testes ne correspond pas aux valeurs attendues.");
    }

  }

  /***
   * Test de correlation avec des donnees plus Grande
   */
  @Test
  public void testCorrelationUpperBound() {
    System.out.println("\n\tTest: Correlation Upper Bound");
    IMethodeMath correlation = new CorrelationEffortNote();
    reader.setPath(csvUpperBound);
    List<String> listData = reader.read(null);
    correlation.calculer(listData, 0.0);
    String[] split = correlation.getString().split(";");
    String[] arrayValue = {"-0.13888","-0.13031","-0.17301","-0.06188","0.19196","-0.06072"};
    boolean pass = true;
    
    for(int i = 0; i < split.length;i++)
    {
      split[i] = split[i].replaceAll(";", "");
      if(!split[i].equals(arrayValue[i]))
        pass = false;
    }


    if (pass) {
      System.out.println(
          "Succes: Les valeurs correspondent aux valeurs attendues.");
    } else {
      System.out.println("Erreur: Les valeurs testes ne correspondent pas aux valeurs attendues.");
      fail("Les valeurs testes ne correspond pas aux valeurs attendues.");
    }

  }

  /***
   * Test de correlation avec des donnees invalide
   */
  @Test
  public void testCorrelationTypeInvalide() {
    System.out.println("\n\tTest: Correlation Upper Bound");
    IMethodeMath correlation = new CorrelationEffortNote();
    reader.setPath(csvInvalide);
    List<String> listData = reader.read(null);
    correlation.calculer(listData, 0.0);
    String[] split = correlation.getString().split(";");
    String[] arrayValue = {"0.0","0.0","0.0","0.0","0.0","0.0"};
    boolean pass = true;
    
    for(int i = 0; i < split.length;i++)
    {
      split[i] = split[i].replaceAll(";", "");
      if(!split[i].equals(arrayValue[i]))
        pass = false;
    }


    if (pass) {
      System.out.println(
          "Succes: Les valeurs correspondent aux valeurs attendues.");
    } else {
      System.out.println("Erreur: Les valeurs testes ne correspondent pas aux valeurs attendues.");
      fail("Les valeurs testes ne correspond pas aux valeurs attendues.");
    }
  }
}
