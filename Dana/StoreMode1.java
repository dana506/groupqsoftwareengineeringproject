import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Dana Buzatu
 *
 */

public class StoreMode1 extends JFrame {

	private JPanel contentPane;

	/**
	 * 
	 * Create the frame.
	 */
	
	public StoreMode1() {
		setTitle( "Guitar Zero Live (STORE MODE)" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE, 6));
		panel.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("");
		ImageIcon icon = new ImageIcon("img1.png");
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 74, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		btnNewButton.setIcon(icon); 
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button = new JButton("");
		ImageIcon icon1 = new ImageIcon("img2.png");
		Image img1 = icon1.getImage() ;  
		Image newimg1 = img1.getScaledInstance( 74, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg1 );
		button.setIcon(icon1);
		
		JButton button_1 = new JButton("");
		ImageIcon icon2 = new ImageIcon("img3.png");
		Image img2 = icon2.getImage() ;  
		Image newimg2 = img2.getScaledInstance( 74, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon2 = new ImageIcon( newimg2 );
		button_1.setIcon(icon2);
		
		JButton button_2 = new JButton("");
		ImageIcon icon3 = new ImageIcon("img4.png");
		Image img3 = icon3.getImage() ;  
		Image newimg3 = img3.getScaledInstance( 74, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon3 = new ImageIcon( newimg3);
		button_2.setIcon(icon3);
		
		JButton button_3 = new JButton("");
		ImageIcon icon4 = new ImageIcon("img5.png");
		Image img4 = icon4.getImage() ;  
		Image newimg4 = img4.getScaledInstance( 74, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon4 = new ImageIcon( newimg4);
		button_3.setIcon(icon4);
		
		JLabel lblNewLabel = new JLabel("<html>Another-One-<br>Bites-The-Dust</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
		
		JLabel label = new JLabel("<html>Layla<br> </html>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 10));
		
		JLabel label_1 = new JLabel("<html>Money-For-<br>Nothing</html>");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial", Font.BOLD, 10));
		
		JLabel label_2 = new JLabel("<html>Smoke-On-<br>The-Water</html>");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Arial", Font.BOLD, 10));
		
		JLabel label_3 = new JLabel("<html>Sweet-Child-<br>Of-Mine</html>");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Arial", Font.BOLD, 10));
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setBorder(null);
		slider.setValue(3);
		slider.setMaximum(5);
		slider.setMinimum(1);
		slider.setForeground(Color.BLUE);
		slider.setBackground(Color.WHITE);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(slider, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(lblNewLabel)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(165)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(282)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	
	}
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreMode1 frame = new StoreMode1();
					frame.setVisible(true);
					ImagePanel panel = new ImagePanel(
					new ImageIcon("guitar.png").getImage());
					frame.getContentPane().add(panel);
					frame.pack();
					frame.setVisible(true);
					frame.setSize( 761, 600 );
			        frame.setResizable( true );
					}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
