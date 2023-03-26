package com.ss.WebCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ss.WebCalculator.model.CalculatorModel;
import com.ss.WebCalculator.service.CalculatorService;

public class CalculatorTest {
	@Test
	public void testAdd() {
		CalculatorModel calculatorModel = new CalculatorModel();
		CalculatorService calculatorService = new CalculatorService();
		
		calculatorModel.setNum1(10);
		calculatorModel.setNum2(20);
		
		assertEquals(30, calculatorService.addService(calculatorModel.getNum1(),calculatorModel.getNum2()));
	}

	@Test
	public void testSub() {
		CalculatorModel calculatorModel = new CalculatorModel();
		CalculatorService calculatorService = new CalculatorService();
		
		calculatorModel.setNum1(10);
		calculatorModel.setNum2(20);
		assertEquals(-10, calculatorService.subService(calculatorModel.getNum1(),calculatorModel.getNum2()));
	}
	@Test
	public void testMul() {
		CalculatorModel calculatorModel = new CalculatorModel();
		CalculatorService calculatorService = new CalculatorService();
		
		calculatorModel.setNum1(10);
		calculatorModel.setNum2(20);
		assertEquals(200, calculatorService.mulService(calculatorModel.getNum1(),calculatorModel.getNum2()));
	}
	@Test
	public void testDiv() {
		CalculatorModel calculatorModel = new CalculatorModel();
		CalculatorService calculatorService = new CalculatorService();
		
		calculatorModel.setNum1(20);
		calculatorModel.setNum2(10);
		assertEquals(2, calculatorService.divService(calculatorModel.getNum1(),calculatorModel.getNum2()));
	}
	@Test
	public void testMod() {
		CalculatorModel calculatorModel = new CalculatorModel();
		CalculatorService calculatorService = new CalculatorService();
		
		calculatorModel.setNum1(20);
		calculatorModel.setNum2(10);
		assertEquals(0, calculatorService.modService(calculatorModel.getNum1(),calculatorModel.getNum2()));
	}

}
