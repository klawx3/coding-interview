package cl.klawx3;

import org.junit.Test;

public class AnotherTesting {

    @Test
    public void testo(){
        int val = 4248;

        int a , b , c, d;

        d = val % 10;
        c = val / 10 % 10;
        b = val / 100 % 10;
        a = val / 1000 % 10;

        System.out.print(a);
        System.out.print(b);
        System.out.print(c);
        System.out.println(d);
    }
    
}
