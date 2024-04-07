package adhi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.Checkbox;
import java.awt.Scrollbar;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class addcustom {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public JTextField textField_6;
	
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private Connection connection;
	protected Statement statement;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addcustom window = new addcustom();
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
	public addcustom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(-7,-5,1380,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("CUSTOMER DETAILS");
		lblCustomerDetails.setForeground(Color.BLACK);
		lblCustomerDetails.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		lblCustomerDetails.setBounds(465, 11, 560, 53);
		frame.getContentPane().add(lblCustomerDetails);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID :");
		lblCustomerId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerId.setBounds(98, 108, 133, 30);
		frame.getContentPane().add(lblCustomerId);
		
		textField = new JTextField();
		textField.setBounds(292, 167, 153, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCutomerName = new JLabel("NAME :");
		lblCutomerName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCutomerName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCutomerName.setBounds(109, 167, 124, 30);
		frame.getContentPane().add(lblCutomerName);
		
		textField_1 = new JTextField(AddMembershipForm.textField.getText());
		textField_1.setBounds(292, 110, 153, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("AGE :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(168, 239, 63, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(292, 231, 153, 27);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMobNo = new JLabel("MOB NO :");
		lblMobNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMobNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobNo.setBounds(123, 297, 108, 14);
		frame.getContentPane().add(lblMobNo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(292, 289, 153, 27);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setBounds(123, 433, 108, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(731, 110, 89, 27);
		frame.getContentPane().add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setBounds(896, 108, 153, 27);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblGender = new JLabel("GENDER :");
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(154, 366, 77, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblState = new JLabel("TRAINER ID :");
		lblState.setHorizontalAlignment(SwingConstants.TRAILING);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblState.setBounds(689, 175, 133, 14);
		frame.getContentPane().add(lblState);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(292, 366, 89, 20);
		frame.getContentPane().add(choice_1);
		choice_1.add("");
		choice_1.add("male");
		choice_1.add("female");
		
		textField_5 = new JTextField();
		textField_5.setBounds(292, 429, 153, 27);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
	/*	JButton btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(435, 593, 89, 23);
		frame.getContentPane().add(btnSave);  */
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
final StringBuilder query = new StringBuilder();
				
				
				System.out.println("Connecting to DATABASE");
				String name = textField.getText();
				String cust_id = textField_1.getText();
				String age = textField_2.getText();
				String mob = textField_3.getText();
				String gender =choice_1.getSelectedItem();
				String address =textField_5.getText();
				String email  =textField_4.getText();
				String trainer_id = textField_9.getText();
				String package_name = textField_7.getText();
				String total_cost = textField_8.getText();
			//	textField_1  
				//textField_2  age
				// textField_3   mob_no
				// choice_1  gender
				// textField_5   address
				// textField_4  email 
				// textField_9  trainer_id
				// textField_7   package_name
				// textField_8 total_cost
				
				
				
				
				
				
				if ( address==null || address.trim().length()==0|| mob==null || mob.trim().length()==0||age==null || age.trim().length()==0||trainer_id==null || trainer_id.trim().length()==0||cust_id == null || cust_id.trim().length() == 0 
						||name ==null ||name .trim().length()==0 ||gender=="select" || gender.trim().length()==0 ||
								total_cost==null || total_cost.trim().length()==0 ||email==null || email.trim().length()==0) {
					
					JOptionPane.showMessageDialog(null,
							"Please Enter all the Fields");
				
				} else {
					query.append(
							"insert into customer values(").append("'")
					.append(cust_id.trim()).append("','")
					.append(name.trim()).append("','")
					.append(age.trim()).append("','")
					.append(mob.trim()).append("','")
					.append(gender.trim()).append("','")
					.append(address.trim()).append("','")
					.append(email.trim()).append("','")
					.append(trainer_id.trim()).append("','")
					.append(package_name.trim()).append("','")
					.append(total_cost.trim()).append("')");
							
							
					try {
						System.out.println("Query:" + query.toString());
						
						connection = DB.getConnection();
						statement = connection.createStatement();

						ResultSet rs = statement.executeQuery(query.toString());
						System.out.println("Inserted Successfully");
						
						JOptionPane.showMessageDialog(null,
								"Data Inserted Successfully");
						connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				/*	textField.setText(null);
					textField_1.setText(null);
				  // choice.getSelectedItem("select");
					
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					// textField_6.setText(null);
					textField_7.setText(null);
					textField_8.setText(null);
					textField_9.setText(null);   */

				}
		
		
	}
});
btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
btnSave.setBounds(440, 594, 89, 23);
frame.getContentPane().add(btnSave);
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				entity.main(new String [] {});
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(786, 593, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblPackage = new JLabel("PACKAGE :");
		lblPackage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPackage.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPackage.setBounds(724, 231, 98, 14);
		frame.getContentPane().add(lblPackage);
		
		
		
		
		JLabel lblTotalCost = new JLabel("TOTAL COST :");
		lblTotalCost.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotalCost.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalCost.setBounds(712, 297, 108, 14);
		frame.getContentPane().add(lblTotalCost);
		
		textField_7 = new JTextField(AddMembershipForm.aaa);
		textField_7.setColumns(10);
		textField_7.setBounds(896, 227, 153, 27);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField(AddMembershipForm.textField_2.getText());
		textField_8.setColumns(10);
		textField_8.setBounds(896, 292, 153, 27);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField(AddMembershipForm.trainer_id);
		textField_9.setColumns(10);
		textField_9.setBounds(896, 164, 153, 27);
		frame.getContentPane().add(textField_9);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddEquipmentForm.main(new String[] {});
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNext.setBounds(616, 595, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JLabel label = new JLabel("");
		label.setBounds(383, 40, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(addcustom.class.getResource("/adhi/img/888.png")));
		label_1.setBounds(413, 11, 539, 53);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(addcustom.class.getResource("/adhi/img/9999-3.jpg")));
		label_2.setBounds(0, 0, 1362, 711);
		frame.getContentPane().add(label_2);
		
		
		
		
		
		
		
		
	}
}
