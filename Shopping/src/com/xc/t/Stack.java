package com.xc.t;

public class Stack {
	private Object[] elementData;
	private int size = 0;
	private int capacityIncrement;
	
	public Stack(int initialCapacity){
		elementData  = new Object[initialCapacity];
	}
	public Stack(int initialCapacity,int capacityIncrement){
		this(initialCapacity);
		this.capacityIncrement = capacityIncrement;
	}
	//向"栈"顶压入一个元素
	public void push(Object object){
		ensureCapacity();
		elementData[size++] = object;
	}
	public Object pop(){
		if(size == 0){
			throw new RuntimeException("空栈异常");
		}
		Object ele = elementData[--size];
		elementData[size] = null;
		return ele;
	}
	public int size(){
		return size;
	}
	//保证底层数组能容纳栈内所有元素
	private void ensureCapacity(){
		//增加栈堆的容量
		if(elementData.length == size){
			Object[] oldElements = elementData;
			int newLength = 0;
			//已经设置capacityIncrement
			if(capacityIncrement > 0){
				newLength = elementData.length + capacityIncrement;
			}else{
				//将长度扩充到原来的1.5倍
				newLength = (int)(elementData.length * 1.5);
			}
			elementData = new Object[newLength];
			//将原数组的元素复制到新数组中
			System.arraycopy(oldElements, 0, elementData, 0, size);
		}
	}
	public static void main(String[] args) {
		Stack stack = new Stack(10);
		//向栈顶压入10个
		for(int i = 0; i < 10 ; i++){
			stack.push("元素"+i);
		}
		//依次弹出10个元素
		for(int i = 0;i < 10; i++){
			System.out.println(stack.pop());
		}
	}
}

