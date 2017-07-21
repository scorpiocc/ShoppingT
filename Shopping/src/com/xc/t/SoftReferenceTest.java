package com.xc.t;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceTest {
	private Object[] elememtData;
	private int capacityIncrement;
	public static void main(String[] args) {
		SoftReference<Person>[] people = new SoftReference[100];
		for(int i = 0 ; i < people.length ; i++){
			people[i] = new SoftReference<Person>(new Person("名字"+i,(i+1)*4%100));
		}
		System.out.println(people[2].get());
		System.out.println(people[98].get());
		
		System.gc();
		System.runFinalization();
		
		System.out.println(people[2].get());
		System.out.println(people[4].get());
		String s = new String("ssss");
		WeakReference<String> f = new WeakReference<String>(s);
		s = null;
		System.out.println(f.get());
		System.gc();
		System.runFinalization();
		System.out.println(f.get());
		
	}
	public SoftReferenceTest(int aaaa){
		elememtData =  new Object[aaaa];
	}
	public SoftReferenceTest(int aaaa,int capacityIncrement ){
		this(aaaa);
	}
}
