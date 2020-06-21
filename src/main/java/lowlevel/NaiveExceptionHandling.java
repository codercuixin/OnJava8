package lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 15:34
 */
public class NaiveExceptionHandling {
    public static void main(String[] args){
        ExecutorService es = Executors.newCachedThreadPool();
        try {
            es.execute(new ExceptionThread());
        }catch (RuntimeException ue){
            //This statement will NOT execute!
            System.out.println("Exception was handled");
        }
        finally {
            es.shutdown();
        }
    }
}
