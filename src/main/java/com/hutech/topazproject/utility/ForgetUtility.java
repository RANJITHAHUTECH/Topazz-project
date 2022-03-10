package com.hutech.topazproject.utility;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Component;

@Component
public class ForgetUtility {
	public static String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}
}
