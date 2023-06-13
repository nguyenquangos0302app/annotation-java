package proxy;

import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class LoggingProxy {

    public static void main(String[] args) {

        Set<String> targetSet = new HashSet<>();

        Object proxy = Proxy.newProxyInstance(
                LoggingProxy.class.getClassLoader(),
                new Class[]{Set.class},
                new LoggingInvocationHandler(targetSet));

        Set<String> loggedSet = (Set<String>) proxy;
        loggedSet.add("item");

        System.out.println(targetSet.contains("item"));
    }

}
