package statistics;

public class OuterClass {
    String s = "hello";

    public static class InnerClass {
        private String s;
        InnerClass(String str) { s = str; }
        public void print() { System.out.println(s); }
    }
    public void print() { System.out.println(s); }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        InnerClass ic = new InnerClass("Rach");
        oc.print();
        ic.print();
    }
}
