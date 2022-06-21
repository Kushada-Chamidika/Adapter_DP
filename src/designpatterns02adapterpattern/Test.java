package designpatterns02adapterpattern;

interface A {

    public abstract void m();
}

class A1 implements A {

    @Override
    public void m() {
        System.out.println("A1 m");
    }
}

interface B {

    public abstract void n();
}

class B1 implements B {

    @Override
    public void n() {
        System.out.println("B1 n");
    }
}

class X {

    A a;

    public void x() {
        a.m();
    }
}

class Adapter implements A {

    B b;

    @Override
    public void m() {
        b.n();
    }

}

public class Test {

    public static void main(String[] args) {
        A1 a1 = new A1();
        B1 b1 = new B1();

        X x1 = new X();
        x1.a = a1;
        x1.x();

        Adapter adapter = new Adapter();
        adapter.b = b1;

        x1.a = adapter;
        x1.x();
    }
}
