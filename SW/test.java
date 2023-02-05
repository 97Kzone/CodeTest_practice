import java.util.ArrayList;

abstract class SC {
    String x = "Super";

    public void m1() {
        System.out.println("sc1");
    };

    abstract public void m2();
}

class C extends SC {
    String grade = "Sub";

    public void m2() {
        System.out.println("c2");
    };
}
public class test {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
    }
}