package com.poly

class MyClass1 {
    public void method1() {…}

    private void method2() {…}

    void method3() {…}
}

class MyClass2 {
    void method() {
        MyClass1 o1 = new MyClass1();
        o1.method1();
        o1.method2();
        o1.method3();
    }
}