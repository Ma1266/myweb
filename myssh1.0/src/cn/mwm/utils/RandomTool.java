package cn.mwm.utils;

import java.util.Random;
import java.util.UUID;

public class RandomTool {
	
	//����һ��a��b�������
	public static double random(double a, double b){
		return (b - a)*Math.random() + a;
	}
	
	public static int randomInt(double a, double b){
		return new Double((b - a)*Math.random() + a).intValue();
	}
	
	public static String randomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static void main(String args[]){
//		System.out.println(randomInt(1, 100));
//		System.out.println(randomInt(1, 100));
//		System.out.println(randomInt(1, 100));
//		System.out.println(randomString());
		
		int i = 100010;
		System.out.println(i % (10*10000));
	}
	
	//��Ҫ�о����ظ�������������岻��
	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    public static final String numberChar = "0123456789"; 

    /** 
     * ����һ������������ַ���(ֻ������Сд��ĸ������) 
     * 
     * @param length ����ַ������� 
     * @return ����ַ��� 
     */ 
    public static String generateString(int length) { 
            StringBuffer sb = new StringBuffer(); 
            Random random = new Random(); 
            for (int i = 0; i < length; i++) { 
                    sb.append(allChar.charAt(random.nextInt(allChar.length()))); 
            } 
            return sb.toString(); 
    } 

    /** 
     * ����һ���������������ĸ�ַ���(ֻ������Сд��ĸ) 
     * 
     * @param length ����ַ������� 
     * @return ����ַ��� 
     */ 
    public static String generateMixString(int length) { 
            StringBuffer sb = new StringBuffer(); 
            Random random = new Random(); 
            for (int i = 0; i < length; i++) { 
                    sb.append(allChar.charAt(random.nextInt(letterChar.length()))); 
            } 
            return sb.toString(); 
    } 

    /** 
     * ����һ���������������д��ĸ�ַ���(ֻ������Сд��ĸ) 
     * 
     * @param length ����ַ������� 
     * @return ����ַ��� 
     */ 
    public static String generateLowerString(int length) { 
            return generateMixString(length).toLowerCase(); 
    } 

    /** 
     * ����һ�������������Сд��ĸ�ַ���(ֻ������Сд��ĸ) 
     * 
     * @param length ����ַ������� 
     * @return ����ַ��� 
     */ 
    public static String generateUpperString(int length) { 
            return generateMixString(length).toUpperCase(); 
    } 

    /** 
     * ����һ�������Ĵ�0�ַ��� 
     * 
     * @param length �ַ������� 
     * @return ��0�ַ��� 
     */ 
    public static String generateZeroString(int length) { 
            StringBuffer sb = new StringBuffer(); 
            for (int i = 0; i < length; i++) { 
                    sb.append('0'); 
            } 
            return sb.toString(); 
    } 

    /** 
     * ������������һ���������ַ��������Ȳ���ǰ�油0 
     * 
     * @param num             ���� 
     * @param fixdlenth �ַ������� 
     * @return �������ַ��� 
     */ 
    public static String toFixdLengthString(long num, int fixdlenth) { 
            StringBuffer sb = new StringBuffer(); 
            String strNum = String.valueOf(num); 
            if (fixdlenth - strNum.length() >= 0) { 
                    sb.append(generateZeroString(fixdlenth - strNum.length())); 
            } else { 
                    throw new RuntimeException("������" + num + "ת��Ϊ����Ϊ"
+ fixdlenth + "���ַ��������쳣��"); 
            } 
            sb.append(strNum); 
            return sb.toString(); 
    } 

    /** 
     * ������������һ���������ַ��������Ȳ���ǰ�油0 
     * 
     * @param num             ���� 
     * @param fixdlenth �ַ������� 
     * @return �������ַ��� 
     */ 
    public static String toFixdLengthString(int num, int fixdlenth) { 
            StringBuffer sb = new StringBuffer(); 
            String strNum = String.valueOf(num); 
            if (fixdlenth - strNum.length() >= 0) { 
                    sb.append(generateZeroString(fixdlenth - strNum.length())); 
            } else { 
                    throw new RuntimeException("������" + num + "ת��Ϊ����Ϊ" + fixdlenth + "���ַ��������쳣��"); 
            } 
            sb.append(strNum); 
            return sb.toString(); 
    } 


}