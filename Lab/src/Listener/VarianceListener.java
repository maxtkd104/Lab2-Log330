package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.*;

import Main.AffichageHTML;
import Main.CreateWindow;
import Calcul.*;

public class VarianceListener implements ActionListener {

	JPanel panel;
	CreateWindow frame;
	CSVReader csvReader;
	IMethodeMath Moyenne;
	IMethodeMath Variance;
	IMethodeMath EcartType;
	AffichageHTML html;

	public VarianceListener(CreateWindow frame) {
		this.frame = frame;
		csvReader = new CSVReader();
		Moyenne = new Moyenne();
		Variance = new Variance();
		EcartType = new EcartType();
		html = new AffichageHTML();
	}

	// Creation du panel d'affichage de la variance
	@Override
	public void actionPerformed(ActionEvent e) {
		panel = new JPanel();
		
		List<String> data;
		String absolutePath = null;
		
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(frame); 
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		 
		if (fc.getSelectedFile() != null) { absolutePath =
		fc.getSelectedFile().getAbsolutePath();
		 
		DecimalFormat df = new DecimalFormat(); df.setMaximumFractionDigits(5);
		
		try { 
			// Fichier CSV Seulement 
			if (absolutePath.endsWith(".csv")) { 
				data = csvReader.read(absolutePath);
			
			
				if (csvReader.getRowCount() != 1) { 
					throw new Exception("Fichier CSV Invalide"); 
				}
			
				JLabel labelMoyenne = new JLabel("");
				JLabel labelVariance = new JLabel("");
				JLabel labelEcartType = new JLabel("");
				JLabel labelDataList = new JLabel("");
				
				Moyenne.calculer(data, 0.0); Variance.calculer(data, Moyenne.get());
				EcartType.calculer(data, Variance.get());
				
				labelMoyenne.setText("Moyenne: " + String.valueOf(df.format(Moyenne.get())));
				labelVariance.setText("Variance: " + String.valueOf(df.format(Variance.get())));
				labelEcartType.setText("Ecart-Type: " +	String.valueOf(df.format(EcartType.get())));
				
				labelDataList.setText(html.afficher(data, csvReader.getRowCount()));
				
				panel.add(labelMoyenne);
				panel.add(labelVariance);
				panel.add(labelEcartType);
				panel.add(labelDataList);
				frame.setPanel(panel);
			
			} 
			else { 
				throw new Exception("Erreur: Le fichier selectionne n'est pas un fichier CSV."); }
			} 
			catch (Exception ex) {
				System.out.println(ex.getMessage()); 
			}
		 
		}
	}
}
