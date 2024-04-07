package adhi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AddBillForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Connection connection;
	protected Statement statement;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBillForm window = new AddBillForm();
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
	public AddBillForm() {
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
		
		JLabel lblBillForm = new JLabel("BILL FORM");
		lblBillForm.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		lblBillForm.setBounds(538, 46, 292, 37);
		frame.getContentPane().add(lblBillForm);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID :");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerId.setBounds(494, 151, 157, 27);
		frame.getContentPane().add(lblCustomerId);
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT :");
		lblTotalAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalAmount.setBounds(451, 294, 157, 14);
		frame.getContentPane().add(lblTotalAmount);
		
		JLabel lblPaidDate = new JLabel("PAID DATE :");
		lblPaidDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPaidDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPaidDate.setBounds(506, 362, 102, 27);
		frame.getContentPane().add(lblPaidDate);
		
		JLabel lblMembershipLength = new JLabel("PACKAGE :");
		lblMembershipLength.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMembershipLength.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMembershipLength.setBounds(518, 443, 89, 14);
		frame.getContentPane().add(lblMembershipLength);
		
		textField = new JTextField(AddMembershipForm.textField.getText());
		textField.setBounds(672, 153, 157, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(AddMembershipForm.textField_2.getText());
		textField_1.setColumns(10);
		textField_1.setBounds(673, 290, 157, 27);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(673, 364, 157, 27);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField(AddMembershipForm.aaa);
		textField_3.setColumns(10);
		textField_3.setBounds(673, 439, 157, 27);
		frame.getContentPane().add(textField_3);
		
		JLabel lblBillNo = new JLabel("BILL NO :");
		lblBillNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBillNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBillNo.setBounds(512, 226, 96, 14);
		frame.getContentPane().add(lblBillNo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(673, 222, 157, 27);
		frame.getContentPane().add(textField_4);
		
		
	/*	JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {  */
				
				
				JButton btnSave = new JButton("SAVE");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
		final StringBuilder query = new StringBuilder();
						
						
						System.out.println("Connecting to DATABASE");
						String cust_id = textField.getText();
						String bill_no = textField_4.getText();
						String  paid_date= textField_2.getText();
						String package_name =textField_3.getText();
						String total_cost = textField_1.getText();
						
						
						if (bill_no==null ||bill_no.trim().length()==0||cust_id == null || cust_id.trim().length() == 0 
								||paid_date ==null ||paid_date .trim().length()==0 ||package_name==null || package_name.trim().length()==0 ||
										total_cost==null || total_cost.trim().length()==0) {
							
							JOptionPane.showMessageDialog(null,
									"Please Enter all the Fields"); }
							else{
						
							try {
								connection = DB.getConnection();
								CallableStatement smt=connection.prepareCall("call insertBILL(?,?,?,?,?)");
								smt.setString(1,cust_id);
								smt.setString(2,bill_no);
								smt.setString(4, paid_date);
								smt.setString(5,package_name);
								smt.setString(3,total_cost);
							//	smt.setString(6,textField_3.getText());
							//	smt.setString(7,max);
								
								smt.executeQuery();
								
								
								
					/*		System.out.println("Query:" + query.toString());
								
								connection = DB.getConnection();
								statement = connection.createStatement();

								ResultSet rs = statement.executeQuery(query.toString());
								System.out.println("Inserted Successfully");   */
								
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
							textField_4.setText(null); */

						}
				
					}
			
						
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(473, 535, 89, 23);
		frame.getContentPane().add(btnSave);  
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				entity.main(new String[] {});
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(809, 535, 89, 23);
		frame.getContentPane().add(btnBack);
		
		
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				entity.main(new String[] {});
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(640, 536, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AddBillForm.class.getResource("/adhi/img/56789.png")));
		label_2.setBounds(518, 30, 282, 67);
		frame.getContentPane().add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AddBillForm.class.getResource("/adhi/img/5678.png")));
		label_1.setBounds(461, 140, 190, 326);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddBillForm.class.getResource("/adhi/img/11-1.jpg")));
		label.setBounds(0, 0, 1362, 711);
		frame.getContentPane().add(label);
	}
}
