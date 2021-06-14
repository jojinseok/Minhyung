package dbj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Manage2 extends JFrame{

	Manage2(){

		Container c= getContentPane();
		setTitle("ȸ�� ����");
		JPanel a= new JPanel();
		JPanel a1= new JPanel();
		JPanel a2= new JPanel();
		JPanel a3= new JPanel();
		a.setLayout(new FlowLayout());
		a1.setLayout(new FlowLayout());
		a2.setLayout(new FlowLayout());
		a3.setLayout(new FlowLayout());
		JLabel ab=new JLabel("               ȸ�� ����            ");
		JLabel ab1=new JLabel("������ ȸ�� ���̵� �Է����ּ���");
		JLabel ab2= new JLabel("ID");
		JTextField abc= new JTextField(15);
		JButton abcd= new JButton("�ڷΰ���");
		 abcd.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new ManagerMain();	
			}
		 });
		JButton abcd1=new JButton("���̵� ����");
		abcd1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		abcd1.setBackground(Color.LIGHT_GRAY);
		abcd1.setForeground(Color.blue);
		abcd1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				String id;
				id=abc.getText();
				Connection conn = null; // DB����� ����(����)�� ���� ��ü
			    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
			    String select="select ID,PHONE from ȸ��";
				String user = "kimheemok"; 
		        String pw = "1234";
		        String url = "jdbc:oracle:thin:@localhost:1521:xe";	 
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
		    		if(did.equals(id)) {
		    		
		    			setVisible(false);
						new Newdelete();
		    			
		    			break;
		    		}
		    	}
		    	if(!did.equals(id)) {
		    		JOptionPane.showMessageDialog(null, "���������ʴ� ���̵��Դϴ�.","Message",JOptionPane.ERROR_MESSAGE);
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
		c.setLayout(new FlowLayout());
		a.add(ab);
		a1.add(ab1);
		a2.add(ab2);
		a2.add(abc);
		a3.add(abcd);
		a3.add(abcd1);
		c.add(a);
		c.add(a1);
		c.add(a2);
		c.add(a3);
		setSize(300,200);
		setVisible(true);
	}	
}

