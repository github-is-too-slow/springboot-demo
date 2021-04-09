package com.billion.boot;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Billion
 * @create 2021/03/25 17:31
 */
//@ExtendWith(SpringExtension.class)
@DisplayName("Junit5单元测试")
public class MyJTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void BeforeEach1(){
        System.out.println("before开始执行");
    }
    @BeforeAll
    static public void beforeAll(){
        System.out.println("beforeAll开始执行");
    }
    @AfterEach
    public void aftereach(){
        System.out.println("after开始执行");
    }
    @AfterAll
    static public void afterAll(){
        System.out.println("afterAll开始执行");
    }

    @DisplayName("简单断言")
    @Test
    public void test01(){
        assertEquals(12, 11);
    }

    @Test
    @Disabled
    public void test02(){
        assertNotEquals(12, 11);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void test03() throws InterruptedException {
        Thread.sleep(600);
    }

    @Test
    @RepeatedTest(5)
    public void test04(){
        System.out.println("12");
    }

    @Test
    public void test05(){
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertSame(obj1, obj2);
    }

    @Test
    public void test06(){
        assertArrayEquals(new int[]{1, 2}, new int[]{2, 1});
    }

    @Test
    public void test07(){
        assertAll("组合测试没通过", () -> {
            assertEquals(11, 11);
        }, () -> {
            assertNotEquals(11, 12);
        });
    }

    @Test
    public void test08(){
        assertThrows(ArithmeticException.class, () -> {
            System.out.println("hahha");
        }, "竟然没异常");
    }

    @Test
    public void test09(){
        System.out.println("hahh");
        System.out.println("hahh");
        System.out.println("hahh");
        System.out.println("hahh");
        fail("快速失败");
    }

    @Test
    public void test10(){
        Assumptions.assumeTrue(false, "断言失败");
        System.out.println("hahhaha");
    }
}
