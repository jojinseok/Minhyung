import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Reservation1 extends JFrame{
JCheckBox[] place=new JCheckBox[Login.pctotal];
String[] name = new String [Login.pctotal];
JCheckBox did2 = null;
	Reservation1() {
		Connection conn5 = null; // DB����� ����(����)�� ���� ��ü
	    PreparedStatement pstm5 = null;  // SQL ���� ��Ÿ���� ��ü
	    ResultSet rs5 = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
	    String select5="select*from �ǽù��¼�";
		String user = "sys as sysdba"; 
        String pw = "Gksmf1238";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";	 
        String did=null;
        int dpc=0;
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");      
	        conn5 = DriverManager.getConnection(url, user, pw);	       
	    	
		for(int n=0; n<Login.pctotal; n++) {
			name[n] = (n+1)+"��° �ڸ�";
		}
		 setTitle("����ȭ��");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Container c=getContentPane();
		 c.setLayout(new FlowLayout(FlowLayout.LEFT,5,40));
		 ButtonGroup bg=new ButtonGroup();
		 pstm5=conn5.prepareStatement(select5);
	    	rs5=pstm5.executeQuery();
	    	int i=0;
		 while(rs5.next()) {
			 String id5 = rs5.getString("PC");
             int pw5 = rs5.getInt("SEAT");
             int seat5 = rs5.getInt("��������");
			 place[i]=new JCheckBox(name[i]);
			 place[i].setBorderPainted(true);
			 if(seat5==1) {
				 place[i].setEnabled(false);
			 }else {
				 place[i].setEnabled(true);
			 }
			 bg.add(place[i]);
			 c.add(place[i]);
			 i++;
			 if(i==Login.pctotal) {
				 break;
			 }
		 }
		 JButton b1=new JButton("�ڷΰ���");
		 b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new LoginNextMain();	
			}
		 });
		 JButton b2=new JButton("�����ϱ�");
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
			        int seat=0;
			        int dpc=0;
			        try {
				        Class.forName("oracle.jdbc.driver.OracleDriver");      
				        conn = DriverManager.getConnection(url, user, pw);	       
				    	spstm=conn.prepareStatement(select);
				    	rs=spstm.executeQuery();
						for(seat=0; seat<place.length;seat++) {
							if(place[seat].isSelected()) {
					            String SQL="UPDATE �����¼� SET SEAT="+(seat+1)+" WHERE ID='"+Login.lid+"'";
					            String SQL1="UPDATE �ǽù��¼� SET ��������=1 WHERE SEAT="+(seat+1)+"";
					            pstm = conn.prepareStatement(SQL);
					            pstm1 = conn.prepareStatement(SQL1);
					        	int r= pstm.executeUpdate();
					        	int r1=pstm1.executeUpdate();
								JOptionPane.showMessageDialog(null, "�����Ͻ� "+(seat+1)+"�� �ڸ��� ����Ǿ����ϴ�","Message",JOptionPane.INFORMATION_MESSAGE);                 
								setVisible(false);
								new LoginNextMain();	
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
		 JPanel a= new JPanel();
		 a.setLayout(new FlowLayout(FlowLayout.CENTER,70,40));
		 a.add(b1);
		 a.add(b2);
		 JScrollPane jsp = new JScrollPane(a);
		 jsp.setBounds(200,200,200,200);  
		 c.add(jsp);

		setVisible(true);
		setSize(2400,2400);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 finally{
	            // DB ������ �����Ѵ�.
	            try{
	                if ( rs5 != null ){rs5.close();}   
	                if ( pstm5 != null ){pstm5.close();}   
	                if ( conn5 != null ){conn5.close(); }
	            }catch(Exception me){
	                throw new RuntimeException(me.getMessage());
	            }	        
	        }
	}
}