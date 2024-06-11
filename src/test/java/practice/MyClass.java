package practice;

public class MyClass extends Test7 {

	public static void main(String[] args) {
		//here with in class object
		/*Test7 t=new Test7();
		t.x=50;//here x is public can acees other class and other package with same project only
		//m.w=60; // here w is private can access with in class only not oher classes
		t.y=60; // heree y is protected can acess other class 
		t.z=70;// default is acees other class*/
		MyClass m=new MyClass();// child class
		m.x=20;// here x is  public can acees through child class also
		m.y=30;// here y is protected cann acces through child class also
		m.z=40;// same

	}

}
