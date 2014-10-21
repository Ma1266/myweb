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

	private File[] file;//上传的文件
	private String[] fileFileName;//上传的文件的名称
	private String[] fileContentType;//上传的文件类型
	
	private String newFileName;//重命名后的文件名
	@Override
	public String execute() throws Exception {
	   //得到当前时间开始流逝的毫秒数,将这个毫秒数作为上传文件新的文件名
		long now=new Date().getTime();
		Json json=new Json();
		if( file!=null ){
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			String realPath=ServletActionContext.getServletContext().getRealPath("/upload");
			System.out.println("上传文件保存路径为:"+realPath);
			File saveDir=new File(realPath);
			if(!saveDir.getParentFile().exists()){
				saveDir.getParentFile().mkdirs();
			}
			for (int i = 0; i < file.length; i++) {
				 System.out.println("文件名：" + fileFileName[i]);  
			     System.out.println("文件类型：" + fileFileName[i]);
//				//文件的后缀  
	            String suffix = fileFileName[i].substring(fileFileName[i].lastIndexOf("."));  
//	            if (imageFileName[i].lastIndexOf(".") == -1) {  
//	                return INPUT;  
//	            }
//	            //上传以后,会重命名文件的名称,将其命名为全部是数字的文件名,防止可能出现的乱码.  
//	            //当然, 只是为了防止出现乱码,一般不会出现乱码  
//	            newFileName = UUID.randomUUID() + suffix; 
	            int index=fileFileName[i].lastIndexOf(".");
	    		
	    		//判断上传文件是否有扩展名,以时间戳作为新的文件名
	    		if (index!=-1) {
	    			newFileName=now+fileFileName[i].substring(index);
	    		}else {
	    			newFileName=Long.toString(now);
	    		}
				File saveFile=new File(saveDir,newFileName);
				if(UtilCommon.checkIsImage(suffix)){
					FileUtils.copyFile(file[i], saveFile);
					json.setSuccess(true);
					json.setMsg("文件上传成功");
					String imagUrl="upload/"+newFileName;
					System.out.println("图片路径=="+imagUrl);
					json.setObj(imagUrl);
					//this.getRequest().setAttribute("newFileName", "newFileName");
					//ActionContext.getContext().put("newFileName",newFileName);
				}else{
					json.setSuccess(true);
					json.setMsg("文件上传失败！文件格式必须为：jpg,jpeg,png和gif格式!");
				}
			}
			super.writeJson(json);
		}
		return null;
	}
	public String uploadFile() {
//		String extName = ""; // 保存文件拓展名
//		String newFileName = ""; // 保存新的文件名
//		String nowTimeStr = ""; // 保存当前时间
//		SimpleDateFormat sDateFormat;
//		Random r = new Random();
//		String savePath = ServletActionContext.getServletContext().getRealPath("/upload/userImg"); // 获取项目根路径
//		//HttpServletResponse response = ServletActionContext.getResponse();
//		// 生成随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）
//		int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数
//		sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // 时间格式化的格式
//		nowTimeStr = sDateFormat.format(new Date()); // 当前时间
//		// 获取拓展名
//		if (fileuploadFileName.lastIndexOf(".") >= 0) {
//			extName = fileuploadFileName.substring(fileuploadFileName
//					.lastIndexOf("."));
//		}
//		try {
//			newFileName = nowTimeStr + rannum + extName; // 文件重命名后的名字
//			String filePath = savePath + newFileName;
//			// 检查上传的是否是图片
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
