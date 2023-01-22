package healthcareMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import java.sql.*;


public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField txName;
	private JPasswordField passwordField2;
	private JTextField txUsername;
	private JTextField txEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Welcome To Health Care Management System");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Papyrus", Font.BOLD, 31));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(57, 10, 714, 114);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Papyrus", Font.BOLD, 26));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(363, 186, 118, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\java\\healthcareMS\\src\\image\\sign.png"));
		lblNewLabel_1.setBounds(378, 104, 70, 70);
		contentPane.add(lblNewLabel_1);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(14, 29, 39));
		panel.setBounds(83, 237, 670, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("User Name ");
		lblUsername.setForeground(new Color(220, 20, 60));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(10, 136, 168, 42);
		panel.add(lblUsername);
		
		JLabel lblpassword = new JLabel("Password ");
		lblpassword.setForeground(new Color(220, 20, 60));
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblpassword.setBounds(10, 188, 168, 42);
		panel.add(lblpassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBackground(new Color(11, 22, 30));
		lblName.setForeground(new Color(220, 20, 60));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(10, 12, 168, 42);
		panel.add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(220, 20, 60));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(10, 71, 168, 42);
		panel.add(lblEmail);
		
		txName = new JTextField();
		txName.setFont(new Font("Tahoma", Font.BOLD, 20));
		txName.setColumns(10);
		txName.setBounds(134, 16, 297, 36);
		panel.add(txName);
		
		JButton btnSubmit = new JButton("Sign Up");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txName.getText();
				String email = txEmail.getText();
				String uname = txUsername.getText();
				String pass = new String(passwordField2.getPassword());
				String role = "user";
				
			
				
				if(!name.equals("") && !email.equals("") && !uname.equals("") && !pass.equals("")) {
					
					
					System.out.println(name);
					System.out.println(email);
					System.out.println(uname);
					System.out.println(pass);
					
					
					//connecting to database 
					try {
			            Class.forName("com.mysql.jdbc.Driver");
			            Connection conn = null;
			            conn = DriverManager.getConnection("jdbc:mysql://localhost/healthcare","root", "");
			            System.out.println("Database is connected !");
			            
			            PreparedStatement  insert = conn.prepareStatement("insert into user_info(name,email,username,password,role)values(?,?,?,?,?)");
			            insert.setString(1, name);
			            insert.setString(2, email);
			            insert.setString(3, uname);
			            insert.setString(4, pass);
			            insert.setString(5, role);
			            insert.executeUpdate();
			            
			            conn.close();
			            
			            
			            
			            txName.setText("");
						txEmail.setText("");
						txUsername.setText("");
						passwordField2.setText("");
						
			            JFrame f=new JFrame();  
						JOptionPane.showMessageDialog(f,"Registration completed successfuly");
			              
			            
			        }
			        catch(Exception e1) {
			            System.out.print("Do not connect to DB - Error:"+e1);
			        }
					
					
					
						
				}
				else {
					JFrame f=new JFrame();  
					JOptionPane.showMessageDialog(f,"Please fill up all fields with valid information");
					
					txName.setText("");
					txEmail.setText("");
					txUsername.setText("");
					passwordField2.setText("");
				}
								
			}
		});
		btnSubmit.setForeground(new Color(0, 0, 102));
		btnSubmit.setFont(new Font("SimSun", Font.BOLD, 22));
		btnSubmit.setBackground(UIManager.getColor("Button.background"));
		btnSubmit.setBounds(516, 77, 120, 36);
		panel.add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txName.setText("");
				txEmail.setText("");
				txUsername.setText("");
				passwordField2.setText("");
			}
		});
		
		btnClear.setForeground(new Color(0, 0, 102));
		btnClear.setFont(new Font("SimSun", Font.BOLD, 22));
		btnClear.setBackground(UIManager.getColor("Button.darkShadow"));
		btnClear.setBounds(528, 139, 108, 36);
		panel.add(btnClear);
		
		passwordField2 = new JPasswordField();
		passwordField2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField2.setBounds(134, 194, 297, 36);
		panel.add(passwordField2);
		
		txUsername = new JTextField();
		txUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		txUsername.setColumns(10);
		txUsername.setBounds(134, 137, 297, 36);
		panel.add(txUsername);
		
		txEmail = new JTextField();
		txEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		txEmail.setColumns(10);
		txEmail.setBounds(134, 77, 297, 36);
		panel.add(txEmail);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homePage frame = new homePage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(0, 0, 102));
		btnBack.setFont(new Font("SimSun", Font.BOLD, 22));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(528, 191, 108, 36);
		panel.add(btnBack);
		
		JLabel lblNewLabel_2_3 = new JLabel(" Atikshariar250@gmail.com");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setBounds(10, 484, 185, 34);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1 = new JLabel(" ©2023");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2_1.setBounds(10, 484, 185, 11);
		contentPane.add(lblNewLabel_2_1);
		
		
	}

}
