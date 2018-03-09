package Calcul;

import java.util.List;
import java.util.ArrayList;

public class Regression {

	List<String> dataX;
	List<String> dataY;
	double pente;
	double constante;
	int n;

	public void calculer(List<String> listDonner) {

		dataX = new ArrayList<String>();
		dataY = new ArrayList<String>();
		pente = 0.0;
		constante = 0.0;
		n = 0;

		IMethodeMath Moyenne = new Moyenne();

		try {
			n = Integer.parseInt(listDonner.get(0).replaceAll(";", "")); // Nombre de chiffres
			double sumXX = 0.0; // Somme des Xi^2
			double moyX = 0.0; // moyenne des X
			double moyY = 0.0; // moyenne des Y
			double sumXY = 0.0; // Somme des xi * yi
			double upperb1 = 0.0; // Partie superieur de la division pour b1
			double lowerb1 = 0.0; // Partie inferieur de la division pour b1

			// Assigne le nombre d'element a chaque liste dans l entete
			dataX.add(String.valueOf(n));
			dataY.add(String.valueOf(n));

			// Remplir les tableaux X et Y
			for (int i = 1; i <= n; i++) {
				String[] split = listDonner.get(i).split(";");

				dataX.add(split[0].replaceAll(";", ""));// Valeur X

				dataY.add(split[1].replaceAll(";", ""));// Valeur Y
			}

			// Moyenne X
			Moyenne.calculer(dataX, 0);
			moyX = Moyenne.get();

			// Moyenne Y
			Moyenne.calculer(dataY, 0);
			moyY = Moyenne.get();

			// Calcuer la somme des x carre
			for (int i = 1; i <= n; i++) {
				double x = Double.parseDouble(dataX.get(i));
				sumXX += x * x;
			}

			// Calcuer la partie superieur de b1
			for (int i = 1; i <= n; i++) {
				double x = Double.parseDouble(dataX.get(i));
				double y = Double.parseDouble(dataY.get(i));
				sumXY += x * y;
			}

			upperb1 = sumXY - n * moyX * moyY;

			// Calcuer la partie inferieur de b1
			lowerb1 += sumXX - n * moyX * moyX;

			pente = upperb1 / lowerb1;
			constante = moyY - pente * moyX;

		} catch (Exception ex) {
			pente = 0.0;
			constante = 0.0;
		}
	}

	public double calculateYFromX(double x) {
		return pente * x + constante;
	}

	public double calculateXFromY(double y) {
		return (y - constante) / pente;
	}

	public double getPente() {
		return pente;
	}

	public double getConstante() {
		return constante;
	}

}