package com.xc.c;

import com.xc.i.Target;

public class Adapater2 implements Target {
	private Adaptee adaptee;
	
	public Adapater2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		System.out.println("1111");
		this.adaptee.speciicRequest();
		System.out.println("2222");
		adaptee.speciicRequest();
	}
	
}
