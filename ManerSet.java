package dbj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManerSet extends JFrame{

	ManerSet(){
		JFrame frame = new JFrame();
		ImagePanel Background= new ImagePanel(new ImageIcon("C:/Users/82105/eclipse-workspace/dbj/image/Clock.jpg").getImage());
		frame.getContentPane().add(Background,BorderLayout.NORTH);
		frame.setTitle("����Ȯ��ȭ��");

		Background.setLayout(null);

		JLabel j1 = new JLabel();

		if(LoginNextMain.dseat==0) {
			  j1=new JLabel("���� �����Ͻ� �¼��� �����ϴ�.");
		}else {
			  j1=new JLabel("���� ����� �¼��� "+LoginNextMain.dseat+"���Դϴ�.");
		    }
		j1.setFont(new Font("HT����",Font.BOLD,13));
		j1.setForeground(Color.WHITE);
		j1.setBounds(102, 138, 214, 43);
		Background.add(j1);

		JButton btnNewButton = new JButton("�ڷ� ����");
		btnNewButton.setBounds(284, 131, 111, 57);
		Background.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

	
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new ManagerMain();

			}

		});



		frame.setSize(450, 500);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);














	}
}