package concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 10:12
 */
public class CatchCompletableExceptions {
    static void handleException(int failcount){
        //call the function only if there's an exception, must produce same type as came in:
        CompletableExceptions.test("exceptionally", failcount)
                .exceptionally((ex)->{
                    if(ex == null){
                        System.out.println("I don't get it yet");
                    }
                    return new Breakable(ex.getMessage(), 0);
                }).thenAccept(str-> System.out.println("result: "+str));

        //create a new result(recover)
        CompletableExceptions.test("handle", failcount)
                .handle((result, fail)->{
                    if(fail != null){
                        return "Failure recovery object";
                    }else{
                        return result + " is good";
                    }
                }).thenAccept(str-> System.out.println("result: "+str));

        //do something but pass the same result through
        CompletableExceptions.test("whenComplete", failcount)
                .whenComplete((result, fail)->
                {
                    if(fail!=null){
                        System.out.println("it failed");
                    }else{
                        System.out.println(result + "Ok");
                    }
                }).thenAccept(str-> System.out.println("result: "+str));
    }

    public static  void main(String[] args){
        System.out.println("**** Failure Mode ****");;
        handleException(2);
        System.out.println("**** Success Mode ****");;
        handleException(0);
    }

}
