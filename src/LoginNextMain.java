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
	setTitle(" 좌석 예약 프로그램 ");
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
	 
	 JButton jb=new JButton("예약하기");
	 jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Connection conn = null; // DB연결된 상태(세션)을 담은 객체
			    PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
			    String select="select*from 예약좌석";
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
					JOptionPane.showMessageDialog(null, "이미 예약된 정보가 있습니다. 예약 취소 후 사용해 주시기 바랍니다","Message",JOptionPane.ERROR_MESSAGE);
				}
		    	else {
					setVisible(false);
					new Reservation1();
            	}
		         } catch (SQLException be) {
		        	 System.out.println("sql오류");
		        	 be.printStackTrace();
		        }catch(Exception ne) {
		        	System.out.println("오류");
		        }
		        finally{
		            // DB 연결을 종료한다.
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
	 JButton jb1=new JButton("예약취소하기");
	 jb1.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
				Connection conn = null; // DB연결된 상태(세션)을 담은 객체
			    PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
			    String select="select*from 예약좌석";
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
						JOptionPane.showMessageDialog(null, "예약된 좌석이 없습니다. 예약 후 사용해 주시기 바랍니다","Message",JOptionPane.ERROR_MESSAGE);
						break;
					}
	            	if(did.equals(Login.lid)&&dseat!=0) {
						setVisible(false);
						new Reservation2();
					}
		    	}
		         } catch (SQLException be) {
		        	 System.out.println("sql오류");
		        	 be.printStackTrace();
		        }catch(Exception ne) {
		        	System.out.println("오류");
		        }
		        finally{
		            // DB 연결을 종료한다.
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
	 JButton jb2=new JButton("예약한 좌석 확인하기");
	 jb2.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
				Connection conn = null; // DB연결된 상태(세션)을 담은 객체
			    PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
			    String select="select*from 예약좌석";
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
		        	 System.out.println("sql오류");
		        	 be.printStackTrace();
		        }catch(Exception ne) {
		        	System.out.println("오류");
		        }
		        finally{
		            // DB 연결을 종료한다.
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
	 JButton jb3=new JButton("좌석 현황");
	 jb3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Reservation4();	
		}
	 });
	 JButton jb4=new JButton("로그아웃");
	 jb4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login();	
		}
	 });
	 JButton jb5=new JButton("종료");
	 jb5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);	
		}
	 });
	 JLabel a123=new JLabel("좌석 예약 프로그램");
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
