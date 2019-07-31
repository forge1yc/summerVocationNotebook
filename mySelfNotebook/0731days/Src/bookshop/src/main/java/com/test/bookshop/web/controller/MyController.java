package com.test.bookshop.web.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;

// ������ǰ����һ����������
@Controller
public class MyController {
	
	// ���Ʒ��� - ��ͨ����
	// ����ע�� - �����ÿ��Ʒ����ķ��ʷ�ʽ&url
	@GetMapping("/index")
	public ModelAndView test(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:index.jsp");	// ������ͼ��Ϊָ��ת����ת�� jsp ҳ��
		return mv;
	}
//	public String test() {
////		return "abc";			// �߼���ͼ��
//		return "redirect:rootabc.jsp";		// ת����ת�� jsp ҳ��
//	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(String usn, MultipartFile file, HttpServletRequest request) throws Exception{
		System.out.println(usn);
		String contentType = file.getContentType();
		String name = file.getName();
		String oname = file.getOriginalFilename();
		long size = file.getSize();
		//InputStream is = file.getInputStream();
//		String filename = MyController.class.getClassLoader()+System.currentTimeMillis() + ".jpg";
		String path = request.getServletContext().getRealPath("/");
//		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filename));
		return "";

	}

}
