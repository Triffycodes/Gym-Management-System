package adhi;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.GridLayout;
import java.awt.FlowLayout; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ViewCustomerForm {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private Connection connection;                                                                                               
	protected Statement statement;   
	private JLabel lblCustomerDetails;
	private JButton button;
	private JLabel label;
	private JLabel label_1;

	
//	  Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCustomerForm window = new ViewCustomerForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//  Create the application.
	 
	public ViewCustomerForm() {
		initialize();
	}

	
//	  Initialize the contents of the frame.
	 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		int rowCount=0;
		
		Object[][] data = new Object[100][10];                                                                                     
		// headers for the table                                                                                                 
		String[] columns = new String[] { "Customer_Id", "Customer Name"," Age", "Mobile","Gender","Address","E-mail","Trainer ID","package name","total_cost"};                                                        
                                                                                                                                 
		try {                                                                                                                    
			connection = DB.getConnection();                                                                                     
			statement = connection.createStatement();                                                                            
                                                                                                                                 
			ResultSet rsone = statement                                                                                          
					.executeQuery("select COUNT(*) from customer");                                                            
			while (rsone.next()) {                                                                                               
				rowCount = rsone.getInt(1);                                                                                      
			}                                                                                                                    
                                                                                                                                 
			ResultSet rstwo = statement                                                                                          
					.executeQuery("select * from customer");                                                                   
			ResultSetMetaData meta = rstwo.getMetaData();                                                                        
			int colCount = meta.getColumnCount();                                                                                
                                                                                                                                 
			if (rowCount == 0)                                                                                                   
				JOptionPane.showMessageDialog(null," No Results to Display");                                                    
			else {                                                                                                               
				System.out                                                                                                       
						.println("Result set Size is " + rowCount + "Column Count "+colCount);                                 
				for (int i = 0; i <rowCount; i++) {                                                                             
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
		frame.getContentPane().add(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100,1340, 400);
		frame.getContentPane().add(scrollPane);
		
		lblCustomerDetails = new JLabel("CUSTOMER DETAILS");
		lblCustomerDetails.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblCustomerDetails.setBounds(514, 31, 331, 26);
		frame.getContentPane().add(lblCustomerDetails);
		
		button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				entity.main(new String[] {});
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(10, 562, 89, 23);
		frame.getContentPane().add(button);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ViewCustomerForm.class.getResource("/adhi/img/55-10.png")));
		label_1.setBounds(486, 11, 359, 56);
		frame.getContentPane().add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ViewCustomerForm.class.getResource("/adhi/img/11-1.jpg")));
		label.setBounds(0, 0, 1362, 711);
		frame.getContentPane().add(label);
		
	                                                                                                       
		
        

		
	
	}
}
