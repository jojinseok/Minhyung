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

public class Reservation2 extends JFrame{
	int ab=LoginNextMain.dseat;
		Reservation2(){
			 setTitle("�������ȭ��");
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 Container c=getContentPane();
			
			 JLabel jl=new JLabel("���� ����� �¼��� "+LoginNextMain.dseat+"���Դϴ�. ������ ����Ͻðڽ��ϱ�?");
			 
			 JButton b1=new JButton("�ڷΰ���");
			 b1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						new LoginNextMain();	
				}
			 });
			 JButton b2=new JButton("��������ϱ�");
			 b2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						Connection conn = null; // DB����� ����(����)�� ���� ��ü
					    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
					    PreparedStatement pstm1 = null;  // SQL ���� ��Ÿ���� ��ü
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
						String SQL="UPDATE �����¼� SET SEAT=0 WHERE ID='"+Login.lid+"'";
			            String SQL1="UPDATE �ǽù��¼� SET ��������=0 WHERE SEAT="+ab+"";
			            //String SQL1="UPDATE �ǽù��¼� SET ��������=0 WHERE SEAT=99";
			            pstm = conn.prepareStatement(SQL);
			            pstm1 = conn.prepareStatement(SQL1);
			        	int r= pstm.executeUpdate();
			        	int r1= pstm1.executeUpdate();
			        	
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
				            	JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�","Message",JOptionPane.INFORMATION_MESSAGE);
								setVisible(false);
								new LoginNextMain();	
				            }catch(Exception me){
				                throw new RuntimeException(me.getMessage());
				            }	        
				        }			
				}
			 });
			 JPanel a= new JPanel();
			 a.setLayout(new FlowLayout(FlowLayout.CENTER,70,40));
			 a.add(jl);
			 a.add(b1);
			 a.add(b2);
			 c.add(a);

			setVisible(true);
			setSize(400,400);
		}
}
