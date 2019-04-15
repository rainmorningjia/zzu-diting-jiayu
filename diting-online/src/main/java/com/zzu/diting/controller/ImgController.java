package com.zzu.diting.controller;

import com.zzu.diting.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/img")
public class ImgController {

	@RequestMapping("createImg")
	public void createImg(HttpSession session, HttpServletResponse response) throws IOException {
		CreateValidateCode cvc=new CreateValidateCode();
		String code=cvc.getCode();
		session.setAttribute("code", code);
		cvc.write(response.getOutputStream());
	}

}