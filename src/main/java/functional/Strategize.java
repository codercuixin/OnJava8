package functional;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 14:52
 */
interface Strategy {
    String approach(String msg);
}
class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase()+"?";
    }
}
class Unrelated{
    static String twice(String msg){
        return msg +" " + msg;
    }
}
public class Strategize {
    Strategy starategy;
    String msg;

    Strategize(String msg){
        starategy = new Soft();
        this.msg = msg;
    }
    void communicate(){
        System.out.println(starategy.approach(msg));
    }
    void changeStrategy(Strategy starategy){
        this.starategy = starategy;
    }

    public static void main(String[] args){
        Strategy[] strategies = {
                new Strategy(){
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase()+"!";
                    }
                },
                msg -> msg.substring(0,5),
                Unrelated::twice
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();
        for(Strategy strategy: strategies ){
            s.changeStrategy(strategy);
            s.communicate();
        }
    }

}
