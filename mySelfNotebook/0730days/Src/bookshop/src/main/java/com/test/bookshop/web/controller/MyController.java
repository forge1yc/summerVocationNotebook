package com.test.bookshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// ������ǰ����һ����������
@Controller
public class MyController {
	
	// ���Ʒ��� - ��ͨ����
	// ����ע�� - �����ÿ��Ʒ����ķ��ʷ�ʽ&url
	@GetMapping("/index")
	public String test() {
		return "abc";			// �߼���ͼ��
	}
	

}
