package cz.MyTest.TestJava;
import java.io.Serializable;

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }


    // Aby jsme nezničili Singleton vzor !!!
    protected Object readResolve() {
        return getInstance();
    }

}