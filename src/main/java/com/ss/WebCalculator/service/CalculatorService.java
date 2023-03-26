package com.ss.WebCalculator.service;

public class CalculatorService {
	public int addService(int t1, int t2) {
		return t1+t2;
	}
	public int subService(int t1, int t2) {
		return t1-t2;
	}
	public int mulService(int t1, int t2) {
		return t1*t2;
	}
	public int divService(int t1, int t2) {
		try {
		return t1/t2;
		}
		catch (Exception e) {
			System.out.println("Divide By Zero Exception");
			return 0;
		}
		
	}
	public int modService(int t1, int t2) {
		return t1%t2;
	}

}
