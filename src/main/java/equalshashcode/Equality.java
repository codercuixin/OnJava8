package equalshashcode;

import com.google.common.base.Objects;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 15:41
 */
public class Equality {
    protected int i;
    protected String s;
    protected double d;
    public Equality(int i, String s, double d){
        this.i = i;
        this.s = s;
        this.d = d;
        System.out.println("made 'Equality'");
    }

    @Override
    public boolean equals(Object rval) {
        if(rval == null){
            return false;
        }
        if(rval == this){
            return true;
        }
        if(!(rval instanceof  Equality)){
            return false;
        }
        Equality other = (Equality) rval;
        if(!Objects.equal(i, other.i)){
            return false;
        }
        if(!Objects.equal(s, other.s)){
            return false;
        }
        if(!Objects.equal(d, other.d)){
            return false;
        }
        return true;
    }

    public void test(String desc, String expected, Object rval){
        System.out.format("- - Testing %s - -%n"+ "%s instance Equality: %s%n"
        +"Expected %s, got %s%n",
                desc,rval, rval instanceof Equality, expected, equals(rval));
    }

    public static void testAll(EqualityFactory eqf){
        Equality e = eqf.make(1, "Monty", 3.14),
                eq = eqf.make(1, "Monty", 3.14),
                neq = eqf.make(99, "Bob", 1.618);
        e.test("null", "false", null);
        e.test("same object", "true", e);
        e.test("different type", "false", Integer.valueOf(99));
        e.test("same values", "true", eq);
        e.test("different values", "false", neq);
    }
    public static void main(String[] args){
        testAll(Equality::new);
    }
}
