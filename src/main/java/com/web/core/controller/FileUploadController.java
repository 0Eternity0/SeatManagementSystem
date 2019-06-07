package com.web.core.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 * @author TW
 * @version V1.0 
 */
@Controller
public class FileUploadController {
	@RequestMapping(value="/{formName}")
	 public String loginForm(@PathVariable String formName) {
		// 动态跳转页面
		return formName;
	}

	//上传文件会自动绑定到MultipartFile中
	 @RequestMapping(value="/upload",method=RequestMethod.POST)
	 public String upload(HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws Exception {
		
		String s = request.getParameter("uid");
		String ss = request.getParameter("uid1");
	    System.out.println("图片名称:"+s+" "+ss);
		 //如果文件不为空，写入上传路径
		if(!file.isEmpty()) {

			String path = request.getServletContext().getRealPath("/loaded/");
			System.out.println("路径:"+path);

			String filename = file.getOriginalFilename();
			System.out.println("文件名称:"+filename);
		    File filepath = new File(path,filename);

	        if (!filepath.getParentFile().exists()) { 
	        	filepath.getParentFile().mkdirs();
	        }

			file.transferTo(new File(path + File.separator + filename));
			
			System.out.println("成功上传");
			return "success";
		}
		return null;
	 }
	 
	 @RequestMapping(value="/download")
	 public ResponseEntity<byte[]> download(HttpServletRequest request,
			 @RequestParam("filename") String filename,
			 Model model)throws Exception {

		String path = request.getServletContext().getRealPath("/images/");
		File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();  

        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");

        headers.setContentDispositionFormData("attachment", downloadFielName); 

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED);  
	 }

}