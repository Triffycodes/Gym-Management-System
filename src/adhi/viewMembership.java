package adhi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class viewMembership {

	private JFrame frame;
	private JTable table;
	private Connection connection;
	protected Statement statement;
	private JLabel lblMembershipDetails;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewMembership window = new viewMembership();
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
	public viewMembership() {
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
		
		
		
		
		
		Object[][] data = new Object[100][6];
		String[] columns = new String[] { "CUSTOMER_ID", "DATE_CREATED", "PACKAGE_NAME","EXPIRY_DATE","TOTAL_COST","TRAINER_ID" };
		
		int rowCount=0;
		
		try {
			connection = DB.getConnection();
			statement = connection.createStatement();

			ResultSet rsone = statement
					.executeQuery("select COUNT(*) from membership");
			while (rsone.next()) {
				rowCount = rsone.getInt(1);
			}

			ResultSet rstwo = statement
					.executeQuery("select * from membership");
			ResultSetMetaData meta = rstwo.getMetaData();
			int colCount = meta.getColumnCount();

			if (rowCount == 0)
				JOptionPane.showMessageDialog(null, "No Results to Display");
			else {
				System.out
						.println("Result set Size is :" + rowCount + "Column Count:" +colCount);
				for (int i = 0; i < rowCount; i++) {
					int k = 1;
					if (rstwo.next()) {
						for (int j = 0; j < colCount; j++) {
							data[i][j] = rstwo.getString(k++);
						}
					}
				}
			}
			connection.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		table = new JTable(data,columns);
		table.setBounds(10, 100,1340, 400);
		//frame.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100,1340, 400);
		frame.getContentPane().add(scrollPane);
	
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				entity.main(new String[] {});
			}
		});
		btnBack.setBounds(517, 584, 89, 23);
		frame.getContentPane().add(btnBack);
		
		lblMembershipDetails = new JLabel("MEMBERSHIP DETAILS");
		lblMembershipDetails.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		lblMembershipDetails.setBounds(449, 26, 496, 38);
		frame.getContentPane().add(lblMembershipDetails);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(viewMembership.class.getResource("/adhi/img/55-10.png")));
		label_1.setBounds(428, 11, 525, 60);
		frame.getContentPane().add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(viewMembership.class.getResource("/adhi/img/11-1.jpg")));
		label.setBounds(0, 0, 1362, 711);
		frame.getContentPane().add(label);
	}
}