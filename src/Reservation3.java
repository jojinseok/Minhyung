import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reservation3 extends JFrame{
		Reservation3(){
			 setTitle("����Ȯ��ȭ��");
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 Container c=getContentPane();
			 c.setLayout(new FlowLayout(FlowLayout.LEFT,5,40));
			 JLabel jl=new JLabel();
if(LoginNextMain.dseat==0) {
	  jl=new JLabel("���� �����Ͻ� �¼��� �����ϴ�.");
}else {
	  jl=new JLabel("���� ����� �¼��� "+LoginNextMain.dseat+"���Դϴ�.");
    }
			 JButton b1=new JButton("�ڷΰ���");
			 b1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						new LoginNextMain();	
				}
			 });
			 JPanel a= new JPanel();
			 a.setLayout(new FlowLayout(FlowLayout.CENTER,140,40));
			 a.add(jl);
			 a.add(b1);
			 c.add(a);

			setVisible(true);
			setSize(800,400);
		}
}
