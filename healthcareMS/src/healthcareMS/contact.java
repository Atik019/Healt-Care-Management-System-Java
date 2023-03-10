package healthcareMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class contact extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contact frame = new contact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public contact() {
		setTitle("Health Care Management System");
		setResizable(false);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java\\healthcareMS\\src\\image\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 555);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Health Care Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Papyrus", Font.BOLD, 31));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(80, 35, 714, 147);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\java\\healthcareMS\\src\\image\\sign.png"));
		lblNewLabel_1.setBounds(380, 163, 70, 70);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(14, 29, 39));
		panel.setBounds(208, 269, 446, 220);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrFor = new JTextArea();
		txtrFor.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtrFor.setForeground(new Color(255, 255, 255));
		txtrFor.setBackground(new Color(14, 29, 39));
		txtrFor.setEditable(false);
		txtrFor.setText("For Any Kind Of Information or \r\nChange the profile information \r\nContact us by sending email.");
		txtrFor.setBounds(42, 10, 370, 105);
		panel.add(txtrFor);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email:  Atikshariar250@gmail.com");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(90, 114, 274, 34);
		panel.add(lblNewLabel_2_2);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage frame = new homePage();
				frame.setVisible(true);
				dispose();
				
				
			}
		});
		btnHome.setForeground(new Color(0, 0, 102));
		btnHome.setFont(new Font("SimSun", Font.BOLD, 22));
		btnHome.setBackground(SystemColor.menu);
		btnHome.setBounds(158, 158, 108, 36);
		panel.add(btnHome);
		
		JLabel lblNewLabel_2 = new JLabel(" Atikshariar250@gmail.com");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 484, 185, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" ??2023");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2_1.setBounds(10, 484, 185, 11);
		contentPane.add(lblNewLabel_2_1);
	}
}
