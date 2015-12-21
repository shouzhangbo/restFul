package com.my.spring.ctrl;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.spring.form.UserInfo;

@Controller
@RequestMapping("/userinfo")
public class TestCtrl {
	
	@RequestMapping(value="/new")
	public ModelAndView _new(HttpServletRequest request,HttpServletResponse response,UserInfo userInfo)
			throws Exception{
		return new ModelAndView("/userinfo/new","userInfo",userInfo);
	}
	
	@RequestMapping(value="/test")
	@ResponseBody
	public Map<String,Object> test(HttpServletRequest request,HttpServletResponse response,UserInfo userInfo)
			throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ddd", "testtttt");
		return map;
	}
}
