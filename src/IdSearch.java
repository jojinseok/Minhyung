import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.JTextField;

public class IdSearch extends JFrame{
	
		 
	IdSearch(){
		JFrame frame = new JFrame();

		ImagePanel Background= new ImagePanel(new ImageIcon("./image/Blue.jpg").getImage());
		frame.getContentPane().add(Background,BorderLayout.NORTH);
		frame.setTitle("���̵�ã��");
		
		Background.setLayout(null);
	
		
		
		
		JLabel ab=new JLabel("���̵� ã��"); 
		ab.setLayout(null);
		ab.setBounds(102,10,83 , 45);
		ab.setFont(new Font("HY����",Font.BOLD,13));
		ab.setForeground(Color.black);
		Background.add(ab);
		
		
		
		
	
		
		JLabel ab1=new JLabel("��ȭ��ȣ�� �Է����ּ���");
		ab1.setLayout(null);
		ab1.setBounds(72, 79, 168, 45);
		ab1.setForeground(Color.black);
		Background.add(ab1);
		
		
		JLabel ab2= new JLabel("��ȭ��ȣ");
		ab2.setLayout(null);
		ab2.setBounds(46, 134, 92, 45);
		ab2.setForeground(Color.black);
		Background.add(ab2);
		
		JTextField abc= new JTextField(15);
		abc.setBounds(102, 146, 96, 21);
		Background.add(abc);
		abc.setColumns(10);
		
		JButton abcd= new JButton("�ڷΰ���");
		abcd.setBounds(12, 212, 113, 41);
		Background.add(abcd);
		 abcd.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new Login();	
			}
		 });
		JButton abcd1=new JButton("���̵� �˻�");
		abcd1.setBounds(140, 212, 113, 41);
		Background.add(abcd1);
		abcd1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String id,phone;
				phone=abc.getText();
				Connection conn = null; // DB����� ����(����)�� ���� ��ü
			    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
			    String select="select ID,PHONE from ȸ��";
				String user = "sys as sysdba"; 
		        String pw = "Gksmf1238";
		        String url = "jdbc:oracle:thin:@localhost:1521:orcl";	 
		        String did=null;
		        String dphone=null;
		        String dpw= null;
		        try {
		        Class.forName("oracle.jdbc.driver.OracleDriver");      
		        conn = DriverManager.getConnection(url, user, pw);	       
		    	spstm=conn.prepareStatement(select);
		    	rs=spstm.executeQuery();
		    	while(rs.next()) {
		    		did=rs.getString("ID");
		    		dphone= rs.getString("PHONE");
		    		if(dphone.equals(phone)) {
		    			JOptionPane.showMessageDialog(null, "ID : "+did,"Message",JOptionPane.INFORMATION_MESSAGE);
		    			break;
		    		}
		    	}
		    	if(!dphone.equals(phone)) {
		    		JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� �߸� �Է��߽��ϴ�","Message",JOptionPane.ERROR_MESSAGE);
				}
		         } catch (SQLException be) {
		        	 System.out.println("sql����");
		        	 be.printStackTrace();
		        }catch(Exception ne) {
		        	System.out.println("����");
		        }
		        finally{
		            // DB ������ �����Ѵ�.
		            try{
		                if ( rs != null ){rs.close();}   
		                if ( pstm != null ){pstm.close();}   
		                if ( conn != null ){conn.close(); }
		            }catch(Exception me){
		                throw new RuntimeException(me.getMessage());
		            }
		        
		        }
		}
		
	 });
	
	
		
	
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
			}
	 }
	


class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	public  int getWidth() {
		return img.getWidth(null);
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}
}