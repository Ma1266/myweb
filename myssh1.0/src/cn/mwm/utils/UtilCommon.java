package cn.mwm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilCommon {
	 public static String getSerial(Date date, int index) {  
	        long msel = date.getTime();  
	        SimpleDateFormat fm = new SimpleDateFormat("MMddyyyyHHmmssSS");  
	        msel += index;  
	        date.setTime(msel);  
	        String serials = fm.format(date);  
	        return serials;  
	    }  
	    // ����Ƿ���ͼƬ��ʽ  
	    public static boolean checkIsImage(String imgStr) {  
	        boolean flag = false;  
	        if (imgStr != null) {  
	            if (imgStr.equalsIgnoreCase(".gif")  
	                    || imgStr.equalsIgnoreCase(".jpg")  
	                    || imgStr.equalsIgnoreCase(".jpeg")  
	                    || imgStr.equalsIgnoreCase(".png")) {  
	                flag = true;  
	            }  
	        }  
	        return flag;  
	    }  
}
