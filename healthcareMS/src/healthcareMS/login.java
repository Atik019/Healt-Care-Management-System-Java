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
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import java.sql.*;





public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txUsername;
	private JPasswordField passwordField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	
	
	
	public static String glUsername;
	public static String glName;
	
	public login() {
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
		
		JLabel lblNewLabel = new JLabel("Enter Valid Username and Password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Papyrus", Font.BOLD, 26));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(197, 228, 462, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\java\\healthcareMS\\src\\image\\sign.png"));
		lblNewLabel_1.setBounds(389, 133, 70, 70);
		contentPane.add(lblNewLabel_1);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(14, 29, 39));
		panel.setBounds(153, 297, 536, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("User Name ");
		lblUsername.setForeground(new Color(220, 20, 60));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(107, 10, 168, 42);
		panel.add(lblUsername);
		
		JLabel lblpassword = new JLabel("Password ");
		lblpassword.setForeground(new Color(220, 20, 60));
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblpassword.setBounds(107, 71, 168, 42);
		panel.add(lblpassword);
		
		txUsername = new JTextField();
		txUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		txUsername.setBounds(253, 18, 227, 36);
		panel.add(txUsername);
		txUsername.setColumns(10);
		
		passwordField1 = new JPasswordField();
		lblpassword.setLabelFor(passwordField1);
		passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField1.setBounds(253, 79, 227, 36);
		panel.add(passwordField1);
		
		
		
		
		
		
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = txUsername.getText();
				String pass = new String(passwordField1.getPassword());
				
				
				String rUsername ="";
				String rPass="";
				String rRole="";
				
				String r2Username ="";
				String r2Pass="";
				
				
				glUsername = txUsername.getText();
				
				//System.out.println("Session:"+glUsername);
				
				
				//connecting to database 
				try {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = null;
		            conn = DriverManager.getConnection("jdbc:mysql://localhost/healthcare","root", "");
		            System.out.println("Database is connected !");
		            
		            
		            Statement stmt = conn.createStatement() ;
		            String query = "select * from user_info where username = '"+uname+"' and password = '"+pass+"' ;" ;
		            ResultSet rs = stmt.executeQuery(query) ;
		            
		            
		            
		            while(rs.next())
		            {
		            	rUsername=rs.getString("username");
		            	rPass=rs.getString("password");
		            	rRole=rs.getString("role");
		            	
//		                System.out.println(glName);
		            }
		            
		            
		            
		            Statement stmt2 = conn.createStatement() ;
		            String sql = "select * from doctor where username = '"+uname+"' and password = '"+pass+"' ;" ;
		            ResultSet rs2 = stmt2.executeQuery(sql) ;
		            
		            while(rs2.next())
		            {
		            	r2Username=rs2.getString("username");
		            	r2Pass=rs2.getString("password");
		            	glName=rs2.getString("name");
		            	
//		                System.out.println(glName);

		            }
		            
		            
		            conn.close();
		        }
		        catch(Exception e1) {
		            System.out.print("Do not connect to DB - Error:"+e1);
		        }
				
				
				if(!uname.equals("") && !pass.equals("") && rUsername.equals(uname) && rPass.equals(pass)) {

					
					
					if(rRole.equals("user")) {
						user frame = new user();
						frame.setVisible(true);
						dispose();
						
						JFrame f=new JFrame();  
						JOptionPane.showMessageDialog(f,"You have successfully logged in.\nWelcome to the user portal.");
					}
					
					if(rRole.equals("admin")) {
						admin frame = new admin();
						frame.setVisible(true);
						dispose();
						
						JFrame f=new JFrame();  
						JOptionPane.showMessageDialog(f,"You have successfully logged in.\nWelcome to the Admin portal.");
					}
					
		
//					System.out.println(r2Username);
//					System.out.println(uname);
//					System.out.println(r2Pass);

				}
				else if(!uname.equals("") && !pass.equals("") && r2Username.equals(uname) && r2Pass.equals(pass)) {
					doctor frame = new doctor();
					frame.setVisible(true);
					dispose();
					
					JFrame f=new JFrame();  
					JOptionPane.showMessageDialog(f,"You have successfully logged in.\nWelcome to the Doctor portal.");
				}
				else {
					JFrame f=new JFrame();  
					JOptionPane.showMessageDialog(f,"Please enter a valid User Name and Password");
					txUsername.setText("");
					passwordField1.setText("");
				}
				
				
			}
		});
		btnLogin.setForeground(new Color(0, 0, 102));
		btnLogin.setFont(new Font("SimSun", Font.BOLD, 22));
		btnLogin.setBackground(UIManager.getColor("Button.background"));
		btnLogin.setBounds(253, 125, 108, 36);
		panel.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txUsername.setText("");
				passwordField1.setText("");
			}
		});
		
		btnClear.setForeground(new Color(0, 0, 102));
		btnClear.setFont(new Font("SimSun", Font.BOLD, 22));
		btnClear.setBackground(UIManager.getColor("Button.background"));
		btnClear.setBounds(372, 125, 108, 36);
		panel.add(btnClear);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome To Health Care Management System");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Papyrus", Font.BOLD, 31));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(57, 23, 714, 114);
		contentPane.add(lblNewLabel_2);
		
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
		btnBack.setBounds(580, 182, 108, 36);
		contentPane.add(btnBack);
		
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
