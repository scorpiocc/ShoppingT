package com.xc.t;

import com.xc.c.Adapater2;
import com.xc.c.Adaptee;
import com.xc.c.Adapter;
import com.xc.c.ConcreteTarget;
import com.xc.i.Target;

public class Client {
	public static void main(String[] args) {
		Target t =  new ConcreteTarget();
		t.request();
		
		Target ts = new Adapter();
		ts.request();
		
		
		Target ts2 = new Adapater2(new Adaptee());
		ts2.request();
		
	}
}	
