package com.ZURADEV.chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtAddress;
	private JTextField txtName;
	private JTextField txtPort;
	private JLabel lblNewLabel_2;

	/**
	 * Create the frame.
	 */
	public Login() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setResizable(false);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 380);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtAddress = new JTextField();
		txtAddress.setBounds(65, 131, 153, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(65, 91, 153, 20);
		contentPane.add(txtName);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(128, 76, 27, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("IP Address:");
		lblNewLabel_1.setBounds(114, 118, 56, 14);
		contentPane.add(lblNewLabel_1);

		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(65, 175, 153, 20);
		contentPane.add(txtPort);

		lblNewLabel_2 = new JLabel("Port:");
		lblNewLabel_2.setBounds(128, 162, 27, 14);
		contentPane.add(lblNewLabel_2);
		// creates login button
		JButton btnLogin = new JButton("Login");
		// action listener login, storing information
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// save login information
				String name = txtName.getText();
				String address = txtAddress.getText();
				// Integer.parseInt() to transform string to int
				int port = Integer.parseInt(txtPort.getText());
				login(name, address, port);
			}

			private void login(String name, String address, int port) {
				dispose(); // close login window
				System.out.println(name + ", " + address + ", " + port);
				new ClientWindow(name, address, port);
			}

		});
		//
		btnLogin.setBounds(97, 213, 89, 23);
		contentPane.add(btnLogin);
	}

//main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
