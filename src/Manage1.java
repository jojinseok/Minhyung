import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Manage1 extends JFrame{
	Container c;
	JTextArea ta;
	JButton s;
	JButton sa;
	JPanel j= new JPanel();
	Connection conn = null; // DB����� ����(����)�� ���� ��ü
    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
    String sql="insert into ȸ�� values(?,?,?)";
    String select="select ID from ȸ��";
	String user = "sys as sysdba"; 
    String pw1 = "Gksmf1238";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";	  
    String result[] = new String[1000];
    String result1="";
    int i=0;
	Manage1(){		
		try {			
			ta= new JTextArea("\t   ȸ������\n",35,35);
      	  Class.forName("oracle.jdbc.driver.OracleDriver");  
      	  conn = DriverManager.getConnection(url, user, pw1);	    
          // SQL ������ ����� ���� ������ ���Ǿ�(SELECT��)���
          // �� ����� ���� ResulSet ��ü�� �غ��� �� �����Ų��.
          String quary = "SELECT ID,PW,PHONE FROM ȸ��";
              pstm = conn.prepareStatement(quary);
              rs = pstm.executeQuery();
          while(rs.next()){
              String id = rs.getString("ID");
              String pw = rs.getString("PW");
              String phone = rs.getString("PHONE");
             result[i] ="  ID : "+id+"   PW : "+pw+"   PHONE : "+ phone+"\n";
             result1+=result[i];
        
              i++;
          }
		} catch (Exception sqle) {
            System.out.println("SELECT������ ���� �߻�");
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            ta.append(result1);
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
		setTitle("ȸ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c=getContentPane();
			
		JButton abcd= new JButton("�ڷΰ���");
		 abcd.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new ManagerMain();	
			}
		 });
		 
		c.setLayout(new BorderLayout());
		j.add(new JLabel("PC�濡 ������ ȸ�� ����"));
	    j.add(ta);
	    j.add(new JScrollPane(ta));
	    j.add(abcd);
	    c.add(j);
	    setSize(500,1000);
	    setVisible(true);
	}

}
