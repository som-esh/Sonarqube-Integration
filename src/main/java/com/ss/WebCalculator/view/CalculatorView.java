package com.ss.WebCalculator.view;

import org.springframework.web.servlet.ModelAndView;

public class CalculatorView {
	public ModelAndView displayResult(int res) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display.jsp");
		modelAndView.addObject("result", res);
		return modelAndView;
	}
}
