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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ChangeSeat extends JFrame{
		ChangeSeat(){
			 setTitle("�¼� �� ����");
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 Container c=getContentPane();
			
			 JLabel j=new JLabel("�����ϰ� ������ �¼� ���� �Է����ּ���");
			 JTextField  jt= new JTextField(8);
			 JButton b1=new JButton("�ڷΰ���");
			 b1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						new ManagerMain();
				}
			 });
			 JButton b2=new JButton("�����ϱ�");
			 b2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {

				        int t=Integer.parseInt(jt.getText());
						
						Connection conn = null; // DB����� ����(����)�� ���� ��ü
					    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
					    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
						String user = "sys as sysdba"; 
				        String pw = "Gksmf1238";
				        String url = "jdbc:oracle:thin:@localhost:1521:orcl";	 
						String SQL="UPDATE �ǽù� SET TOTAL="+jt.getText()+" WHERE PC=1";
				        String did=null;
				        int dpc=0;
				        try {
				        Class.forName("oracle.jdbc.driver.OracleDriver");      
				        conn = DriverManager.getConnection(url, user, pw);	     
				        if(!jt.getText().equals(null)&&t<166) {
			            pstm = conn.prepareStatement(SQL);
			        	int r= pstm.executeUpdate();
			        	JOptionPane.showMessageDialog(null, "�¼����� "+jt.getText()+"���� ����Ǿ����ϴ�","Message",JOptionPane.INFORMATION_MESSAGE);
				        }
				        else if(t>165) {
				        	JOptionPane.showMessageDialog(null, "�¼��� 1000�� �̻� ���� �� �����ϴ�","Message",JOptionPane.INFORMATION_MESSAGE);
				        
				        }
				        else {
				        	JOptionPane.showMessageDialog(null, "�¼� ���� �Է����ּ���","Message",JOptionPane.INFORMATION_MESSAGE);
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
				  
								setVisible(false);
								new ManagerMain();
				            }catch(Exception me){
				                throw new RuntimeException(me.getMessage());
				            }	        
				        }			
				}
			 });
			 JPanel a= new JPanel();
			 a.setLayout(new FlowLayout(FlowLayout.CENTER,70,40));
			 a.add(j);
			 a.add(jt);
			 a.add(b1);
			 a.add(b2);
			 c.add(a);

			setVisible(true);
			setSize(400,400);
		}
}
