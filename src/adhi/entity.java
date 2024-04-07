package adhi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.List;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;

public class entity {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entity window = new entity();
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
	public entity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(-7,-5,1380,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setSize(83, 35);
		addPopup(frame.getContentPane(), popupMenu);
		
		JButton btnBack = new JButton("LOGOUT");
		btnBack.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				welcome.main(new String[] {});
			}
		});
		popupMenu.add(btnBack);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBounds(0, 139, 1354, 21);
		frame.getContentPane().add(menuBar);
		menuBar.setFont(new Font("Segoe UI Black", Font.BOLD, 19));
		
		
		
		JMenu mnCustomer = new JMenu("CUSTOMER      ");
		mnCustomer.setBackground(Color.YELLOW);
		mnCustomer.setFont(new Font("Segoe Script", Font.BOLD, 17));
		menuBar.add(mnCustomer);
		
		JMenuItem mntmAddCustomer = new JMenuItem("ADD CUSTOMER");
		mntmAddCustomer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmAddCustomer.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/333.png")));
		mnCustomer.add(mntmAddCustomer);
		mntmAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addcustom.main(new String[]{});
			}
			});
		
		JMenuItem mntmDeleteCustomer = new JMenuItem("DELETE CUSTOMER");
		mntmDeleteCustomer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmDeleteCustomer.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/user_delete.png")));
		mnCustomer.add(mntmDeleteCustomer);
		mntmDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteCustomer.main(new String[]{});
			}
			});
		
		
		
		JMenuItem mntmViewCustomer = new JMenuItem("VIEW CUSTOMER");
		mntmViewCustomer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmViewCustomer.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/tests-icon11111.png")));
		mnCustomer.add(mntmViewCustomer);
		mntmViewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCustomerForm.main(new String[]{});
			}
			});
		
		
		
		JMenu mnTrainer = new JMenu("TRAINER      ");
		mnTrainer.setFont(new Font("Segoe Script", Font.BOLD, 17));
		menuBar.add(mnTrainer);
		
		JMenuItem mntmAddTrainer = new JMenuItem("ADD TRAINER");
		mntmAddTrainer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmAddTrainer.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/adduser.png")));
		mnTrainer.add(mntmAddTrainer);
		mntmAddTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddTrainerForm.main(new String[]{});
			}
			});
		
		JMenuItem mntmDeleteTrainer = new JMenuItem("DELETE TRAINER");
		mntmDeleteTrainer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmDeleteTrainer.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/444.png")));
		mnTrainer.add(mntmDeleteTrainer);
		mntmDeleteTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DS.main(new String[]{});
			}
			});
		
		
		JMenuItem mntmViewTrainer = new JMenuItem("VIEW TRAINER");
		mntmViewTrainer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmViewTrainer.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/tests-icon11111.png")));
		mnTrainer.add(mntmViewTrainer);
		mntmViewTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewTrainer.main(new String[]{});
			}
			});
		
		JMenu mnEquipment = new JMenu("EQUIPMENT      ");
		mnEquipment.setFont(new Font("Segoe Script", Font.BOLD, 17));
		menuBar.add(mnEquipment);
		
		JMenuItem mntmAddEquipment = new JMenuItem("ADD EQUIPMENT");
		mntmAddEquipment.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmAddEquipment.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/111.png")));
		mnEquipment.add(mntmAddEquipment);
		mntmAddEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddEquipmentForm.main(new String[]{});
			}
			});
		
		JMenuItem mntmDeleteEquipment = new JMenuItem("DELETE EQUIPMENT");
		mntmDeleteEquipment.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmDeleteEquipment.setIcon(new ImageIcon(entity.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		mnEquipment.add(mntmDeleteEquipment);
		mntmDeleteEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteEquipment.main(new String[]{});
			}
			});
		
		
		JMenuItem mntmViewEquipment = new JMenuItem("VIEW EQUIPMENT");
		mntmViewEquipment.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmViewEquipment.setIcon(new ImageIcon(entity.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Indent@2x.png")));
		mnEquipment.add(mntmViewEquipment);
		mntmViewEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewEquipmentForm.main(new String[]{});
			}
			});
		
		
		JMenu mnMembership = new JMenu("MEMBERSHIP      ");
		mnMembership.setFont(new Font("Segoe Script", Font.BOLD, 17));
		menuBar.add(mnMembership);
		
		JMenuItem mntmAddMembership = new JMenuItem("ADD MEMBERSHIP");
		mntmAddMembership.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmAddMembership.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/333.png")));
		mnMembership.add(mntmAddMembership);
		mntmAddMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddMembershipForm.main(new String[]{});
			}
			});
		
		JMenuItem mntmDeleteMembership = new JMenuItem("DELETE MEMBERSHIP");
		mntmDeleteMembership.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmDeleteMembership.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/456.png")));
		mnMembership.add(mntmDeleteMembership);
		
		mntmDeleteMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteMembership.main(new String[]{});
			}
			});
		
		JMenuItem mntmViewMembership = new JMenuItem("VIEW MEMBERSHIP");
		mntmViewMembership.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmViewMembership.setIcon(new ImageIcon(entity.class.getResource("/com/sun/javafx/scene/web/skin/OrderedListNumbers_16x16_JFX.png")));
		mnMembership.add(mntmViewMembership);
		
		mntmViewMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewMembership.main(new String[]{});
			}
			});
		
		JMenu mnBill = new JMenu("BILL    ");
		mnBill.setFont(new Font("Segoe Script", Font.BOLD, 17));
		menuBar.add(mnBill);
		
		JMenuItem mntmAddBill = new JMenuItem("ADD BILL");
		mntmAddBill.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmAddBill.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/tests-icon11111.png")));
		mnBill.add(mntmAddBill);
		mntmAddBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBillForm.main(new String[]{});
			}
			});
		
		JMenuItem mntmDeleteBill = new JMenuItem("DELETE BILL");
		mntmDeleteBill.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmDeleteBill.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/roll_delete-5121.png")));
		mnBill.add(mntmDeleteBill);
		mntmDeleteBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteBill.main(new String[]{});
			}
			});
		
		
		JMenuItem mntmViewBill = new JMenuItem("VIEW BILL");
		mntmViewBill.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mntmViewBill.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/gg.png")));
		mnBill.add(mntmViewBill);
		
		
		
		mntmViewBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBillForm.main(new String[]{});
			}
			});
		
		
		JMenu mnAbout = new JMenu("ABOUT ");
		mnAbout.setFont(new Font("Segoe Script", Font.BOLD, 17));
		menuBar.add(mnAbout);
		
		JMenuItem mntmErDiagram = new JMenuItem("ER DIAGRAM");
		mntmErDiagram.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mnAbout.add(mntmErDiagram);
		mntmErDiagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ERdiagram.main(new String[]{});
			}
			});
		
		JMenuItem mntmSchema = new JMenuItem("SCHEMA ");
		mntmSchema.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mnAbout.add(mntmSchema);
		mntmSchema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				schema.main(new String[]{});
			}
			});
		
		JMenuItem mntmSearch = new JMenuItem("SEARCH");
		mntmSearch.setFont(new Font("Segoe Script", Font.BOLD, 17));
		menuBar.add(mntmSearch);
		
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search1.main(new String[]{});
			}
			});
		
		
		JLabel lblImPossible = new JLabel("TRAIN HARD'ER");
		lblImPossible.setForeground(Color.WHITE);
		lblImPossible.setFont(new Font("Stencil", Font.BOLD, 86));
		lblImPossible.setBounds(339, 11, 746, 117);
		frame.getContentPane().add(lblImPossible);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(entity.class.getResource("/adhi/img/666.jpg")));
		label.setBounds(0, 139, 1362, 572);
		frame.getContentPane().add(label);
		frame.getCursor();
		


}	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}