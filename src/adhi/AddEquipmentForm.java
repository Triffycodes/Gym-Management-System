package adhi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.ImageIcon;

public class AddEquipmentForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Connection connection;
	protected Statement statement;
	public static String a;
	public static String e;
	public static String p;
	Choice choice = new Choice();
	Choice choice_1 = new Choice();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEquipmentForm window = new AddEquipmentForm();
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
	public AddEquipmentForm() {
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
		
		JLabel lblEquipmentDetails = new JLabel("EQUIPMENT DETAILS");
		lblEquipmentDetails.setBounds(486, 60, 466, 41);
		lblEquipmentDetails.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		frame.getContentPane().add(lblEquipmentDetails);
		
		JLabel lblCustid = new JLabel("CUSTOMER ID :");
		lblCustid.setBounds(129, 178, 147, 14);
		lblCustid.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCustid.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblCustid);
		
		JLabel lblEquipmentN = new JLabel("EQUIPMENT NO. :");
		lblEquipmentN.setBounds(926, 178, 147, 14);
		lblEquipmentN.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEquipmentN.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblEquipmentN);
		
		JLabel lblEquipmentType = new JLabel("EQUIPMENT TYPE :");
		lblEquipmentType.setBounds(265, 279, 147, 18);
		lblEquipmentType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEquipmentType.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblEquipmentType);
		
		textField = new JTextField(AddMembershipForm.textField.getText());
		textField.setBounds(304, 174, 157, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(527, 449, 89, 23);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
final StringBuilder query = new StringBuilder();
				
				
				System.out.println("Connecting to DATABASE");
				String cust_id = textField.getText();
				String equipment_no = choice.getSelectedItem();
				String equipment_type = textField_1.getText();
				String condition =  choice_1.getSelectedItem();
				
				if (cust_id==null ||cust_id.trim().length()==0||equipment_no == null || equipment_no.trim().length() == 0 
						|| equipment_type==null ||equipment_type.trim().length()==0) {
					
					JOptionPane.showMessageDialog(null,
							"Please Enter all the Fields");
					
				/*} else if (phone.trim().length() != 10
						) {
					
					JOptionPane.showMessageDialog(null,
							"Please Enter Values Correctly");
					*/
				} else {
					query.append(
							"insert into equipment values(").append("'")
							.append(cust_id.trim()).append("','")
							.append(equipment_no.trim()).append("','")
							.append(equipment_type.trim()).append("','")
							.append(condition.trim()).append("')");
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
					textField_2.setText(null);    */
				

				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(890, 449, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				entity.main(new String[] {});
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(btnBack);
		
		JLabel lblCondition = new JLabel("CONDITION :");
		lblCondition.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCondition.setBounds(784, 281, 116, 14);
		frame.getContentPane().add(lblCondition);
		
		
		choice.setBounds(1110, 174, 157, 27);
		choice.add(" select");
		choice.add("1");
		choice.add("2");
		choice.add("3");
		choice.add("4");
		choice.add("5");
		choice.add("6");
		choice.add("7");
		choice.add("8");
		choice.add("9");
		choice.add("10");
		frame.getContentPane().add(choice);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				a=choice.getSelectedItem();
				 p=choice.getSelectedItem();
				if("1".equals(p))
				{
					e="dumbbells";
					
					
				}
				if("2".equals(p))
				{
					e="Bench press";
				}
				if("3".equals(p))
				{
					e="elliptical";
				}
				if("4".equals(p))
				{
					e="cabels & pulleys";
				}
				if("5".equals(p))
				{
					e="leg curl machine";
				}
				if("6".equals(p))
				{
					e="Hammer Strength Machine";
				}
				if("7".equals(p))
				{
					e=" Leg Press Machine";
				}
				if("8".equals(p))
				{
					e="Squat Rack";
				}
				if("9".equals(p))
				{
					e="PULLUP BAR";
				}
				if("10".equals(p))
				{
					e="LEG EXTENSION MACHINE";
				}
				
				textField_1 = new JTextField(e);
				textField_1.setBounds(460, 277, 157, 27);
				frame.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				
			}
		});
		btnOk.setBounds(1137, 207, 89, 23);
		frame.getContentPane().add(btnOk);
		
		
		choice_1.setBounds(936, 277, 157, 20);
		frame.getContentPane().add(choice_1);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddBillForm.main(new String[] {});
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNext.setBounds(711, 450, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddEquipmentForm.class.getResource("/adhi/img/55-8.png")));
		lblNewLabel.setBounds(459, 47, 520, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddEquipmentForm.class.getResource("/adhi/img/55-7.png")));
		label.setBounds(0, 0, 1362, 711);
		frame.getContentPane().add(label);
		choice_1.add("select");
		choice_1.add("good");
		choice_1.add("bad");
	}
}
