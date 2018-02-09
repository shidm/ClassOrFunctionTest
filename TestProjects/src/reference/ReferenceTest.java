package reference;

import javafx.beans.binding.ObjectExpression;

import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args) {

        /*
        * 若将弱引用或软引用get()后的对象让另一变量关联（引用）则其又会变成强引用
        * */

        MyTestClass t = new MyTestClass(1);
        WeakReference weakReference = new WeakReference<>(t);
        t = new MyTestClass(2);
        WeakReference weakReference2 = new WeakReference<>(t);
        t = null;
        MyTestClass testClass = (MyTestClass) weakReference.get();
        System.out.println("before gc:" + "\n"
                + "testClass:" + testClass.toString()
                + "\n" + "weakReference:" + weakReference.get().toString()
                + "\n" + "weakReference2:" + weakReference2.get().toString());
        System.gc();
        System.out.println("after gc" + "\n"
                + "testClass:" + testClass.toString()
                + "\n" + "weakReference:" + weakReference.get().toString()
                + "\n" + "weakReference2:" + weakReference2.get().toString() == null ? "clear":weakReference2.get().toString());
    }
}
