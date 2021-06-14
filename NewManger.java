package dbj;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewManger extends JFrame {
	String did1=null;
	
	NewManger() {
		JFrame frame = new JFrame();
		
		ImagePanel Background= new ImagePanel(new ImageIcon("C:/Users/82105/eclipse-workspace/dbj/image/abc.jpg").getImage());
		frame.getContentPane().add(Background,BorderLayout.NORTH);
		frame.setTitle("ȸ����������");
		
		Background.setLayout(null);
		
		JLabel MainLabel = new JLabel(" ȸ�� ���� ����");
		MainLabel.setLayout(null);
		MainLabel.setBounds(66, 10, 173, 27);
		Background.add(MainLabel);
		
		JLabel NEW_ID = new JLabel("���̵�");
		NEW_ID.setLayout(null);
		NEW_ID.setBounds(52, 47, 83, 27);
		Background.add(NEW_ID);
		
		JTextField ID_TXT = new JTextField();
		ID_TXT.setBounds(93, 47, 96, 21);
		Background.add(ID_TXT);
		ID_TXT.setColumns(10);
		
		JButton ID_BTN = new JButton("���̵� �ߺ�Ȯ��");
		ID_BTN.setBounds(78, 84, 133, 42);
		Background.add(ID_BTN);
		ID_BTN.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String id;
				id=ID_TXT.getText();
				Connection conn = null; // DB����� ����(����)�� ���� ��ü
			    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
			    PreparedStatement spstm=null;
			    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
			    String sql="SELECT * FROM ȸ�� WHERE id = ?";
			    String select="select ID from ȸ��";
				String user = "kimheemok"; 
			    String pw = "1234";
			    String url = "jdbc:oracle:thin:@localhost:1521:xe";	 
			    String did = null;
			    try {
			    Class.forName("oracle.jdbc.driver.OracleDriver");      
			    conn = DriverManager.getConnection(url, user, pw);	       
				spstm=conn.prepareStatement(select);
				rs=spstm.executeQuery();
				while(rs.next()) {
		    		did=rs.getString("ID");
		   
		    		if(did.equals(id)) {
		    			JOptionPane.showMessageDialog(null, "�ߺ��Ⱦ��̵� �Դϴ�.","Message",JOptionPane.ERROR_MESSAGE);
		    			break;
		    		}
		    	}
		    	if(!did.equals(id)) {
		    		JOptionPane.showMessageDialog(null, "���氡���� ���̵��Դϴ�. ","Message",JOptionPane.INFORMATION_MESSAGE);
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

		JLabel pass = new JLabel("��й�ȣ");
		pass.setLayout(null);
		pass.setBounds(41, 139, 83, 15);
		Background.add(pass);
		
		JLabel phone = new JLabel("��ȭ��ȣ");
		phone.setLayout(null);
		phone.setBounds(41, 173, 67, 15);
		Background.add(phone);
		
		JPasswordField  pass_txt = new JPasswordField();
		pass_txt.setLayout(null);
		pass_txt.setBounds(93, 136, 96, 21);
		Background.add(pass_txt);
		pass_txt.setColumns(10);
		
		JTextField phone_txt = new JTextField();
		phone_txt.setLayout(null);
		phone_txt.setBounds(93, 167, 96, 21);
		Background.add(phone_txt);
		phone_txt.setColumns(10);
		
		JButton Back_btn = new JButton("�ڷΰ���");
		 Back_btn.setLayout(null);
		 Back_btn.setBounds(12, 210, 112, 43);
		 Background.add(Back_btn);
		 Back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new ManagerMain();
				
			}
			 
		 });
		 
		 
		 JButton Sing_up =new JButton("ȸ������");
			Sing_up.setLayout(null);
			Sing_up.setBounds(144, 210, 112, 43);
			Background.add(Sing_up);
			Sing_up.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					String id,pwd,phone;
					id=ID_TXT.getText();
					pwd=pass_txt.getText();
					phone=phone_txt.getText();
					Connection conn = null; // DB����� ����(����)�� ���� ��ü
				    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
				    PreparedStatement pstm1 = null;  // SQL ���� ��Ÿ���� ��ü
				    PreparedStatement spstm=null;
				    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
				    String sql="update ȸ�� set PW = ?, PHONE =? where ID = ? ";
				    		String sql1 = "insert into ȸ�� values(?,?,?)";
				    String select="select ID from ȸ��";
					String user = "kimheemok"; 
				    String pw = "1234";
				    String url = "jdbc:oracle:thin:@localhost:1521:xe";	 
				    String did = null;
				    try {
				    Class.forName("oracle.jdbc.driver.OracleDriver");      
				    conn = DriverManager.getConnection(url, user, pw);	       
					spstm=conn.prepareStatement(select);
					rs=spstm.executeQuery();
					while(rs.next()) {
						did= rs.getString("ID");
						if(did.equals(id)) {
							JOptionPane.showMessageDialog(null, "ID�� �ٸ��ϴ�.","Message",JOptionPane.ERROR_MESSAGE);
						
							break;
						}
					
					}
					if(!did.equals(id)) {
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
						frame.setVisible(false);	
						new ManagerMain();
						
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
			
			
			
		
		
		

		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	
	}

}
