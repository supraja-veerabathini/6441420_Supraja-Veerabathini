import java.lang.reflect.*;
public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Sample");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("Method: " + method.getName() + "(");
            Class<?>[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getSimpleName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method greetMethod = clazz.getDeclaredMethod("greet", String.class);
        Object result = greetMethod.invoke(obj, "Alice");
        System.out.println("Invocation result: " + result);
    }
}
class Sample {
    public String greet(String name) {
        return "Hello, " + name;
    }
      private void secret() {
        System.out.println("Secret method");
    }
}
