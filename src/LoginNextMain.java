import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
public class LoginNextMain extends JFrame{

    static int dseat= 0;
LoginNextMain(){
	setTitle(" �¼� ���� ���α׷� ");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel a= new JPanel();
	JPanel a1= new JPanel();
	JPanel a2= new JPanel();
	JPanel a3= new JPanel();
	JPanel a4= new JPanel();
	JPanel a5= new JPanel();
	JPanel a6= new JPanel();
	JPanel a7= new JPanel();

	a1.setLayout(new FlowLayout());
	a2.setLayout(new GridLayout(2,1));
	a3.setLayout(new GridLayout(2,1));
	a4.setLayout(new GridLayout(2,1));
	a5.setLayout(new GridLayout(2,2));
	a6.setLayout(new GridLayout(2,2));
	a7.setLayout(new GridLayout(2,2));
	 Container c=getContentPane();
	 c.setLayout(new GridLayout(8,1,2,5));
	 
	 JButton jb=new JButton("�����ϱ�");
	 jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Connection conn = null; // DB����� ����(����)�� ���� ��ü
			    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
			    String select="select*from �����¼�";
				String user = "sys as sysdba"; 
		        String pw = "Gksmf1238";
		        String url = "jdbc:oracle:thin:@localhost:1521:orcl";	 
		        String did=null;
		        int dpc=0;
		        try {
		        Class.forName("oracle.jdbc.driver.OracleDriver");      
		        conn = DriverManager.getConnection(url, user, pw);	       
		    	spstm=conn.prepareStatement(select);
		    	rs=spstm.executeQuery();
		    	while(rs.next()) {
					did= rs.getString("ID");
					dpc= rs.getInt("PC");
					dseat= rs.getInt("SEAT");
					if(did.equals(Login.lid)) {
						break;
					}
		    	}
		    	if(did.equals(Login.lid)&&dseat!=0) {
					JOptionPane.showMessageDialog(null, "�̹� ����� ������ �ֽ��ϴ�. ���� ��� �� ����� �ֽñ� �ٶ��ϴ�","Message",JOptionPane.ERROR_MESSAGE);
				}
		    	else {
					setVisible(false);
					new Reservation1();
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
		                if ( pstm != null ){pstm.close();}   
		                if ( conn != null ){conn.close(); }
		            }catch(Exception me){
		                throw new RuntimeException(me.getMessage());
		            }	        
		        }			
		}
	 });
	 JButton jb1=new JButton("��������ϱ�");
	 jb1.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
				Connection conn = null; // DB����� ����(����)�� ���� ��ü
			    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
			    String select="select*from �����¼�";
				String user = "sys as sysdba"; 
		        String pw = "Gksmf1238";
		        String url = "jdbc:oracle:thin:@localhost:1521:orcl";	 
		        String did=null;
		        int dpc=0;
		        try {
		        Class.forName("oracle.jdbc.driver.OracleDriver");      
		        conn = DriverManager.getConnection(url, user, pw);	       
		    	spstm=conn.prepareStatement(select);
		    	rs=spstm.executeQuery();
		    	while(rs.next()) {
					did= rs.getString("ID");
					dpc= rs.getInt("PC");
					dseat= rs.getInt("SEAT");
					if(did.equals(Login.lid)&&dseat==0) {
						JOptionPane.showMessageDialog(null, "����� �¼��� �����ϴ�. ���� �� ����� �ֽñ� �ٶ��ϴ�","Message",JOptionPane.ERROR_MESSAGE);
						break;
					}
	            	if(did.equals(Login.lid)&&dseat!=0) {
						setVisible(false);
						new Reservation2();
					}
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
	 JButton jb2=new JButton("������ �¼� Ȯ���ϱ�");
	 jb2.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
				Connection conn = null; // DB����� ����(����)�� ���� ��ü
			    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
			    String select="select*from �����¼�";
				String user = "sys as sysdba"; 
		        String pw = "Gksmf1238";
		        String url = "jdbc:oracle:thin:@localhost:1521:orcl";	 
		        String did=null;
		        int dpc=0;
		        try {
		        Class.forName("oracle.jdbc.driver.OracleDriver");      
		        conn = DriverManager.getConnection(url, user, pw);	       
		    	spstm=conn.prepareStatement(select);
		    	rs=spstm.executeQuery();
		    	while(rs.next()) {
					did= rs.getString("ID");
					dpc= rs.getInt("PC");
					dseat= rs.getInt("SEAT");
					if(did.equals(Login.lid)) {
						break;
					}
		    	}
					setVisible(false);
					new Reservation3();
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
	 JButton jb3=new JButton("�¼� ��Ȳ");
	 jb3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Reservation4();	
		}
	 });
	 JButton jb4=new JButton("�α׾ƿ�");
	 jb4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login();	
		}
	 });
	 JButton jb5=new JButton("����");
	 jb5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);	
		}
	 });
	 JLabel a123=new JLabel("�¼� ���� ���α׷�");
	 ImageIcon im1= new ImageIcon("./image/12.PNG");
	 	JLabel im2= new JLabel(im1);
	 a1.add(a123);
	 a2.add(jb);
	 a3.add(jb1);
	 a4.add(jb2);
	 a5.add(jb3);
	 a6.add(jb4);
	 a7.add(jb5);
	 c.add(new JLabel(" "));
	 c.add(a1);
	 c.add(a2);
	 c.add(a3);
	 c.add(a4);
	 c.add(a5);
	 c.add(a6);
	 c.add(a7);
	 setSize(350,550);
	 setVisible(true);
	 
}
	
}
