package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class KiemThuDongDieuKhienTest {

    @Test
    public void test1 (){
        var t1 = new MyCode();
        assertEquals(false, t1.ValidOrInvalid(null));
    }

    @Test
    public void test2 (){
        var t2= new MyCode();
        assertEquals(false, t2.ValidOrInvalid("*1234567"));
    }

    @Test
    public void test3 (){
        var t3= new MyCode();
        assertEquals(true, t3.ValidOrInvalid("12345678"));
    }

    @Test
    public void test5 (){
        var t5 = new MyCode();
        assertEquals(false, t5.ValidOrInvalid("1*234567"));
    }

    @Test
    public void test6 (){
        var t6= new MyCode();
        assertEquals(false, t6.ValidOrInvalid("12*34567"));
    }

    @Test
    public void test7 (){
        var t7= new MyCode();
        assertEquals(false, t7.ValidOrInvalid("1234*567"));
    }
}