package no.hib.mums.partmaker.ui;
class A {
	protected String lol = "lol";
}
class B extends A {
	public B() {
		super();
		System.out.println(super.lol);
		super.lol = "bleh";
		System.out.println(super.lol);
	}
}
class C {
	public C() {
		A a = new A();
		System.out.println(a.lol);
		a.lol = "bah";
		System.out.println(a.lol);
	}
}
public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
	}

}
