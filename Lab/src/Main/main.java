package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.*;
import Calcul.*;
import Menu.MenuBar;

public class main {

	private static List<String> data;
	private static IMethodeMath Moyenne;
	private static IMethodeMath Variance;
	private static IMethodeMath EcartType;
	private static IMethodeMath Correlation;
	private static Regression Regression;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Moyenne = new Moyenne();
		Variance = new Variance();
		EcartType = new EcartType();
		Correlation = new Correlation();
		Regression = new Regression();

		CreateWindow win = new CreateWindow();
		win.setVisible(true);
	}
}
