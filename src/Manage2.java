import java.awt.Container;
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
		    		JOptionPane.showMessageDialog(null, "���̵� �߸� �Է��߽��ϴ�","Message",JOptionPane.ERROR_MESSAGE);
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
