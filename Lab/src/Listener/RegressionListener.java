package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.*;

import Main.AffichageHTML;
import Main.CreateWindow;
import Main.ValeurCorrelation;
import Calcul.*;

public class RegressionListener implements ActionListener {

	JPanel panel;
	CreateWindow frame;
	CSVReader csvReader;
	Regression regression;
	AffichageHTML html;

	public RegressionListener(CreateWindow frame) {
		this.frame = frame;
		csvReader = new CSVReader();
		regression = new Regression();
		html = new AffichageHTML();
	}

	// Creation du panel d'affichage de la regression
	@Override
	public void actionPerformed(ActionEvent e) {
		panel = new JPanel();

		List<String> data;
		String absolutePath = null;

		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(frame);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

		if (fc.getSelectedFile() != null) {
			absolutePath = fc.getSelectedFile().getAbsolutePath();

			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(5);

			try {
				// Fichier CSV Seulement
				if (absolutePath.endsWith(".csv")) {
					data = csvReader.read(absolutePath);
					if (csvReader.getRowCount() != 2) {
						throw new Exception("Fichier CSV Invalide");
					}

					regression.calculer(data);

					JLabel labelRegression = new JLabel("");
					JLabel labelFormule = new JLabel("");
					JLabel labelDataList = new JLabel("");
					JLabel labelEquationSolve = new JLabel("");

					labelRegression.setText("<html>Valeur de b1:  " + String.valueOf(df.format(regression.getPente()))
							+ "<br>Valeur de b2: " + String.valueOf(df.format(regression.getConstante())));

					labelFormule.setText("Y = " + String.valueOf(df.format(regression.getPente())) + " * m + "
							+ String.valueOf(df.format(regression.getConstante())));

					labelDataList.setText(html.afficher(data, csvReader.getRowCount()));

					panel.add(labelRegression);
					panel.add(labelFormule);
					panel.add(labelDataList);

					// Boutton de requete pour X et Y
					JButton buttonGetXFromY = new JButton("Trouver X");
					JButton buttonGetYFromX = new JButton("Trouver Y");
					buttonGetXFromY.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							String value = JOptionPane.showInputDialog(frame, "La valeur de Y ?", null);
							try {
								double y = Double.parseDouble(value.replaceAll(",", "."));

								labelEquationSolve
										.setText("X = " + String.valueOf(df.format(regression.calculateXFromY(y))));
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						}
					});

					buttonGetYFromX.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							String value = JOptionPane.showInputDialog(frame, "La valeur de X ?", null);
							try {
								double x = Double.parseDouble(value.replaceAll(",", "."));

								labelEquationSolve
										.setText("Y = " + String.valueOf(df.format(regression.calculateYFromX(x))));
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						}
					});

					panel.add(buttonGetXFromY);
					panel.add(buttonGetYFromX);
					panel.add(labelEquationSolve);

					frame.setPanel(panel);

				} else {
					throw new Exception("Erreur: Le fichier selectionne n'est pas un fichier CSV.");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		}
	}
}
