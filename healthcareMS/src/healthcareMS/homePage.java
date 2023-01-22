package healthcareMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class homePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage frame = new homePage();
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
	public homePage() {
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
		panel.setBounds(294, 267, 244, 220);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(SystemColor.scrollbar);
		btnLogin.setForeground(new Color(0, 102, 153));
		btnLogin.setFont(new Font("SimSun", Font.BOLD, 25));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login frame1 = new login();
				frame1.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(40, 26, 172, 42);
		panel.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				signup frame2 = new signup();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnSignUp.setForeground(new Color(0, 102, 153));
		btnSignUp.setFont(new Font("SimSun", Font.BOLD, 25));
		btnSignUp.setBackground(SystemColor.scrollbar);
		btnSignUp.setBounds(40, 92, 172, 42);
		panel.add(btnSignUp);
		
		JButton btnContactUs = new JButton("Contact Us");
		btnContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contact frame = new contact();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnContactUs.setForeground(new Color(0, 102, 153));
		btnContactUs.setFont(new Font("SimSun", Font.BOLD, 25));
		btnContactUs.setBackground(SystemColor.scrollbar);
		btnContactUs.setBounds(40, 157, 172, 42);
		panel.add(btnContactUs);
		
		JLabel lblNewLabel_2 = new JLabel(" Atikshariar250@gmail.com");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 484, 185, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" ©2023");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2_1.setBounds(10, 484, 185, 11);
		contentPane.add(lblNewLabel_2_1);
	}
}
