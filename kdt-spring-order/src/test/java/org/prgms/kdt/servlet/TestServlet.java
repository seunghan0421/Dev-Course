package org.prgms.kdt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestServlet extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(TestServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String requestURI = req.getRequestURI();
		log.info("Got Request from : {}", requestURI);

		final PrintWriter writer = resp.getWriter();
		writer.println("Hello Servlet! ");
		super.doGet(req, resp);
	}
}
