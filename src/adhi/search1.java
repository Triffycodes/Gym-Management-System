package adhi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;



public class search1 {

	private JFrame frame;
	private Connection connection;
	protected Statement statement;
	JComboBox<String> comboBox;
	JLabel label,label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8,label_9,label_10,label_11;
	public static int z=0;
	public static String name,address,total_cost,mob,email,trainer_id,gender,package_name,cust_id,bill_no,trainer_name,age;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search1 window = new search1();
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
	public search1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		frame.setBounds(00, 00, 1366, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeleteCruise = new JLabel("CUSTOMER DETAILS");
		lblDeleteCruise.setForeground(Color.BLACK);
		lblDeleteCruise.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblDeleteCruise.setBounds(23, 23, 592, 46);
		frame.getContentPane().add(lblDeleteCruise);
		
		comboBox= new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		loadData();
		comboBox.setBounds(354, 287, 178, 29);
		//frame.getContentPane().add(comboBox);
		
		
		JScrollPane scrollPane = new JScrollPane(comboBox);
		scrollPane.setBounds(158, 127, 215, 29);
		frame.getContentPane().add(scrollPane);
		
		

		
		
		
		JButton btnDelete = new JButton("Search");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(z>0)
				{
				label.setText(null);label_1.setText(null);label_2.setText(null);label_3.setText(null);label_4.setText(null);
				label_5.setText(null);label_6.setText(null);label_7.setText(null);label_8.setText(null);label_9.setText(null);label_10.setText(null);label_11.setText(null);
				}	
				loadData1();
				

				JLabel lblName = new JLabel("NAME :");
				lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblName.setBounds(88, 210, 77, 29);
				frame.getContentPane().add(lblName);
				
				 label = new JLabel(name);
				label.setFont(new Font("Tahoma", Font.BOLD, 18));
				label.setBounds(175, 210, 161, 29);
				frame.getContentPane().add(label);
				
				JLabel lblGender = new JLabel("GENDER :");
				lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblGender.setBounds(67, 265, 98, 29);
				frame.getContentPane().add(lblGender);
				
				 label_1 = new JLabel(gender);
				label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_1.setBounds(179, 265, 145, 29);
				frame.getContentPane().add(label_1);
				
				JLabel lblPhoneNo = new JLabel("PHONE NO : ");
				lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblPhoneNo.setBounds(45, 319, 134, 29);
				frame.getContentPane().add(lblPhoneNo);
				
				 label_2 = new JLabel(mob);
				label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_2.setBounds(180, 319, 182, 29);
				frame.getContentPane().add(label_2);
				
				JLabel lblEmail = new JLabel("EMAIL :");
				lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblEmail.setBounds(88, 373, 91, 29);
				frame.getContentPane().add(lblEmail);
				
				 label_3 = new JLabel(email);
				label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_3.setBounds(179, 373, 251, 29);
				frame.getContentPane().add(label_3);
				
				JLabel lblAddress = new JLabel("ADDRESS :");
				lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblAddress.setBounds(55, 427, 124, 29);
				frame.getContentPane().add(lblAddress);
				
				 label_4 = new JLabel(address);
				label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_4.setBounds(179, 427, 251, 29);
				frame.getContentPane().add(label_4);
				
				JLabel lbltrainerId = new JLabel("TRAINER_ID :");
				lbltrainerId.setFont(new Font("Tahoma", Font.BOLD, 20));
				lbltrainerId.setBounds(23, 490, 152, 36);
				frame.getContentPane().add(lbltrainerId);
				
				 label_5 = new JLabel(trainer_id);
				label_5.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_5.setBounds(176, 497, 124, 29);
				frame.getContentPane().add(label_5);
				
				JLabel lblpackage = new JLabel("PACKAGE :");
				lblpackage.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblpackage.setBounds(55, 554, 124, 23);
				frame.getContentPane().add(lblpackage);
				
				 label_6 = new JLabel(package_name);
				label_6.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_6.setBounds(179, 554, 121, 24);
				frame.getContentPane().add(label_6);
				
				JLabel lbltotcost = new JLabel("TOTAL_COST :");
				lbltotcost.setFont(new Font("Tahoma", Font.BOLD, 20));
				lbltotcost.setBounds(458, 454, 145, 24);
				frame.getContentPane().add(lbltotcost);
				
				 label_7 = new JLabel(total_cost);
				label_7.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_7.setBounds(613, 454, 145, 23);
				frame.getContentPane().add(label_7);
				
				JLabel lblcusid = new JLabel("CUSTOMER ID :");
				lblcusid.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblcusid.setBounds(444, 210, 159, 29);
				frame.getContentPane().add(lblcusid);
				
				 label_8 = new JLabel(cust_id);
				 label_8.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_8.setBounds(613, 210, 152, 29);
				frame.getContentPane().add(label_8);
				
				
				
				JLabel lblAge = new JLabel("AGE :");
				lblAge.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblAge.setBounds(545, 275, 67, 29);
				frame.getContentPane().add(lblAge);
				
			    label_9 = new JLabel(age);
				label_9.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_9.setBounds(606, 275, 152, 29);
				frame.getContentPane().add(label_9);
				
				JLabel lblTrainerName = new JLabel("TRAINER NAME :");
				lblTrainerName.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTrainerName.setBounds(431, 337, 172, 25);
				frame.getContentPane().add(lblTrainerName);
				
			    label_10 = new JLabel(trainer_name);
				label_10.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_10.setBounds(613, 333, 152, 29);
				frame.getContentPane().add(label_10);
				
				JLabel lblBillNo = new JLabel("BILL NO :");
				lblBillNo.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblBillNo.setBounds(505, 396, 98, 29);
				frame.getContentPane().add(lblBillNo);
				
			    label_11 = new JLabel(bill_no);
				label_11.setFont(new Font("Tahoma", Font.BOLD, 18));
				label_11.setBounds(613, 396, 152, 29);
				frame.getContentPane().add(label_11);
                      
				
			/*	JButton btnPaymentDetails = new JButton("Payment Details");
				btnPaymentDetails.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						z=0;
						frame.dispose();
						ViewBillForm.main(new String[] {});
					}
				});   
				btnPaymentDetails.setBounds(221, 629, 135, 36);
				frame.getContentPane().add(btnPaymentDetails);  */
				
				z++;
				frame.repaint();  
				
				
				

			}
		});
		btnDelete.setBounds(431, 127, 89, 29);
		frame.getContentPane().add(btnDelete);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z=0;
				frame.dispose();
				entity.main(new String[] {});
				
			}
		});
		btnBack.setBounds(396, 629, 77, 36);
		frame.getContentPane().add(btnBack);
		
		
		
	
	
		
		
	}
	private void loadData() {
	//	ArrayList<String> namesList = new ArrayList<String>();
		//ResultSet rsone;
		try {
			connection = DB.getConnection();
			statement = connection.createStatement();
			ResultSet rsone1 = statement
					.executeQuery("select COUNT(*) from customer");

			int rowCount = 0;
			while (rsone1.next()) {
				rowCount = rsone1.getInt(1);
			}

			ResultSet rstwo = statement
					.executeQuery("select * from customer");

			if (rowCount == 0)
				JOptionPane.showMessageDialog(null, "No Results to Display");
			else {
				System.out.println("Result set Size is :" + rowCount);
				for (int i = 0; i < rowCount; i++) {
					if (rstwo.next()) {
						comboBox.addItem(rstwo.getString(1));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	private void loadData1() {
		//	ArrayList<String> namesList = new ArrayList<String>();
			//ResultSet rsone;
			try {
				connection = DB.getConnection();
				statement = connection.createStatement();
				
				final StringBuilder q = new StringBuilder();
				final StringBuilder q1 = new StringBuilder();
				
				q.append("select COUNT(*) from customer where cust_id='").append(comboBox.getItemAt(comboBox.getSelectedIndex())).append("'") ;
				ResultSet rsone1 = statement
						.executeQuery(q.toString());

				int rowCount = 0;
				while (rsone1.next()) {
					rowCount = rsone1.getInt(1);
				}
				q1.append("select * from customer c,trainer t,bill b where c.trainer_id=t.trainer_id and c.cust_id=b.cust_id and c.cust_id='").append(comboBox.getItemAt(comboBox.getSelectedIndex())).append("'") ;
				ResultSet rstwo = statement
						.executeQuery(q1.toString());

				if (rowCount == 0)
					JOptionPane.showMessageDialog(null, "No Results to Display");
				else {
					System.out.println("Result set Size is :" + rowCount);
					for (int i = 0; i < rowCount; i++) {
						if (rstwo.next()) {
							name=rstwo.getString(2);
							mob=rstwo.getString(4);
							email=rstwo.getString(7);
							address=rstwo.getString(6);
							gender=rstwo.getString(5);
							trainer_id=rstwo.getString(8);
							trainer_name=rstwo.getString(12);
							bill_no=rstwo.getString(15);
							age=rstwo.getString(3);
							total_cost=rstwo.getString(10);
							package_name=rstwo.getString(9);
							cust_id=comboBox.getItemAt(comboBox.getSelectedIndex());
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
