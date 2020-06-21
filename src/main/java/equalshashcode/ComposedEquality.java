package equalshashcode;

import com.google.common.base.Objects;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 16:01
 */
public class ComposedEquality extends SuccinctEquality {
    Part part;
    public ComposedEquality(int i, String s, double d) {
        super(i, s, d);
        part = new Part(s, d);
        System.out.println("made 'ComposedEquality'");
    }

    @Override
    public boolean equals(Object rval) {
        return  rval instanceof ComposedEquality
                && super.equals(rval)
                && Objects.equal(this.part, ((ComposedEquality)rval).part);
    }
    public static void main(String[] args){
        Equality.testAll((i,s,d)-> new ComposedEquality(i, s,d));
    }
}
class Part{
    String ss;
    double dd;
    Part(String ss, double dd){
        this.ss = ss;
        this.dd = dd;
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof Part
                &&  Objects.equal(this.ss, ((Part)rval).ss)
                &&  Objects.equal(this.dd, ((Part)rval).dd);
    }
}
