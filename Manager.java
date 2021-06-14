package dbj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
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

public class Manager extends JFrame{
	Manager(){
		
	setTitle("������ �α��� ȭ��");
	
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 Container c=getContentPane();
	 JPanel q1= new JPanel();
	 JLabel j=new JLabel("������ �α��� ȭ��");
	
	 q1.add(j);
	 JLabel j1=new JLabel("  �� �� �� ");
	 q1.add(j1);
	 JTextField jt= new JTextField(18);
	 q1.add(jt);
	 q1.add(new JLabel(" ��й�ȣ"));
	 JTextField jt1=new JTextField(18);
	 q1.add(jt1);
	 JButton b1=new JButton("�α���");
	 b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String id,pwd;
				id=jt.getText();
				pwd=jt1.getText();
				Connection conn = null; // DB����� ����(����)�� ���� ��ü
			    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
			    String select="select ID,PW from ������";
				String user = "kimheemok"; 
		        String pw = "1234";
		        String url = "jdbc:oracle:thin:@localhost:1521:xe";	 
		        String did=null;
		        String dpw=null;
		        try {
		        Class.forName("oracle.jdbc.driver.OracleDriver");      
		        conn = DriverManager.getConnection(url, user, pw);	       
		    	spstm=conn.prepareStatement(select);
		    	rs=spstm.executeQuery();
		    	while(rs.next()) {
		    		did= rs.getString("ID");
		    		dpw= rs.getString("PW");
		    		if(did.equals(id)&&dpw.equals(pwd)) {
		    			System.out.println("�α��ο� �����߽��ϴ�");
						setVisible(false);
						new ManagerMain();	
		    			break;
		    		}
		    	}
		    	if(!did.equals(id)||!dpw.equals(pwd)) {
		    		JOptionPane.showMessageDialog(null, "���̵� ��й�ȣ�� �߸� �Է��߽��ϴ�","Message",JOptionPane.ERROR_MESSAGE);
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
	
		
	 JButton abcd= new JButton("�ڷΰ���");
	 abcd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login();	
		}
	 });
	 
	 JButton Signup_btn= new JButton("ȸ������");
		Signup_btn.setLayout(null);
		Signup_btn.setBounds(193,290,107,42);
		Signup_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			     setVisible(false);
				new ManagerID();
				
			}
			
		});
	 c.setLayout(new BorderLayout());
	 q1.add(b1);
	 c.add(q1);
	 q1.add(Signup_btn);
	 q1.add(abcd);
	 setSize(300,400);
	 setVisible(true);
	 
}
}