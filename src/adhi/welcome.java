package adhi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;

public class welcome {

	private JFrame frame;
	public static JTextField textField;
	public static String u1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome window = new welcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcome() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.CYAN);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 72));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(-7,-5,1380,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGymManagementSystem = new JLabel("GYM MANAGEMENT SYSTEM");
		lblGymManagementSystem.setFont(new Font("Mistral", Font.BOLD, 93));
		lblGymManagementSystem.setBackground(Color.BLACK);
		lblGymManagementSystem.setForeground(Color.BLACK);
		lblGymManagementSystem.setBounds(219, 155, 965, 83);
		frame.getContentPane().add(lblGymManagementSystem);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(229, 442, 151, 28);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		lblPassword.setBounds(229, 481, 151, 40);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblDevelopedBy = new JLabel("Developed by:-");
		lblDevelopedBy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDevelopedBy.setBounds(1045, 570, 161, 25);
		frame.getContentPane().add(lblDevelopedBy);
		
		JLabel lblAdarshS = new JLabel("ADARSH  S");
		lblAdarshS.setForeground(new Color(0, 0, 0));
		lblAdarshS.setFont(new Font("Mistral", Font.BOLD, 25));
		lblAdarshS.setBounds(1129, 606, 122, 28);
		frame.getContentPane().add(lblAdarshS);
		
		JLabel lblSagarNp = new JLabel("SAGAR  NP");
		lblSagarNp.setFont(new Font("Mistral", Font.BOLD, 25));
		lblSagarNp.setBounds(1129, 636, 132, 28);
		frame.getContentPane().add(lblSagarNp);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(399, 445, 109, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setForeground(Color.BLACK);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String u="as2009";
				String p="as2009";
				String u1=textField.getText();
				String p1=passwordField.getText();
				if(u1 == null || u1.trim().length() == 0 ||
						p1 == null || p1.trim().length() == 0 ){
					JOptionPane.showMessageDialog(null, "enter all the fields");
				}
				else if(u.equals(u1)){
					if(p.equals(p1)){
						//frame.dispose();
						entity.main(new String[] {});
					}
					else{
						JOptionPane.showMessageDialog(null, "enter the correct username & password");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "enter the correct username & password");
				}
				
				
			}
		});
		btnLogin.setBounds(274, 545, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				wel.main(new String[] {});
			}
		});
		btnBack.setBounds(390, 545, 89, 23);
		frame.getContentPane().add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(399, 490, 109, 28);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(welcome.class.getResource("/adhi/img/111-1.png")));
		label.setBounds(478, 532, 89, 50);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(welcome.class.getResource("/adhi/img/122.png")));
		label_2.setBounds(357, 481, 39, 40);
		frame.getContentPane().add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(welcome.class.getResource("/adhi/img/122.png")));
		label_1.setBounds(357, 442, 39, 24);
		frame.getContentPane().add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(welcome.class.getResource("/adhi/img/13-2.jpg")));
		label_3.setBounds(0, 0, 1380, 750);
		frame.getContentPane().add(label_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnForgetPassword = new JRadioButton("FORGET PASSWORD");
		rdbtnForgetPassword.setBounds(309, 587, 142, 23);
		frame.getContentPane().add(rdbtnForgetPassword);
		rdbtnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "please contact ADARSH (9481616462) & SAGAR (9483295929)");
			}
		});
			}
	}

