/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.controller;

import com.ibm.nlc.naturalLangClasUsecase2;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/WatsonNaturalLangClassifier" })
public class watsonControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, String> hm = null;

	public void init() throws ServletException {
		this.hm = new HashMap();
		this.hm.put("flag", "false");
		this.hm.put("Entity", "");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Question = request.getParameter("inputQuestion").trim();
		naturalLangClasUsecase2 obj = new naturalLangClasUsecase2();
		String output = null;
		try {
			output = obj.nlc(Question, this.hm);
			response.setContentType("text/html");
			response.getWriter().print(output);
		} catch (Exception e) {
			System.out.println("here");
			e.printStackTrace();
			response.getWriter().print("");
		}
	}
}