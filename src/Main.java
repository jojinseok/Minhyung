import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date nowDate = new Date(); 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd"); 
		String NowDate = simpleDateFormat.format(nowDate);     
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
	    PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
	    PreparedStatement pstm1=null;
	    PreparedStatement pstm2=null;
	    ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
	    String select="select*from �ǽù�";
		String user = "sys as sysdba"; 
        String pw = "Gksmf1238";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";	 
        String newdate=" ";
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");      
		        conn = DriverManager.getConnection(url, user, pw);	   
                pstm = conn.prepareStatement(select);
                rs = pstm.executeQuery();
           while(rs.next()){
                String pc = rs.getString("PC");
                int total = rs.getInt("TOTAL");
                newdate = rs.getString("��¥");
            }
        if(!NowDate.equals(newdate)) {
         String SQL="UPDATE �����¼� SET SEAT=0";
          String SQL1="UPDATE �ǽù��¼� SET ��������=0";         
         String SQL2="UPDATE �ǽù� SET ��¥="+NowDate+"";  
            pstm = conn.prepareStatement(SQL);            
            pstm1 = conn.prepareStatement(SQL1);
            pstm2 = conn.prepareStatement(SQL2);
        	int r= pstm.executeUpdate();
        	int r1= pstm1.executeUpdate();
        	int r2= pstm2.executeUpdate();
        }

        new Login();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			 try{
	                if ( rs != null ){rs.close();}   
	                if ( pstm != null ){pstm.close();}   
	                if ( pstm1 != null ){pstm.close();}  
	                if ( pstm2 != null ){pstm.close();}   
	                if ( conn != null ){conn.close(); }
	            }catch(Exception me){
	                throw new RuntimeException(me.getMessage());
	            }	
		}
	}
}