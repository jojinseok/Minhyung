package dbj;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Manage4 extends JFrame {
	

	
		JCheckBox[] place=new JCheckBox[14];
		String[] name = {"1���ڸ�","2���ڸ�","3���ڸ�","4���ڸ�","5���ڸ�","6���ڸ�","7���ڸ�","8���ڸ�","9���ڸ�","10���ڸ�","11���ڸ�","12���ڸ�","13���ڸ�","14���ڸ�"};
		Manage4(){
				 setTitle("�¼� ���� ȭ��");
				 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 Container c=getContentPane();
				 c.setLayout(new FlowLayout(FlowLayout.LEFT,5,40));
				 for(int i=0;i<place.length;i++) {
					 place[i]=new JCheckBox(name[i]);
					 place[i].setBorderPainted(true);
					 c.add(place[i]);
				 }
				 JButton b1=new JButton("�ڷΰ���");
				 b1.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							setVisible(false);
							new ManagerMain();	
					}
				 });
				 JButton b2=new JButton("����ȭ��");
				 b2.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							setVisible(false);
							new  ManerSet();	
					}
				 });
				 JPanel a= new JPanel();
				 a.setLayout(new FlowLayout(FlowLayout.CENTER,140,40));
				 a.add(b1);
				 a.add(b2);
				 c.add(a);

				setVisible(true);
				setSize(400,400);
		
	}

}
