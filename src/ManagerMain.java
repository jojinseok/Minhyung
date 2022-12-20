import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ManagerMain extends JFrame{
	ManagerMain(){ 
		JFrame frame = new JFrame();
		ImagePanel Background= new ImagePanel(new ImageIcon("./image/Clock.jpg").getImage());
		frame.getContentPane().add(Background,BorderLayout.NORTH);
		frame.setTitle("������ ���� ȭ��");
		
		JLabel MainLabel = new JLabel("������ ���� ȭ��");
		MainLabel.setLayout(null);
		MainLabel.setBounds(83, 10, 171, 52);
		MainLabel.setFont(new Font("HY����",Font.BOLD,15));
		MainLabel.setForeground(Color.WHITE);
		Background.add(MainLabel);
		
		JButton Confirm_btn = new JButton("ȸ�� Ȯ��");
		Confirm_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Confirm_btn.setBackground(Color.LIGHT_GRAY);
		Confirm_btn.setForeground(Color.BLUE);
		 Confirm_btn.setLayout(null);
		 Confirm_btn.setBounds(12, 72, 107, 42);
		 Background.add(Confirm_btn);
		 Confirm_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Manage1();
				
			}
			 
		 });
		JButton Delete_member_btn = new JButton("ȸ�� ����");
		Delete_member_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Delete_member_btn.setBackground(Color.LIGHT_GRAY);
		Delete_member_btn.setForeground(Color.BLUE);
		Delete_member_btn.setLayout(null);
		Delete_member_btn.setBounds(12, 138, 107, 42);
		Background.add(Delete_member_btn);
		Delete_member_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Manage2();
				
			}
			
		});
		 
		 
		 
		 
		 
		 
		JButton Revise_member_btn = new JButton("ȸ�� ����");
		Revise_member_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Revise_member_btn.setBackground(Color.LIGHT_GRAY);
		Revise_member_btn.setForeground(Color.BLUE);
		Revise_member_btn.setLayout(null);
		Revise_member_btn.setBounds(12, 209, 107, 42);
		Background.add(Revise_member_btn);
		Revise_member_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Manage3();
				
			}
			
		});
		
		JButton Manage_seat_btn = new JButton("�¼� ����");
		Manage_seat_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Manage_seat_btn.setBackground(Color.LIGHT_GRAY);
		Manage_seat_btn.setForeground(Color.BLUE);
		Manage_seat_btn.setLayout(null);
		Manage_seat_btn.setBounds(99, 283, 107, 42);
		Background.add( Manage_seat_btn);
		Manage_seat_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Manage4();
			}
			
		});
		 
		 JButton Logout_btn = new JButton("�α׾ƿ�");
		 Logout_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 Logout_btn.setBackground(Color.LIGHT_GRAY);
		 Logout_btn.setForeground(Color.BLUE);
		 Logout_btn .setLayout(null);
		 Logout_btn.setBounds(193, 72, 107, 42);
		 Background.add(Logout_btn);
		 Logout_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Manager();
				
			}
			 
		 });
		 
		 
		 JButton Exit_btn = new JButton("����");
		 Exit_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 Exit_btn.setBackground(Color.LIGHT_GRAY);
		 Exit_btn.setForeground(Color.BLUE);
		 Exit_btn.setLayout(null);
		 Exit_btn.setBounds(193, 138, 107, 42);
		 Background.add(Exit_btn);
		 Exit_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				System.exit(0);
				
			}
			 
		 });
		 JButton go_user = new JButton("����� ȭ������");
		 go_user.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 go_user.setBackground(Color.LIGHT_GRAY);
		 go_user.setForeground(Color.BLUE);
		 go_user.setLayout(null);
		 go_user.setBounds(181, 209, 145, 42);
		 Background.add(go_user);
		 go_user.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login();
				
			}
			 
		 });
		
		
		
		frame.setSize(400,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}