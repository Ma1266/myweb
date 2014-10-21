package junit;
import java.sql.Connection;  
import java.sql.Date;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
   MySql ����(insert)���ܲ���
   Oracle ����(insert)���ܲ���

	MySql������䣺
	CREATE  TABLE `dev`.`test_insert` (
	  `id` INT NOT NULL ,
	  `uname` VARCHAR(10) NULL ,
	  PRIMARY KEY (`id`) )
	ENGINE = InnoDB;
 */
public class JdbcInsterTest {  
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	static int  count=100000;//�ܴ���
	//һ��ҪдrewriteBatchedStatements������Mysql������������ܲ�����
	static String mySqlUrl="jdbc:mysql://127.0.0.1:3306/mysshe?rewriteBatchedStatements=true";
	static String mySqlUserName="root";  
	static String mySqlPassword="root";  
	
	static String oracleurl="jdbc:oracle:thin:@192.168.10.139:1521:orcl";  
	static String oracleuserName="scott";  
	static String oraclepassword="tiger"; 
	
	static String sql = "INSERT INTO t_user VALUES (?,?,?,?,?,?,?,?,?)"; 
	
	//ÿִ�м����ύһ��
	static int[] commitPoint={count,10000,1000,100,10,1};
	
    public static void main(String[] args) { 
    	for(int point:commitPoint){
            test_mysql(point);  
    	}
    	//for(int point:commitPoint){
            //test_mysql_batch(point);  
    	//}
//    	for(int point:commitPoint){
//            test_oracle(point);  
//    	}
//    	for(int point:commitPoint){
//            test_oracle_batch(point);  
//    	}
    }  
    
    /**
     * ��������
     * @return
     */
    public static Connection getConn(String flag){
    	long a=System.currentTimeMillis();
        try {        
        	if("mysql".equals(flag)){
                Class.forName("com.mysql.jdbc.Driver");        
                Connection conn =  DriverManager.getConnection(mySqlUrl, mySqlUserName, mySqlPassword);     
                conn.setAutoCommit(false);  
                return conn;
        	}else if("oracle".equals(flag)){
                Class.forName("oracle.jdbc.OracleDriver");        
                Connection conn =  DriverManager.getConnection(oracleurl, oracleuserName, oraclepassword); 
                conn.setAutoCommit(false);  
                return conn;
        	}else{
        		System.out.println();
        		throw new RuntimeException("flag��������ȷ,flag="+flag);
        	}
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }finally{  
        	long b=System.currentTimeMillis();  
            System.out.println("����������ʱ"+ (b-a)+" ms"); 
        }
        return null;
    }
    /**
     * �ر�����
     * @return
     */
    public static void close(Connection conn){
    	 try {  
             if(conn!=null){
            	 conn.close();  
             }
         } catch (SQLException e) {  
             e.printStackTrace();  
         }
    }
    /**
     * ɾ��������
     * @return
     */
    public static void clear(Connection conn){
    	try{
            Statement st=conn.createStatement();
            boolean bl=st.execute("delete FROM t_user");
            conn.commit();
            st.close();
            System.out.println("ִ�����������"+(bl==false?"�ɹ�":"ʧ��"));
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    /**
     * ��ӡ��Ϣ
     * @return
     */
    public static void print(String key,long startTime,long endTime,int point){
    	System.out.println("ÿִ��"+point+"��sql�ύһ������");
    	System.out.println(key+"����ʱ"+ (endTime-startTime)+" ms,ƽ��ÿ��ִ��"+(count*1000/(endTime-startTime))+"��");
    	System.out.println("----------------------------------");
    }
    /** 
     * mysql����������10������¼ 
     */  
    public static void test_mysql(int point){  
        Connection conn=getConn("mysql");  
        clear(conn);
        try {        
              PreparedStatement prest = conn.prepareStatement(sql);        
              long a=System.currentTimeMillis();  
              for(int x = 100; x <= count; x++){        
                 prest.setInt(1, x);        
                 prest.setString(2, "admin"+x); 
                 prest.setString(3, "123456");
                 prest.setString(4, "nick_admin"+x);
                 prest.setString(5, "138974"+x);
                 prest.setString(6, "138974"+x);
                 prest.setInt(7, 1);        
                 prest.setDate(8,new Date(a));
                 prest.setString(9, "123456@qq.com");
                 prest.execute();  
                 if(x%point==0){
                	 conn.commit();
                 }
              }        
              long b=System.currentTimeMillis();  
              print("MySql����������10������¼",a,b,point);
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }finally{  
            close(conn);    
        }  
    }  
    
    /** 
     * mysql��������10������¼ 
     */  
    public static void test_mysql_batch(int point){  
        Connection conn=getConn("mysql");  
        clear(conn);
        try {        
            PreparedStatement prest = conn.prepareStatement(sql);        
            long a=System.currentTimeMillis();  
            for(int x = 1; x <= count; x++){        
                prest.setInt(1, x);        
                prest.setString(2, "����");        
                prest.addBatch();    
                if(x%point==0){
                	prest.executeBatch();      
                	conn.commit();
                }
            }        
            long b=System.currentTimeMillis();  
            print("MySql��������10������¼",a,b,point);
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }finally{  
            close(conn);    
        }  
    }  
    
    /** 
     * oracle����������10������¼ 
     */  
    public static void test_oracle(int point){  
        Connection conn=getConn("oracle");  
        clear(conn);
        try {        
            PreparedStatement prest = conn.prepareStatement(sql);        
            long a=System.currentTimeMillis();  
            for(int x = 1; x <= count; x++){        
                prest.setInt(1, x);        
                prest.setString(2, "����");        
                prest.execute();  
                if(x%point==0){
                	conn.commit();
                }
            }  
            long b=System.currentTimeMillis();  
            print("Oracle����������10���¼",a,b,point);
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }finally{  
            close(conn);    
        }  
    }  
    /** 
     * oracle��������10������¼ 
     */  
    public static void test_oracle_batch(int point){  
        Connection conn=getConn("oracle");   
        clear(conn);
        try {        
            PreparedStatement prest = conn.prepareStatement(sql);        
            long a=System.currentTimeMillis();  
            for(int x = 1; x <= count; x++){        
                prest.setInt(1, x);        
                prest.setString(2, "����");        
                prest.addBatch();  
                if(x%point==0){
                	prest.executeBatch();      
                	conn.commit();
                }
            }  
            long b=System.currentTimeMillis();  
            print("Oracle��������10���¼",a,b,point);
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }finally{ 
        	close(conn); 
        }  
    }  
}  