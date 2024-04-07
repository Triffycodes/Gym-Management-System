package adhi;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ViewEquipmentForm {

	private JFrame frame;
	private JTable table;
	private Connection connection;                                                                                               
	protected Statement statement; 
	private JLabel lblEquipmentDetails;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEquipmentForm window = new ViewEquipmentForm();
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
	public ViewEquipmentForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0,0,1380,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		int rowCount = 0;
		
		Object[][] data = new Object[200][4];                                                                                     
		// headers for the table                                                                                                 
		String[] columns = new String[] { "Customer ID", "Equipment No.","Equipment Name", "Condition"}; 
		
		try {                                                                                                                    
			connection = DB.getConnection();                                                                                     
			statement = connection.createStatement();                                                                            
                                                                                                                                 
			ResultSet rsone = statement                                                                                          
					.executeQuery("select COUNT(*) from equipment");                                                            
			while (rsone.next()) {                                                                                               
				rowCount = rsone.getInt(1);                                                                                      
			}                                                                                                                    
                                                                                                                                 
			ResultSet rstwo = statement                                                                                          
					.executeQuery("select * from equipment");                                                                   
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
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBounds(10, 100,1340, 400);
		frame.getContentPane().add(scrollPane);
		
		lblEquipmentDetails = new JLabel("EQUIPMENT DETAILS");
		lblEquipmentDetails.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblEquipmentDetails.setBounds(522, 24, 336, 26);
		frame.getContentPane().add(lblEquipmentDetails);
		
		JButton button = new JButton("<<BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				entity.main(new String[] {});
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(10, 569, 89, 23);
		frame.getContentPane().add(button);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ViewEquipmentForm.class.getResource("/adhi/img/55-10.png")));
		label_1.setBounds(503, 11, 364, 48);
		frame.getContentPane().add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ViewEquipmentForm.class.getResource("/adhi/img/11-1.jpg")));
		label.setBounds(0, 0, 1362, 711);
		frame.getContentPane().add(label);
	}
}
