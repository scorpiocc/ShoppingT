package com.xc.c;

import com.xc.i.Target;

public class Adapter extends Adaptee implements Target{

	@Override
	public void request() {
		super.speciicRequest();
	}
	
}
