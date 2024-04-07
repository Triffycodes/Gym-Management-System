package adhi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class AddMembershipForm {

	private JFrame frame;
	public static JTextField textField;
	private JTextField textField_1;
	public static JTextField textField_2;
	private JTextField textField_4;
	public static String  amt="0";
	public static String pkt;
	public static String aaa;
	public static String aa;
	private Connection connection;
	protected Statement statement;
	public static String trainer_id;
		public JComboBox<String> nameCB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMembershipForm window = new AddMembershipForm();
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
	public AddMembershipForm() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel lblMembership = new JLabel("MEMBERSHIP DETAILS");
		lblMembership.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		lblMembership.setBounds(505, 29, 516, 59);
		frame.getContentPane().add(lblMembership);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID :");
		lblCustomerId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerId.setBounds(355, 138, 125, 14);
		frame.getContentPane().add(lblCustomerId);
		
		JLabel lblDateCreated = new JLabel("DATE CREATED :");
		lblDateCreated.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateCreated.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateCreated.setBounds(774, 194, 125, 14);
		frame.getContentPane().add(lblDateCreated);
		
		JLabel lblMembershipLength = new JLabel("PACKAGE:");
		lblMembershipLength.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMembershipLength.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMembershipLength.setBounds(298, 252, 182, 14);
		frame.getContentPane().add(lblMembershipLength);
		
		JLabel lblExpiryDate = new JLabel("EXPIRY DATE :");
		lblExpiryDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExpiryDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExpiryDate.setBounds(774, 412, 125, 14);
		frame.getContentPane().add(lblExpiryDate);
		
		JLabel lblTrainerId = new JLabel("TRAINER ID :");
		lblTrainerId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTrainerId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrainerId.setBounds(364, 366, 116, 14);
		frame.getContentPane().add(lblTrainerId);
		
		textField = new JTextField();
		textField.setBounds(518, 134, 157, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//aa=textField.getText();
		
		textField_1 = new JTextField();
		textField_1.setBounds(967, 190, 157, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		Choice choice = new Choice();
		
		choice.setBounds(505, 252, 157, 20);
		choice.add(" select");
		choice.add("1 month");
		choice.add("3 month");
		choice.add("6 month");
		choice.add("1 year");
		frame.getContentPane().add(choice);
		
		
		nameCB = new JComboBox<String>();
		// JComboBox comboBox = new JComboBox();
		 loadData();
		 nameCB.setBounds(505, 365, 157, 20);
		frame.getContentPane().add(nameCB);
		
		
				
				
				JButton btnSave = new JButton("SAVE");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
		final StringBuilder query = new StringBuilder();
						
						
						System.out.println("Connecting to DATABASE");
						String cust_id = textField.getText();
						String date_created = textField_1.getText();
						String package_name =choice.getSelectedItem();
						String total_cost = textField_2.getText();
						
						String expiry_date =textField_4.getText();
					
						 trainer_id =nameCB.getItemAt(nameCB.getSelectedIndex());
						
						if (trainer_id==null || trainer_id.trim().length()==0||cust_id == null || cust_id.trim().length() == 0 
								||date_created ==null ||date_created .trim().length()==0 ||package_name=="select" || package_name.trim().length()==0 ||
										total_cost==null || total_cost.trim().length()==0 ||expiry_date==null || expiry_date.trim().length()==0) {
							
							JOptionPane.showMessageDialog(null,
									"Please Enter all the Fields");
						
						} else {
							query.append(
									"insert into membership values(").append("'")
							.append(cust_id.trim()).append("','")
							.append(date_created.trim()).append("','")
									.append(package_name.trim()).append("','")
									.append(expiry_date.trim()).append("','")
									.append(total_cost.trim()).append("','")
									
									.append(trainer_id.trim()).append("')");
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
						//	textField.setText(null);
						//	textField_1.setText(null);
						  // choice.getSelectedItem("select");
							
							//textField_2.setText(null);
						//	textField_3.setText(null);

						}
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(518, 468, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AddTrainerForm.main(new String[] {});
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(854, 468, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblTotalCost = new JLabel("TOTAL COST :");
		lblTotalCost.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotalCost.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalCost.setBounds(787, 307, 112, 14);
		frame.getContentPane().add(lblTotalCost);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(967, 408, 157, 27);
		frame.getContentPane().add(textField_4);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				aaa=choice.getSelectedItem();
						 pkt=choice.getSelectedItem();
						if("1 month".equals(pkt))
						{
							amt="1000";
							
						}
						if("3 month".equals(pkt))
						{
							amt="2800";
						}
						if("6 month".equals(pkt))
						{
							amt="5000";
						}
						if("1 year".equals(pkt))
						{
							amt="8000";
						}
						

						textField_2 = new JTextField(amt);
						textField_2.setBounds(967, 303, 157, 27);
						frame.getContentPane().add(textField_2);
						textField_2.setColumns(10);
					}
					
					
				}
				);
				
				
	
		btnOk.setBounds(532, 285, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addcustom.main(new String[] {});
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNext.setBounds(683, 469, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AddMembershipForm.class.getResource("/adhi/img/55-10.png")));
		label_1.setBounds(475, 29, 546, 53);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddMembershipForm.class.getResource("/adhi/img/55-9.jpg")));
		label.setBounds(0, 0, 1362, 711);
		frame.getContentPane().add(label);
		
		
	
		
	}
		
		private void loadData() {
			ArrayList<String> namesList = new ArrayList<String>();
			ResultSet rsone;
			try {
				connection = DB.getConnection();
				statement = connection.createStatement();
				ResultSet rsone1 = statement
						.executeQuery("select COUNT(*) from trainer");

			int rowCount = 0;
				while (rsone1.next()) {
					rowCount = rsone1.getInt(1);
				}

				ResultSet rstwo = statement
						.executeQuery("select * from trainer");

				if (rowCount ==0)
					JOptionPane.showMessageDialog(null, "No Results to Display");
				else {
					System.out.println("Result set Size is :" + rowCount);
					for (int i = 0; i<rowCount; i++) {
						if (rstwo.next()) {
							nameCB.addItem(rstwo.getString(1));
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		

	}
}
