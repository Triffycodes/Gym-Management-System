package adhi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeleteCustomer extends JFrame {
	static DeleteCustomer frame;
	private Connection connection;
	protected Statement statement;
	private JComboBox<String> nameCB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frame = new DeleteCustomer();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public DeleteCustomer() {

		nameCB = new JComboBox<String>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1380, 750);
		getContentPane().setLayout(new GridLayout(2, 1));
		setResizable(false);

		loadData();

		JButton btndeleteData = new JButton("Delete");
		btndeleteData.setSize(new Dimension(10, 10));
		btndeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				StringBuilder query = new StringBuilder();
				String CUST_ID  = nameCB.getItemAt(nameCB.getSelectedIndex());

				if (CUST_ID  == null || CUST_ID .trim().length() == 0) {
					JOptionPane.showMessageDialog(null,
							"Please Select the Field");
					System.out.println("Text:" +CUST_ID );
				} else {
					query.append("delete from customer where CUST_ID =('")
							.append(CUST_ID.trim()).append("')");
					try {
						System.out.println("Query:" + query.toString());
						connection = DB.getConnection();
						statement = connection.createStatement();
						
						//statement= DB.getConnection();

						ResultSet rs = statement.executeQuery(query.toString());
						System.out.println("Deleted Successfully");
						JOptionPane.showMessageDialog(null,
								"Data Deleted Successfully");
						nameCB.removeAllItems();
						loadData();
						connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				entity.main(new String[] {});
			}
		});

		// names.setSelectedIndex(0);
		JScrollPane ScrollPane = new JScrollPane(nameCB);

		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(40);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel.add(ScrollPane);
		controlPanel.add(btndeleteData);
		controlPanel.add(btnBack);

		JLabel studentDBManagement = new JLabel("DELETE CUSTOMER DETAILS",
				JLabel.CENTER);
		studentDBManagement.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		studentDBManagement.setForeground(Color.BLACK);

		getContentPane().add(studentDBManagement);
		getContentPane().add(controlPanel);
	}
	
	private void loadData() {
		ArrayList<String> namesList = new ArrayList<String>();
		ResultSet rsone;
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


