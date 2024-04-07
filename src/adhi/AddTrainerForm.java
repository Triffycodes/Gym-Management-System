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
//import java.awt.Choice;
import javax.swing.ImageIcon;

public class AddTrainerForm {

	private JFrame frame;
	private JTextField textField_2;
	private Connection connection;
	protected Statement statement;
//	public static JTextField textField;
	public static String aa;
	public static String tn;
	public static String pt;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTrainerForm window = new AddTrainerForm();
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
	public AddTrainerForm() {
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
		
		JLabel lblTrainerInformation = new JLabel("TRAINER INFORMATION");
		lblTrainerInformation.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		lblTrainerInformation.setBounds(390, 21, 567, 40);
		frame.getContentPane().add(lblTrainerInformation);
		
		JLabel lblTrainerid = new JLabel("TRAINER ID:");
		lblTrainerid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrainerid.setBounds(390, 163, 119, 23);
		frame.getContentPane().add(lblTrainerid);
		
		JLabel lblTrainername = new JLabel("TRAINER NAME:");
		lblTrainername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrainername.setBounds(520, 246, 137, 14);
		frame.getContentPane().add(lblTrainername);
		
		JLabel lblSalary = new JLabel("SALARY:");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalary.setBounds(738, 354, 86, 14);
		frame.getContentPane().add(lblSalary);
		
		textField_2 = new JTextField();
		textField_2.setBounds(849, 350, 157, 27);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final StringBuilder query = new StringBuilder();
				
				
				//entity.main(new String[] {});
				System.out.println("Connecting to DATABASE");
				String trainer_id = textField_4.getText();
				String trainer_name =textField_3.getText();
				String salary = textField_2.getText();
				String total_c=textField_1.getText();
				
				if (trainer_id==null || trainer_id.trim().length()==0||trainer_name == null || trainer_name.trim().length() == 0 
						|| salary==null ||salary.trim().length()==0 || total_c==null ||total_c.trim().length()==0) {
					
					JOptionPane.showMessageDialog(null,
							"Please Enter all the Fields");
				
				} else {
					query.append(
							"insert into trainer values(").append("'")
							.append(trainer_id.trim()).append("','")
							.append(trainer_name.trim()).append("','")
							.append(salary.trim()).append("','")
							
							.append(total_c.trim()).append("')");
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
					
					
					
				//	textField_2.setText(null);
				

				} 
			}
			
		}); 
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(486, 552, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				entity.main(new String[] {});
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(840, 552, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				entity.main(new String[] {});
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNext.setBounds(655, 552, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AddTrainerForm.class.getResource("/adhi/img/55-6.png")));
		label_1.setBounds(373, 11, 601, 62);
		frame.getContentPane().add(label_1);
		
		JLabel lblTotalTrainers = new JLabel("TOTAL CUSTOMERS:");
		lblTotalTrainers.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalTrainers.setBounds(814, 446, 153, 23);
		frame.getContentPane().add(lblTotalTrainers);
		
		textField_1 = new JTextField("0");
		textField_1.setColumns(10);
		textField_1.setBounds(994, 446, 157, 27);
		frame.getContentPane().add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(679, 242, 157, 27);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(519, 163, 157, 27);
		frame.getContentPane().add(textField_4);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddTrainerForm.class.getResource("/adhi/img/55-9.jpg")));
		label.setBounds(0, 0, 1362, 711);
		frame.getContentPane().add(label);
	}
}
