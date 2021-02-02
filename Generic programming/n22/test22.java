package n22;

import java.io.FileNotFoundException;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class test22 {

    public static <V,T extends Exception> V doWork(Callable<V> c, T ex) throws T {
        try{
            return c.call();
        }catch (Throwable realEx){
            ex.initCause(realEx);
            throw ex;
        }
    }

    public static <V, T extends Throwable> V doWork2(Callable<V> c, Function<Throwable, T> constructor) throws T {
        try {
            return c.call();
        } catch (Throwable ex) {
            throw constructor.apply(ex);
        }
    }

    public static void main(String[] args) throws Throwable {
      //  doWork(()->{ throw new IllegalArgumentException();},new Exception());
        doWork2(()->{ throw new IllegalArgumentException();},Throwable::new);
    }
}
