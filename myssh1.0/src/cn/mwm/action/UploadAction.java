package cn.mwm.action;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.mwm.pageModel.Json;
import cn.mwm.utils.UtilCommon;

public class UploadAction extends BaseAction {

	private File[] file;//�ϴ����ļ�
	private String[] fileFileName;//�ϴ����ļ�������
	private String[] fileContentType;//�ϴ����ļ�����
	
	private String newFileName;//����������ļ���
	@Override
	public String execute() throws Exception {
	   //�õ���ǰʱ�俪ʼ���ŵĺ�����,�������������Ϊ�ϴ��ļ��µ��ļ���
		long now=new Date().getTime();
		Json json=new Json();
		if( file!=null ){
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			String realPath=ServletActionContext.getServletContext().getRealPath("/upload");
			System.out.println("�ϴ��ļ�����·��Ϊ:"+realPath);
			File saveDir=new File(realPath);
			if(!saveDir.getParentFile().exists()){
				saveDir.getParentFile().mkdirs();
			}
			for (int i = 0; i < file.length; i++) {
				 System.out.println("�ļ�����" + fileFileName[i]);  
			     System.out.println("�ļ����ͣ�" + fileFileName[i]);
//				//�ļ��ĺ�׺  
	            String suffix = fileFileName[i].substring(fileFileName[i].lastIndexOf("."));  
//	            if (imageFileName[i].lastIndexOf(".") == -1) {  
//	                return INPUT;  
//	            }
//	            //�ϴ��Ժ�,���������ļ�������,��������Ϊȫ�������ֵ��ļ���,��ֹ���ܳ��ֵ�����.  
//	            //��Ȼ, ֻ��Ϊ�˷�ֹ��������,һ�㲻���������  
//	            newFileName = UUID.randomUUID() + suffix; 
	            int index=fileFileName[i].lastIndexOf(".");
	    		
	    		//�ж��ϴ��ļ��Ƿ�����չ��,��ʱ�����Ϊ�µ��ļ���
	    		if (index!=-1) {
	    			newFileName=now+fileFileName[i].substring(index);
	    		}else {
	    			newFileName=Long.toString(now);
	    		}
				File saveFile=new File(saveDir,newFileName);
				if(UtilCommon.checkIsImage(suffix)){
					FileUtils.copyFile(file[i], saveFile);
					json.setSuccess(true);
					json.setMsg("�ļ��ϴ��ɹ�");
					String imagUrl="upload/"+newFileName;
					System.out.println("ͼƬ·��=="+imagUrl);
					json.setObj(imagUrl);
					//this.getRequest().setAttribute("newFileName", "newFileName");
					//ActionContext.getContext().put("newFileName",newFileName);
				}else{
					json.setSuccess(true);
					json.setMsg("�ļ��ϴ�ʧ�ܣ��ļ���ʽ����Ϊ��jpg,jpeg,png��gif��ʽ!");
				}
			}
			super.writeJson(json);
		}
		return null;
	}
	public String uploadFile() {
//		String extName = ""; // �����ļ���չ��
//		String newFileName = ""; // �����µ��ļ���
//		String nowTimeStr = ""; // ���浱ǰʱ��
//		SimpleDateFormat sDateFormat;
//		Random r = new Random();
//		String savePath = ServletActionContext.getServletContext().getRealPath("/upload/userImg"); // ��ȡ��Ŀ��·��
//		//HttpServletResponse response = ServletActionContext.getResponse();
//		// ��������ļ�������ǰ������ʱ����+��λ�������Ϊ����ʵ����Ŀ�з�ֹ�ļ�ͬ�������еĴ���
//		int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // ��ȡ�����
//		sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // ʱ���ʽ���ĸ�ʽ
//		nowTimeStr = sDateFormat.format(new Date()); // ��ǰʱ��
//		// ��ȡ��չ��
//		if (fileuploadFileName.lastIndexOf(".") >= 0) {
//			extName = fileuploadFileName.substring(fileuploadFileName
//					.lastIndexOf("."));
//		}
//		try {
//			newFileName = nowTimeStr + rannum + extName; // �ļ��������������
//			String filePath = savePath + newFileName;
//			// ����ϴ����Ƿ���ͼƬ
//			if (UtilCommon.checkIsImage(extName)) {
//				FileUtils.copyFile(fileupload, new File(filePath));
//			} else {
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return null;
	}
	public File[] getFile() {
		return file;
	}
	public void setFile(File[] file) {
		this.file = file;
	}
	public String[] getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String[] getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}



}
