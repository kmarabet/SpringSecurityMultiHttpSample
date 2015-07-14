package com.example.web.controller;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

	@Resource
	private Environment environment;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Multiple HTTP Spring Security annotation-based sample.");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();

		model.setViewName("index");

		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		//request.getSession().setAttribute("clusterName", cluster.getClusterName());
		model.setViewName("login");

		return model;
	}

	/**
	 * Process the logout Get request as the Post is processed by Spring security
	 * @see com.example.config.SecurityConfig
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGetProcess(final HttpServletRequest request) {

		request.getSession().invalidate();

		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/landing", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView landingPage(final HttpServletRequest req,
								  @RequestParam(value = "error", required = false) final String error) {

		ModelAndView model = new ModelAndView();

		if (error != null) {
			model.addObject("error", error);
		}

		String attributeName = req.getParameter("attributeName");
		String attributeValue = req.getParameter("attributeValue");
		if (attributeName != null && !attributeName.isEmpty())
			req.getSession().setAttribute(attributeName, attributeValue);

		model.setViewName("landing");

		return model;
	}

}