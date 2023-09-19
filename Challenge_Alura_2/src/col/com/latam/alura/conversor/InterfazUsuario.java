package col.com.latam.alura.conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class InterfazUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;
	protected float conversionDolar;
	protected float valorDolar;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazUsuario frame = new InterfazUsuario();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 63, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 91, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, 148, SpringLayout.WEST, getContentPane());
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("convertir");
		btnNewButton.addActionListener(new ActionListener() {
			private double conversionDolar;
			private float valorDolar;
			private float valorCambio;
			private float coinValue;
			private String regex = "[0-9]";
		
			
			
			public void actionPerformed(ActionEvent e) {
				boolean isMatch = Pattern.compile("^(?:-(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))|(?:0|(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))))(?:.\\d+|)$")
			               .matcher(textField.getText())
			               .find(); 
				System.out.println(isMatch); // prints true
				if(textField.getText().isEmpty()) {
					lblNewLabel_6.setVisible(true);
				}else {
					if(isMatch) {
					lblNewLabel_6.setVisible(false);
					coinValue = Float.parseFloat(textField.getText());						
					String country = String.valueOf(comboBox.getSelectedItem());
					String conversion = String.valueOf(comboBox_1.getSelectedItem());
					Moneda coin = new Moneda();
					coin.getCoin(country);
					this.conversionDolar = 1/coin.dolarExchange();
					this.valorDolar = (float) (this.conversionDolar * coinValue);
					System.out.println(coinValue + " " +country+ " equivalen a " + this.valorDolar+"u.s");
					coin.getCoin(conversion);
					this.conversionDolar = coin.dolarExchange();
					System.out.println("Pasar de dolar a " + country + " multiplicar por: " + this.conversionDolar);
					this.valorCambio = (float) (this.conversionDolar * this.valorDolar);
					lblNewLabel_3.setText("Cambio a moneda: "+ Math.round(this.valorCambio)+" en " + conversion);
					}else {
						lblNewLabel_6.setText("Solo puedes introducir valores numéricos");
						lblNewLabel_6.setVisible(true);
					}
					}
				
						}//End else/if
		});
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Conversor de Monedas");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 152, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lblNewLabel_6.setVisible(true);
				textField.setText("");
				lblNewLabel_3.setText("???");
				lblNewLabel_6.setVisible(false);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnNewButton_1);
		
		comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 4, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -201, SpringLayout.EAST, getContentPane());
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"dolar", "euro", "francoSuizo", "libra", "peso", "rupla", "yen"}));
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 38, SpringLayout.SOUTH, lblNewLabel);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Convertir la moneda a ?");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 11, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"dolar", "euro", "libra", "francoSuizo", "peso", "rupla", "yen"}));
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 10, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 10, SpringLayout.WEST, lblNewLabel_1);
		getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 82, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 174, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("???");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_2);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 30, SpringLayout.EAST, comboBox);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_6 = new JLabel("Debes llenar el campo");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -6, SpringLayout.NORTH, textField);
		getContentPane().add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setLblNewLabel_3(JLabel lblNewLabel_3) {
		this.lblNewLabel_3 = lblNewLabel_3;
	}
}
