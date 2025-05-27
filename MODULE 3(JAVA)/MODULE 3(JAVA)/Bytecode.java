public class Bytecode {
    public int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        Example e = new Example();
        System.out.println(e.square(5));
    }
}