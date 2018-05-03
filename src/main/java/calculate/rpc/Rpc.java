package calculate.rpc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Rpc {


    public static Object getProxyObject(final Class clz, final Class targetClass) throws IOException {

        return Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("127.0.0.1", 8888);


                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(clz.getName());
                objectOutputStream.writeUTF(method.getName());
                objectOutputStream.writeObject(method.getParameterTypes());
                objectOutputStream.writeObject(args);
                objectOutputStream.flush();

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Object o = objectInputStream.readObject();
                objectInputStream.close();
                objectOutputStream.close();
                socket.close();
                return o;
            }
        });
    }

    public static Object getCglibProxy(final Class clz) {
        Enhancer enhancer = new Enhancer();
        //设置需要创建子类的类
        enhancer.setSuperclass(clz);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Socket socket = new Socket("127.0.0.1", 8888);


                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(clz.getName());
                objectOutputStream.writeUTF(method.getName());
                objectOutputStream.writeObject(method.getParameterTypes());
                objectOutputStream.writeObject(objects);
                objectOutputStream.flush();

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Object o1 = objectInputStream.readObject();
                objectInputStream.close();
                objectOutputStream.close();
                socket.close();
                return o1;
            }
        });
        //通过字节码技术动态创建子类实例
        return enhancer.create();

    }

    public static void main(String[] args) throws IOException {
        IProductService productService = (IProductService) getCglibProxy(IProductService.class);
        System.out.println(productService.queryById().toString());
    }


}
