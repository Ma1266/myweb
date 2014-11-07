package cn.mwm.utils;

import java.util.Random;
import java.util.UUID;

public class RandomTool {
	
	//产生一个a到b的随机数
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
	
	//不要研究不重复的随机数，意义不大。
	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    public static final String numberChar = "0123456789"; 

    /** 
     * 返回一个定长的随机字符串(只包含大小写字母、数字) 
     * 
     * @param length 随机字符串长度 
     * @return 随机字符串 
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
     * 返回一个定长的随机纯字母字符串(只包含大小写字母) 
     * 
     * @param length 随机字符串长度 
     * @return 随机字符串 
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
     * 返回一个定长的随机纯大写字母字符串(只包含大小写字母) 
     * 
     * @param length 随机字符串长度 
     * @return 随机字符串 
     */ 
    public static String generateLowerString(int length) { 
            return generateMixString(length).toLowerCase(); 
    } 

    /** 
     * 返回一个定长的随机纯小写字母字符串(只包含大小写字母) 
     * 
     * @param length 随机字符串长度 
     * @return 随机字符串 
     */ 
    public static String generateUpperString(int length) { 
            return generateMixString(length).toUpperCase(); 
    } 

    /** 
     * 生成一个定长的纯0字符串 
     * 
     * @param length 字符串长度 
     * @return 纯0字符串 
     */ 
    public static String generateZeroString(int length) { 
            StringBuffer sb = new StringBuffer(); 
            for (int i = 0; i < length; i++) { 
                    sb.append('0'); 
            } 
            return sb.toString(); 
    } 

    /** 
     * 根据数字生成一个定长的字符串，长度不够前面补0 
     * 
     * @param num             数字 
     * @param fixdlenth 字符串长度 
     * @return 定长的字符串 
     */ 
    public static String toFixdLengthString(long num, int fixdlenth) { 
            StringBuffer sb = new StringBuffer(); 
            String strNum = String.valueOf(num); 
            if (fixdlenth - strNum.length() >= 0) { 
                    sb.append(generateZeroString(fixdlenth - strNum.length())); 
            } else { 
                    throw new RuntimeException("将数字" + num + "转化为长度为"
+ fixdlenth + "的字符串发生异常！"); 
            } 
            sb.append(strNum); 
            return sb.toString(); 
    } 

    /** 
     * 根据数字生成一个定长的字符串，长度不够前面补0 
     * 
     * @param num             数字 
     * @param fixdlenth 字符串长度 
     * @return 定长的字符串 
     */ 
    public static String toFixdLengthString(int num, int fixdlenth) { 
            StringBuffer sb = new StringBuffer(); 
            String strNum = String.valueOf(num); 
            if (fixdlenth - strNum.length() >= 0) { 
                    sb.append(generateZeroString(fixdlenth - strNum.length())); 
            } else { 
                    throw new RuntimeException("将数字" + num + "转化为长度为" + fixdlenth + "的字符串发生异常！"); 
            } 
            sb.append(strNum); 
            return sb.toString(); 
    } 


}