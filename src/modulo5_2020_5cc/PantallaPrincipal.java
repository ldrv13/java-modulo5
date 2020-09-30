package modulo5_2020_5cc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PantallaPrincipal extends JFrame{

	private JLabel number1Label;
	private JLabel number2Label;
	private JLabel resultLabel;
	
	private JTextField number1TextField;
	private JTextField number2TextField;
	
	private JRadioButton minJRadioButton;
	private JRadioButton maxJRadioButton;
	private JRadioButton powJRadioButton;
	private JRadioButton sqrtJRadioButton;
	
	private JButton submitJButton;
	
	public PantallaPrincipal(String titulo) {
		super(titulo); // la llamada a super debe ser la primera linea de codigo en el constructor.
		
		GridLayout layout = new GridLayout();
		layout.setRows(4);
		layout.setColumns(1);
		this.setLayout(layout); // asignar el layout a la pantalla.
		
		number1Label = new JLabel("Number 1");
		number2Label = new JLabel("Number 2");
		number1TextField = new JTextField();
		number1TextField.setColumns(10);
		number2TextField = new JTextField();
		number2TextField.setColumns(10);
		
		JPanel panel1 = new JPanel();
		panel1.add(number1Label);
		panel1.add(number1TextField);
		
		panel1.add(number2Label);
		panel1.add(number2TextField);
		
		this.add(panel1);
		
		minJRadioButton = new JRadioButton("min(x,y)");
		maxJRadioButton = new JRadioButton("max(x,y)");
		powJRadioButton = new JRadioButton("pow(x,y)");
		sqrtJRadioButton = new JRadioButton("sqrt(x,y)");
		
		JPanel panel2 = new JPanel();
		panel2.add(minJRadioButton);
		panel2.add(maxJRadioButton);
		panel2.add(powJRadioButton);
		panel2.add(sqrtJRadioButton);
		this.add(panel2);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(minJRadioButton);
		radioGroup.add(maxJRadioButton);
		radioGroup.add(powJRadioButton);
		radioGroup.add(sqrtJRadioButton);
		
		resultLabel = new JLabel("Resultado: ");
		JPanel panel3 = new JPanel();
		panel3.add(resultLabel);
		this.add(panel3);
		
		submitJButton = new JButton("Calcular");
		submitJButton.addActionListener( new SubmitButtonHandler() );
		JPanel panel4 = new JPanel();
		panel4.add(submitJButton);
		this.add(panel4);
		
	}
	
	private class SubmitButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int number1 = Integer.parseInt( number1TextField.getText() );
			int number2 = Integer.parseInt( number2TextField.getText() );
			
			if (minJRadioButton.isSelected()) {
				// calcular el minimo
				int resultado = Math.min(number1,  number2);
				resultLabel.setText("Resultado: " + resultado);
				
			} else if (maxJRadioButton.isSelected()) {
				// calculo el maximo
				int resultado = Math.max(number1,  number2);
				resultLabel.setText("Resultado: " + resultado);
				
			} else if (powJRadioButton.isSelected()) {
				// calculo la potencia
				double resultado = Math.pow(number1, number2);
				resultLabel.setText("Resultado: " + resultado);
				
			} else if (sqrtJRadioButton.isSelected()) {
				// calculo la raiz cuadrada
				double resultado = Math.sqrt(number1);
				resultLabel.setText("Resultado: " + resultado);
			}
			
			
		}
		
	}
	
}
