package test;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.classifier4J.ClassifierException;
import net.sf.classifier4J.vector.HashMapTermVectorStorage;
import net.sf.classifier4J.vector.TermVectorStorage;
import net.sf.classifier4J.vector.VectorClassifier;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnglishTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtAnuncio;
	private JTextField txtAlojamiento;
	private JTextField txtVentaja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnglishTest frame = new EnglishTest();
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
	public EnglishTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Written test");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(20, 22, 157, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Translate the following words");
		lblNewLabel_1.setBounds(20, 52, 325, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("1.");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 82, 21, 16);
		contentPane.add(lblNewLabel_2);

		JLabel label = new JLabel("2.");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		label.setBounds(20, 159, 21, 16);
		contentPane.add(label);

		JLabel label_1 = new JLabel("3.");
		label_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		label_1.setBounds(20, 244, 21, 16);
		contentPane.add(label_1);

		JLabel lblNewLabel_3 = new JLabel("Resultado:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_3.setBounds(20, 121, 75, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblResultadoAnuncio = new JLabel("");
		lblResultadoAnuncio.setBounds(96, 121, 431, 16);
		contentPane.add(lblResultadoAnuncio);

		JLabel lblNewLabel_5 = new JLabel("Anuncio");
		lblNewLabel_5.setBounds(50, 83, 61, 16);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Alojaminento");
		lblNewLabel_6.setBounds(50, 160, 96, 16);
		contentPane.add(lblNewLabel_6);

		JLabel lblResultadoAlojaminento = new JLabel("");
		lblResultadoAlojaminento.setBounds(96, 199, 431, 16);
		contentPane.add(lblResultadoAlojaminento);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblResultado.setBounds(20, 199, 75, 16);
		contentPane.add(lblResultado);

		JLabel lblVentaja = new JLabel("Ventaja");
		lblVentaja.setBounds(50, 245, 96, 16);
		contentPane.add(lblVentaja);

		txtAnuncio = new JTextField();
		txtAnuncio.setBounds(182, 80, 325, 26);
		contentPane.add(txtAnuncio);
		txtAnuncio.setColumns(10);

		JLabel lblResultado_1 = new JLabel("Resultado:");
		lblResultado_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblResultado_1.setBounds(20, 279, 75, 16);
		contentPane.add(lblResultado_1);

		JLabel lblResultadoVentaja = new JLabel("");
		lblResultadoVentaja.setBounds(96, 279, 431, 16);
		contentPane.add(lblResultadoVentaja);

		txtAlojamiento = new JTextField();
		txtAlojamiento.setColumns(10);
		txtAlojamiento.setBounds(182, 155, 325, 26);
		contentPane.add(txtAlojamiento);

		txtVentaja = new JTextField();
		txtVentaja.setColumns(10);
		txtVentaja.setBounds(182, 240, 325, 26);
		contentPane.add(txtVentaja);

		JButton btnNewButton = new JButton("Validar respuestas");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String respuestaAnuncio = txtAnuncio.getText();
				String respuestaAlojamiento = txtAlojamiento.getText();
				String respuestaVentaja = txtVentaja.getText();

				try {

					TermVectorStorage storage1 = new HashMapTermVectorStorage();
					VectorClassifier vc1 = new VectorClassifier(storage1);
					String traduccionAnuncio = "advertisement";

					vc1.teachMatch("sterm", respuestaAnuncio);
					double result = vc1.classify("sterm", traduccionAnuncio);
					System.out.println("Resultado anuncio" + result);

					lblResultadoAnuncio.setText(Double.toString(result));

					TermVectorStorage storage2 = new HashMapTermVectorStorage();
					VectorClassifier vc2 = new VectorClassifier(storage2);
					String traduccionAlojamineto = "accommodation";

					vc2.teachMatch("sterm2", respuestaAlojamiento);
					double result2 = vc2.classify("sterm2", traduccionAlojamineto);
					System.out.println("Resultado alojamiento" + result2);

					lblResultadoAlojaminento.setText(Double.toString(result2));

					TermVectorStorage storage3 = new HashMapTermVectorStorage();
					VectorClassifier vc3 = new VectorClassifier(storage3);
					String traduccionVentaja = "advantage";

					vc3.teachMatch("sterm3", respuestaVentaja);
					double result3 = vc3.classify("sterm3", traduccionVentaja);
					System.out.println("Resultado ventaja" + result3);

					lblResultadoVentaja.setText(Double.toString(result3));

				} catch (ClassifierException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnNewButton.setBounds(182, 324, 176, 29);

		contentPane.add(btnNewButton);
	}
}
