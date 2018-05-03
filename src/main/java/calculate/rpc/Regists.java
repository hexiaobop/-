package calculate.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Regists {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            String apiclassName = objectInputStream.readUTF();
            String methodName = objectInputStream.readUTF();
            Class[] parameterTypes = (Class[]) objectInputStream.readObject();
            Object[] paramArgs = (Object[]) objectInputStream.readObject();
            Class clz = null;
            if (apiclassName.equals(IProductService.class.getName())) {
                clz = ProductService.class;
            }
            Method method = clz.getMethod(methodName, parameterTypes);
            Object objject = method.invoke(clz.newInstance(), paramArgs);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(objject);
            objectOutputStream.flush();
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        }




    }
}
