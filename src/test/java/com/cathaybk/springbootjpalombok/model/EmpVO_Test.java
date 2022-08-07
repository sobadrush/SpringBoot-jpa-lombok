package com.cathaybk.springbootjpalombok.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class EmpVO_Test {

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        System.err.println(String.format(" ======== %s Starting ======== ",testInfo.getDisplayName()));
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.err.println(String.format(" ======== %s finished ======== ",testInfo.getDisplayName()));
    }

    @Test
    @Disabled
    public void test_001(){
        // 測試：@RequiredArgsConstructor
        // EmpVO empVO =／ntln("empVO = " + empVO);
    }

    @Test
    @Disabled
    public void test_002(){
        // 測試：@RequiredArgsConstructor 使用 staticName 完成「靜態工廠方法」
        EmpVO empVO = EmpVO.getInstance("NT89739", "Roger Lo");
        System.out.println("empVO = " + empVO);
    }

}
