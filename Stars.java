package StoreMode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/** 
*@author Dana Buzatu
*/

public class Stars extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public Stars() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// creating the content Panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// the content Panel contains another JPanel
		JPanel panelStars = new JPanel();
		panelStars.setBackground(Color.WHITE);
		
		// GroupLayout is helping resizing and repositioning more easily of the JPanel panelStars
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addComponent(panelStars, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(125)
					.addComponent(panelStars, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		// no specific Layout for panelStars
		panelStars.setLayout(null);
		
		// contentPane adopts the modified GroupLayout
		contentPane.setLayout(gl_contentPane);
		
		/**
		 * There will be a maximum of 5 stars displayed. 
		 * ImageIcon gets the path of the picture. 
		 * The picture is stored in a JLabel, which is rescaled
		 * Every JLabel is positioned at the same distance apart from the other ones
		 */ 
		
		ImageIcon image_l= new ImageIcon("goldstar_icon.png");
		Image img_l = image_l.getImage() ;  
		Image newimg_l = img_l.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
		image_l = new ImageIcon( newimg_l );
		JLabel lblNewLabel = new JLabel(image_l);
		lblNewLabel.setBounds(278, 11, 66, 59);
		
		
		ImageIcon image_l1= new ImageIcon("goldstar_icon.png");
		Image img_l1 = image_l1.getImage() ;  
		Image newimg_l1 = img_l1.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
		image_l1 = new ImageIcon( newimg_l1 );
		JLabel label = new JLabel(image_l1);
		label.setBounds(212, 11, 66, 59);
		
		
		ImageIcon image_l2= new ImageIcon("goldstar_icon.png");
		Image img_l2 = image_l2.getImage() ;  
		Image newimg_l2 = img_l2.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
		image_l2 = new ImageIcon( newimg_l2 );
		JLabel label_1= new JLabel(image_l2);
		label_1.setBounds(145, 11, 66, 59);
		
		
		ImageIcon image_l3= new ImageIcon("goldstar_icon.png");
		Image img_l3 = image_l3.getImage() ;  
		Image newimg_l3 = img_l3.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
		image_l3 = new ImageIcon( newimg_l3 );
		JLabel label_2 = new JLabel(image_l3);
		label_2.setBounds(79, 11, 66, 59);
		
		
		ImageIcon image_l4= new ImageIcon("goldstar_icon.png");
		Image img_l4 = image_l4.getImage() ;  
		Image newimg_l4 = img_l4.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
		image_l4 = new ImageIcon( newimg_l4 );
		JLabel label_3 = new JLabel(image_l4);
		label_3.setBounds(10, 11, 66, 59);
	
		
		// a starsNumber variable for testing the program. The stars number is about to be generated from Play Mode
	   int starsNumber = 3; 		   
	   
	    // after purchase, the number of stars will decrease with 1 unit and only starsNumber -1 stars will be displayed
		if (starsNumber == 1) {
			starsNumber = starsNumber - 1;
			System.out.println(starsNumber);
			
		}else if(starsNumber == 2){
		   panelStars.add(lblNewLabel);
		   starsNumber = starsNumber - 1;
		   System.out.println(starsNumber);
		   
	   }else if (starsNumber == 3){
		   panelStars.add(lblNewLabel);
		   panelStars.add(label);
		   starsNumber = starsNumber - 1;
		   System.out.println(starsNumber);
		   
	   }else if (starsNumber == 4){
		   panelStars.add(lblNewLabel);
		   panelStars.add(label);
		   panelStars.add(label_1);
		   starsNumber = starsNumber - 1;
		   System.out.println(starsNumber);
		   
	   }else if (starsNumber == 5){
		   panelStars.add(lblNewLabel);
		   panelStars.add(label);
		   panelStars.add(label_1);
		   panelStars.add(label_2);
		   starsNumber = starsNumber - 1;
		   System.out.println(starsNumber);
		   
	   }else 
		   infoBox("Not enough currency to purchase bundle", "Error");
	       } 
	// message displayed when gthe client doesn't have enough currency (stars) o puchase a bundle
	public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);}
	   
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stars frame = new Stars();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
