package tw.com.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tw.com.tools.UploadFile;
import tw.com.web.tools.Utils;
//@MultipartConfig 表示此Servlet可上傳
@MultipartConfig
@WebServlet("/upload")
public class UploadServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		//Model–View–Controller
		
		//Model(模型) 商業邏輯 不專屬於任何一個平台
		//View 顯示 web而言就是JSP HTML....
		//Controller 控制流程 javaee 使用Servlet
		 Part part =  req.getPart("photo");
		 String fileName = part.getSubmittedFileName();
		 InputStream inputStr = part.getInputStream();
		 //System.out.println();
		 UploadFile.uploadFile(Utils.getImagePath(), 
				 fileName, inputStr);
		 
		 resp.sendRedirect("view_images");
		 
	}
}
