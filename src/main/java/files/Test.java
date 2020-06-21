package files;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/9 14:06
 */
public class Test {
    public static void main(String[] args) {
        String[] originalBlack = {"10000018",
                "10000786",
                "10001075",
                "10001081",
                "80000012",
                "80000038",
                "80000063",
                "80000067",
                "80000068",
                "80000075",
                "80000123",
                "80000209",
                "80044819",
                "80054862",
                "80065837",
                "80066058",
                "80094717",
                "80102039",
                "80186938",
                "80202905",
                "80417743",
                "80437189",
                "80494392"};
        Set<String> currentBlackSet = new TreeSet<>(Arrays.asList(originalBlack));

        String[] needAddBlack = {"80084302",
                "80177284",
                "80186938",
                "80391646",
                "80205290",
                "80340732",
                "80351052",
                "80351596",
                "80116206",
                "80123643",
                "80134304",
                "80168531",
                "80170428",
                "80175145",
                "80002918",
                "80006669",
                "80179861"};
        currentBlackSet.addAll(Arrays.asList(needAddBlack));
        String[] needDeleteBlack = {"10001075",
                "80000038",
                "80000063",
                "80000209",
                "80044819",
                "80054862",
                "80065837",
                "80102039",
                "80186938",
                "80202905",
                "80417743",
                "80494392"};
        currentBlackSet.removeAll(Arrays.asList(needDeleteBlack));
        for (String s : currentBlackSet) {
            System.out.println(s);
        }
        System.out.println("CurrentBlackSize: "+currentBlackSet.size());
        System.out.println("***************");
        String[] compare = {
                "10000018","10000786","10001081","80000012","80000067","80000068","80000075","80000123","80002918",
                "80006669",
                "80066058",
                "80084302",
                "80094717",
                "80116206",
                "80123643",
                "80134304",
                "80168531",
                "80170428",
                "80175145",
                "80177284",
                "80179861",
                "80205290",
                "80340732",
                "80351052",
                "80351596",
                "80391646",
                "80437189",
        };
        for(String s: compare){
            if(!currentBlackSet.contains(s)){
                System.out.println(s+" isn't black");
                System.exit(1);
            }
        }
        if(compare.length != currentBlackSet.size()){
            System.out.println("currentBlackSet有遗漏");
        }
    }
}
