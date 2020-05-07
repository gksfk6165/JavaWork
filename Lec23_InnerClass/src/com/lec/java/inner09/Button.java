package com.lec.java.inner09;

public class Button {

	String name;
	
	public Button(String name) {
		this.name = name;
	}
	
	// 클릭시 수행하는 리스너  제공
	// 리스너 인터페이스 : OnClickListener
	//         - 를릭시 동작 메소드 : onClick();
	// 장착 메소드 : setOnClickListener
	//---------------------------------------------------
	// 리스너 인터페이스
	public static interface OnClickListener{
		void OnClick();
	}
	// 장착 리스너
	private OnClickListener clickListener=null;
	// 리스너 장착 메소드
	public Button setOnClickListener(OnClickListener clickListener) {
		this.clickListener=clickListener;
		return this;
	}
	//----------------------------------------------
	public void actionClick() {
		System.out.println(name + " 버튼 클릭!");
		if(clickListener!=null) {
			clickListener.OnClick();
		}
		// TODO
		
	}
	
	
	// TODO
	// 더블클릭시 수행하는 리스너를  제공해보세요
	// 리스너 인터페이스 : OnDblClickListener
	//         - 더블를릭시 동작 메소드 : onDblClick();
	// 장착 메소드 : setOnDBlClickListener
	
	//---------------------------------------------------
	
	public static interface OnDblClickListener{
		void onDblClick();
	}
	private OnDblClickListener dblClickListener=null;
	
	public Button setOnDBlClickListener(OnDblClickListener dblClickListener) {
		this.dblClickListener=dblClickListener;
		return this;
	}

	//----------------------------------------------
	public void actionDblClick() {
		System.out.println(name + " 버튼 클릭!");
		if(dblClickListener!=null) {
			dblClickListener.onDblClick();
		}
		System.out.println(name + " 버튼 더블 클릭!");

	}
	
	
	
	
} // end class
