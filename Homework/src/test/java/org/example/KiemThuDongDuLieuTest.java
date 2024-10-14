package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KiemThuDongDuLieuTest {
    @Test
    public void test1(){
        var t1 = new MyCode();
        assertEquals(false, t1.ValidOrInvalid(null));
    }

    @Test
    public void test2(){
        var t2 = new MyCode();
        assertEquals(true, t2.ValidOrInvalid("12345678"));
    }

    @Test
    public void test3(){
        var t3 = new MyCode();
        assertEquals(false, t3.ValidOrInvalid("*1234567"));
    }

    @Test
    public void test4(){
        var t4 = new MyCode();
        assertEquals(false, t4.ValidOrInvalid("1*34567"));
    }
}