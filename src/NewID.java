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

public class NewID extends JFrame{

String did1=null;
NewID(){
	setTitle("ȸ������");
	Container c= getContentPane();
	JPanel jp= new JPanel();
	JPanel jp1= new JPanel();
	JPanel jp2= new JPanel();
	JPanel jp3= new JPanel();
	JPanel jp12= new JPanel();
	JPanel jp132= new JPanel();
	JLabel a= new JLabel("�¼� ���� ȸ������");
	JTextField k123= new JTextField("");
	jp.setLayout(new FlowLayout());
	jp1.setLayout(new FlowLayout());
	jp2.setLayout(new FlowLayout());
	jp3.setLayout(new FlowLayout());
	JLabel a1= new JLabel("  �� �� ��");
	JTextField jf= new JTextField(10);
	JButton jb= new JButton("���̵� �ߺ�Ȯ��");
	jb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {

		    String id;
			id=jf.getText();
			Connection conn = null; // DB����� ����(����)�� ���� ��ü
		    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
		    PreparedStatement spstm=null;
		    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
		    String sql="insert into ȸ�� values(?,?,?)";
		    String select="select ID from ȸ��";
			String user = "sys as sysdba"; 
		    String pw = "Gksmf1238";
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";	 
		    String did = null;
		    try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");      
		    conn = DriverManager.getConnection(url, user, pw);	       
			spstm=conn.prepareStatement(select);
			rs=spstm.executeQuery();
			while(rs.next()) {
				did= rs.getString("ID");
				if(did.equals(id)) {
					JOptionPane.showMessageDialog(null, "ID�� �ߺ��Ǽ� ȸ�������� �� �� �����ϴ�","Message",JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		     } catch (SQLException me1) {
					System.out.println("sql����");      
					me1.printStackTrace();
		    }catch(Exception me) {
		    	System.out.println("����");
		    }
		    finally{
		        // DB ������ �����Ѵ�.
		    	if(!did.equals(id)) {
		    		did1=id;
					JOptionPane.showMessageDialog(null, "ȸ������ �� �� �ִ� ���̵� �Դϴ�","Message",JOptionPane.INFORMATION_MESSAGE);
				}
		        try{
		            if ( rs != null ){rs.close();}   
		            if ( pstm != null ){pstm.close();}   
		            if ( conn != null ){conn.close(); }
		        }catch(Exception ne){
		            throw new RuntimeException(ne.getMessage());
		        }
		        
		    }
	}
});
			
	jp.add(a);
	jp1.add(a1);
	jp1.add(jf);
	jp12.add(jb);
	JLabel a2= new JLabel(" ��й�ȣ");
	JTextField jf1= new JTextField(10);
	jp2.add(a2);
	jp2.add(jf1);

	JLabel a5= new JLabel(" ��ȭ��ȣ");
	JTextField jf5= new JTextField(10);
	jp132.add(a5);
	jp132.add(jf5);
	
	JButton jb2= new JButton("�ڷΰ���");
	 jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
				new Login();
		}
	 });
    JButton jb3=new JButton("ȸ������");
    jb3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {

		    String id,pwd,phone;
			id=jf.getText();
			pwd=jf1.getText();
			phone=jf5.getText();
			Connection conn = null; // DB����� ����(����)�� ���� ��ü
		    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
		    PreparedStatement pstm1 = null;  // SQL ���� ��Ÿ���� ��ü
		    PreparedStatement spstm=null;
		    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
		    String sql="insert into ȸ�� values(?,?,?)";
		    String sql1="insert into �����¼� values(?,?,?)";
		    String select="select ID from ȸ��";
			String user = "sys as sysdba"; 
		    String pw = "Gksmf1238";
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";	 
		    String did = null;
		    try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");      
		    conn = DriverManager.getConnection(url, user, pw);	       
			spstm=conn.prepareStatement(select);
			rs=spstm.executeQuery();
			while(rs.next()) {
				did= rs.getString("ID");
				if(did.equals(id)) {
					JOptionPane.showMessageDialog(null, "ID�� �ߺ��Ǽ� ȸ�������� �� �� �����ϴ�","Message",JOptionPane.ERROR_MESSAGE);
					break;
				}
			
			}
			if(!did.equals(id)&&id.equals(did1)) {
		        pstm = conn.prepareStatement(sql);
		    	pstm.setString(1, id); 
		    	pstm.setString(2, pwd); 
		    	pstm.setString(3, phone);
		    	pstm1= conn.prepareStatement(sql1);
		    	pstm1.setString(1, id); 
		    	pstm1.setInt(2, 1); 
		    	pstm1.setInt(3, 0);
		    	pstm.executeUpdate();
		    	pstm1.executeUpdate();
		    	JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�","Message",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);	
				new Login();
			}else {
				JOptionPane.showMessageDialog(null, "ID�ߺ�Ȯ���� �Ϸ��� ���̵�� �Է����ּ���","Message",JOptionPane.ERROR_MESSAGE);
			}
		     } catch (SQLException me1) {
					System.out.println("sql����");      
					me1.printStackTrace();
		    }catch(Exception me) {
		    	System.out.println("����");
		    }
		    finally{
		        // DB ������ �����Ѵ�.
		        try{
		            if ( rs != null ){rs.close();}   
		            if ( pstm != null ){pstm.close();}   
		            if ( conn != null ){conn.close(); }
		        }catch(Exception ne){
		            throw new RuntimeException(ne.getMessage());
		        }
		        
		    }
	}
 });


    jp3.add(jb2);
    jp3.add(jb3);
    c.setLayout(new FlowLayout());
    c.add(jp);
    c.add(jp1);
    c.add(jp12);
    c.add(jp2);
    c.add(jp132);
    c.add(jp3);
    setVisible(true);
    setSize(300,300);
}
	
}