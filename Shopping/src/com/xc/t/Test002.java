package com.xc.t;

import java.io.Serializable;
import java.util.Random;

public class Test002 {
	private static Random random = new Random(47);
	public static void main(String[] args) {
		
		
	 Data[] d = {
				new Data(random.nextInt(10)),
				new Data(random.nextInt(10)),
				new Data(random.nextInt(10))
		};
	 for (Data data : d) {
		System.out.println(data);
	}
		
	}
	
}
class Data implements Serializable {
    private static final long serialVersionUID = 7247714666080613254L;
    public int n;
    public Data(int n) {
        this.n = n;
    }
    public String toString(){
        return Integer.toString(n);
    }
}