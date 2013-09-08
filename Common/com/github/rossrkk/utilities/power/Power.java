package com.github.rossrkk.utilities.power;

public interface Power {
	//return the power level
	public int getPower();
	
	//inecrement the power power stored by count
	//should return any power that doesn't fit
	public int incrementPower(int count);
	
	//is this block a power source
	public boolean isGenerator();
}
