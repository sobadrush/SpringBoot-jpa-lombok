package com.cathaybk.springbootjpalombok.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeptVO_Test {

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
        // 測試 ＠ToString + 主動 ＠Override toString()
        DeptVO deptVO_1 = DeptVO.builder().deptId(101).deptName("金城武").build();
        System.out.println("deptVO_1 = " + deptVO_1);
    }

    @Test
    @Disabled
    public void test_002(){
        // 測試  @EqualsAndHashCode + 主動 ＠Override @equals + @hashCode
        DeptVO deptVO_1 = DeptVO.builder().deptId(101).deptName("金城武").build();
        DeptVO deptVO_2 = DeptVO.builder().deptId(101).deptName("億載金城武").build();
        System.out.println("deptVO_1 equals deptVO_2 ??? " + deptVO_1.equals(deptVO_2));
    }

    @Test
    @Disabled
    public void test_003(){
        // 測試  @EqualsAndHashCode + 主動 ＠Override @equals + @hashCode
        DeptVO deptVO_1 = DeptVO.builder().deptId(101).deptName("金城武").build();
        DeptVO deptVO_2 = DeptVO.builder().deptId(102).deptName("億載金城武").build();
        Map<Integer, DeptVO> deptMap = Stream.of(deptVO_1, deptVO_2).collect(
                Collectors.toMap(DeptVO::getDeptId, Function.identity()));
        System.out.println("deptMap = " + deptMap);
    }

    @Test
    @Disabled
    public void test_004(){
        // 測試 Collectors.toMap key 重複(java.lang.IllegalStateException: Duplicate key 101)
        DeptVO deptVO_1 = DeptVO.builder().deptId(101).deptName("金城武").build();
        DeptVO deptVO_2 = DeptVO.builder().deptId(101).deptName("億載金城武").build();
        Map<Integer, DeptVO> deptMap = Stream.of(deptVO_1, deptVO_2).collect(
                Collectors.toMap(DeptVO::getDeptId,
                        Function.identity(), ((deptVO, deptVO2) -> deptVO2)));
        System.out.println("deptMap = " + deptMap);
    }

    @Test
    @Disabled
    public void test_005(){
        // 測試 Collectors.toMap + mapFactory
        // 1.   TreeMap - 按照 key 的字典順序來排序(ASC)
        // 2.   LinkedHashMap - 按照加入的順序排序
        DeptVO deptVO_1 = DeptVO.builder().deptId(103).deptName("金城武").build();
        DeptVO deptVO_2 = DeptVO.builder().deptId(101).deptName("億載金城武").build();
        DeptVO deptVO_３ = DeptVO.builder().deptId(102).deptName("發財金城武").build();
        Map<Integer, DeptVO> deptMap = Stream.of(deptVO_1, deptVO_2, deptVO_３).collect(
                Collectors.toMap(DeptVO::getDeptId,
                        Function.identity(),
                        ((deptVO, deptVO2) -> deptVO2),
                        LinkedHashMap::new));
        System.out.println("deptMap = " + deptMap);
    }

}