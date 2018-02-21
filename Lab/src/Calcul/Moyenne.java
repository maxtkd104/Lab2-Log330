package Calcul;

import java.util.List;

/**
 * Cette classe permet de calculer la moyenne a partir d'une liste
 * 
 * N'utilise pas la variable inputValue
 * 
 */
public class Moyenne implements IMethodeMath {

  private double Moyenne;

  @Override
  public double calculer(List<String> listDonner, double inputValue) {

    double somme = 0;
    double moyenne = 0.0;
    int arraySize = Integer.parseInt(listDonner.get(0));

    try {


      for (int i = 1; i <= arraySize; i++) {
        somme += Integer.parseInt(listDonner.get(i));
      }
      Moyenne = (1.0 / (arraySize)) * somme;
    } catch (Exception ex) {

      moyenne = 0.0;
    }


    return Moyenne;

  }

  public double get() {
    return Moyenne;
  }

}

