package com.ss.WebCalculator.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ss.WebCalculator.model.CalculatorModel;
import com.ss.WebCalculator.service.CalculatorService;
import com.ss.WebCalculator.view.CalculatorView;

@Controller
public class CalculatorController 
{
	CalculatorModel calculatorModel;
	CalculatorView calculatorView;
	CalculatorService calculatorService;
	
	public CalculatorController() {
		calculatorModel = new CalculatorModel();
		calculatorView = new CalculatorView();
		calculatorService = new CalculatorService();
	}
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) 
	{
		calculatorModel.setNum1(Integer.parseInt(request.getParameter("t1")));
		calculatorModel.setNum2(Integer.parseInt(request.getParameter("t2")));
		calculatorModel.setResult(calculatorService.addService(calculatorModel.getNum1(),calculatorModel.getNum2()));
		return calculatorView.displayResult(calculatorModel.getResult());
	}
	@RequestMapping("/sub")
	public ModelAndView sub(HttpServletRequest request, HttpServletResponse response) {
		calculatorModel.setNum1(Integer.parseInt(request.getParameter("t1")));
		calculatorModel.setNum2(Integer.parseInt(request.getParameter("t2")));
		calculatorModel.setResult(calculatorService.subService(calculatorModel.getNum1(),calculatorModel.getNum2()));
		return calculatorView.displayResult(calculatorModel.getResult());
	}
	@RequestMapping("/mul")
	public ModelAndView mul(HttpServletRequest request, HttpServletResponse response) {
		calculatorModel.setNum1(Integer.parseInt(request.getParameter("t1")));
		calculatorModel.setNum2(Integer.parseInt(request.getParameter("t2")));
		calculatorModel.setResult(calculatorService.mulService(calculatorModel.getNum1(),calculatorModel.getNum2()));
		return calculatorView.displayResult(calculatorModel.getResult());
	}
	@RequestMapping("/div")
	public ModelAndView div(HttpServletRequest request, HttpServletResponse response) {
		calculatorModel.setNum1(Integer.parseInt(request.getParameter("t1")));
		calculatorModel.setNum2(Integer.parseInt(request.getParameter("t2")));
		calculatorModel.setResult(calculatorService.divService(calculatorModel.getNum1(),calculatorModel.getNum2()));
		return calculatorView.displayResult(calculatorModel.getResult());
	}
	@RequestMapping("/mod")
	public ModelAndView mod(HttpServletRequest request, HttpServletResponse response) {
		calculatorModel.setNum1(Integer.parseInt(request.getParameter("t1")));
		calculatorModel.setNum2(Integer.parseInt(request.getParameter("t2")));
		calculatorModel.setResult(calculatorService.modService(calculatorModel.getNum1(),calculatorModel.getNum2()));
		return calculatorView.displayResult(calculatorModel.getResult());
	}
}

