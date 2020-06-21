package equalshashcode;

import com.google.common.base.Objects;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 15:55
 */
public class SuccinctEquality extends Equality{
    public SuccinctEquality(int i, String s, double d){
        super(i, s, d);
        System.out.println("made 'SuccinctEquality'");
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof SuccinctEquality
                && Objects.equal(i, ((SuccinctEquality)rval).i)
                && Objects.equal(s, ((SuccinctEquality)rval).s)
                && Objects.equal(d, ((SuccinctEquality)rval).d);
    }

    public static void main(String[] args){
        System.out.println(null instanceof SuccinctEquality);
        Equality.testAll((i, s, d)-> new SuccinctEquality(i, s, d));
    }
}
