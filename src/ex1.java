import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ex1 extends JFrame {
	private Image background=new ImageIcon(Main.class.getResource("./image/1.jpg")).getImage();//����̹���
	/*������*/
	public ex1() {
		homeframe();
	}
	public void homeframe() {
		setTitle("1");//Ÿ��Ʋ
		setSize(400,600);//�������� ũ��
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setLayout(null);//���̾ƿ��� ������� ���������ϰ� ����.
		setVisible(true);//â�� ���̰�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
	}
	public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
	}
}
