package com.xc.c;

import com.xc.i.Target;

public class ConcreteTarget implements Target{

	@Override
	public void request() {
		System.out.println("普通适配器...");
		
	}

}
