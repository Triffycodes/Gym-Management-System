package adhi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class wel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wel window = new wel();
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
	public wel() {
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
		
		JLabel lblWelcomeToThe = new JLabel("         WELCOME TO ");
		lblWelcomeToThe.setForeground(Color.YELLOW);
		lblWelcomeToThe.setFont(new Font("Mistral", Font.BOLD, 93));
		lblWelcomeToThe.setBackground(Color.BLACK);
		lblWelcomeToThe.setBounds(-13, 398, 1123, 121);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblGymManagementSystem = new JLabel("GYM MANAGEMENT SYSTEM");
		lblGymManagementSystem.setForeground(Color.YELLOW);
		lblGymManagementSystem.setFont(new Font("Mistral", Font.BOLD, 93));
		lblGymManagementSystem.setBounds(30, 493, 1179, 145);
		frame.getContentPane().add(lblGymManagementSystem);
		
		JButton btnClickHereTo =new JButton("CLICK HERE TO LOGIN");
		btnClickHereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//frame.dispose();
				welcome.main(new String[]{});
			}
		});
		btnClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnClickHereTo.setBounds(288, 649, 256, 37);
		frame.getContentPane().add(btnClickHereTo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(wel.class.getResource("/adhi/img/Gym-Wallpaper-35E-11111111111.jpg")));
		label.setBounds(0, 0, 1380, 750);
		frame.getContentPane().add(label);
		
	}

}
