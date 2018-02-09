package reference;

public class MyTestClass {

    private int s;

    public MyTestClass(int s) {
        this.s = s;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize:"+s);
        super.finalize();
    }

    @Override
    public String toString() {
        return "MyTestClass";
    }
}
