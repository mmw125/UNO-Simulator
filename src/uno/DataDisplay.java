package uno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

public class DataDisplay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 * @param data
	 *            The data generated in the simulator portion of the program
	 */
	public DataDisplay(double[][] data, int highNumCards, int highNumPlay) {
		// System.out.println("highNumCards: "+highNumCards);
		// System.out.println("highNumPlay: "+highNumPlay);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 603);
		setSize(1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Cards");
		// lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lblNewLabel, BorderLayout.WEST);

		JLabel lblPlayers = new JLabel("Players");
		// lblPlayers.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayers.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lblPlayers, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(highNumCards, highNumPlay, 0, 0));

		JLabel blankLabel = new JLabel();
		panel.add(blankLabel);

		for (int count = 2; count < highNumPlay; count++) {
			JLabel label = new JLabel(count + "");
			label.setBorder(new LineBorder(new Color(0, 0, 0)));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.PLAIN, 20));
			panel.add(label);
		}

		for (int count1 = 2; count1 < highNumCards; count1++) {
			for (int count2 = 1; count2 < highNumPlay; count2++) {
				JLabel nLabel;
				if (count2 == 1) {
					nLabel = new JLabel(count1 + "");
				} else {
					nLabel = new JLabel(data[count1][count2] + "");
				}
				nLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
				nLabel.setHorizontalAlignment(SwingConstants.CENTER);
				nLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				panel.add(nLabel);
			}
		}
	}
}