import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.io.IOException;
import javax.swing.JTextArea;

public class StoreMode extends JFrame {

	
	private JPanel contentPane;	

	public StoreMode() throws IOException {
		setTitle( "Guitar Zero Live (STORE MODE)" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(6, 6, 6, 6, (Color) Color.BLUE));
		
		JButton button = new JButton("");
		ImageIcon icon = new ImageIcon("img1.png");
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 93, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		button.setIcon(icon);
		
		JButton button_1 = new JButton("");
		ImageIcon icon1 = new ImageIcon("img2.png");
		Image img1 = icon1.getImage() ;  
		Image newimg1 = img1.getScaledInstance( 93, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg1 );
		button_1.setIcon(icon1);
		
		JButton button_2 = new JButton("");
		ImageIcon icon2 = new ImageIcon("img3.png");
		Image img2 = icon2.getImage() ;  
		Image newimg2 = img2.getScaledInstance( 93, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon2 = new ImageIcon( newimg2 );
		button_2.setIcon(icon2);
		
		JButton button_3 = new JButton("");
		ImageIcon icon3 = new ImageIcon("img4.png");
		Image img3 = icon3.getImage() ;  
		Image newimg3 = img3.getScaledInstance( 93, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon3 = new ImageIcon( newimg3);
		button_3.setIcon(icon3);
		
		JButton button_4 = new JButton("");
		ImageIcon icon4 = new ImageIcon("img5.png");
		Image img4 = icon4.getImage() ;  
		Image newimg4 = img4.getScaledInstance( 93, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon4 = new ImageIcon( newimg4);
		button_4.setIcon(icon4);
		
		JLabel lbl = new JLabel("");
		lbl.setIcon(new ImageIcon("guitar.png"));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lbl, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lbl, GroupLayout.PREFERRED_SIZE, 193, Short.MAX_VALUE)
					.addGap(14)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JTextArea txtrTheone = new JTextArea();
		txtrTheone.setTabSize(7);
		txtrTheone.setText("Another-One-\r\nBites-The-Dust");
		txtrTheone.setFont(new Font("Arial", Font.BOLD, 10));
		
		JTextArea txtrLayla = new JTextArea();
		txtrLayla.setTabSize(7);
		txtrLayla.setText("Layla");
		txtrLayla.setFont(new Font("Arial", Font.BOLD, 10));
		txtrLayla.setAlignmentX(CENTER_ALIGNMENT);
		
		JTextArea txtrMoneyforNothing = new JTextArea();
		txtrMoneyforNothing.setTabSize(7);
		txtrMoneyforNothing.setText("Money-For-\r\nNothing");
		txtrMoneyforNothing.setFont(new Font("Arial",Font.BOLD, 10));
		txtrMoneyforNothing.setAlignmentX(CENTER_ALIGNMENT);
		
		JTextArea txtrSmokeonThewater = new JTextArea();
		txtrSmokeonThewater.setTabSize(7);
		txtrSmokeonThewater.setText("Smoke-On-\r\nThe-Water");
		txtrSmokeonThewater.setFont(new Font("Arial", Font.BOLD, 10));
		txtrSmokeonThewater.setAlignmentX(CENTER_ALIGNMENT);
		
		JTextArea txtrSweetchildOfmine = new JTextArea();
		txtrSweetchildOfmine.setTabSize(7);
		txtrSweetchildOfmine.setText("Sweet-Child-\r\nOf-Mine");
		txtrSweetchildOfmine.setFont(new Font("Arial", Font.BOLD, 10));
		txtrSweetchildOfmine.setAlignmentX(CENTER_ALIGNMENT);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 82, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtrTheone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtrLayla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrMoneyforNothing, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtrSmokeonThewater, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
							.addComponent(txtrSweetchildOfmine, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtrTheone, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrLayla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrSmokeonThewater, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrSweetchildOfmine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrMoneyforNothing, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(7))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
		/**
		 * Launch the application.
		 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreMode frame = new StoreMode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
