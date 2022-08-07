package com.cathaybk.springbootjpalombok.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmpVO_Test {

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        System.err.println(String.format(" ======== %s Starting ======== ", testInfo.getDisplayName()));
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.err.println(String.format(" ======== %s finished ======== ", testInfo.getDisplayName()));
    }

    @Test
    @Disabled
    public void test001() {
        // 初始值為第一個 elem
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> optSumAnswer = nums.stream().reduce((int1, int2) -> int1 + int2);
        System.out.println("optSumAnswer.get() = " + optSumAnswer.get());
    }

    @Test
    @Disabled
    public void test001_2() {
        // 初始值為第一個 elem
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sumAnswer = nums.stream().reduce(1000, (int1, int2) -> int1 + int2);
        System.out.println("sumAnswer = " + sumAnswer);
    }

    @Test
    @Disabled
    public void test_002() {
        // 測試：@RequiredArgsConstructor
        // EmpVO empVO =／ntln("empVO = " + empVO);
    }

    @Test
    @Disabled
    public void test_003() {
        // 測試：@RequiredArgsConstructor 使用 staticName 完成「靜態工廠方法」
        EmpVO empVO = EmpVO.getInstance("NT89739", "Roger Lo", new BigDecimal(22000));
        System.out.println("empVO = " + empVO);
    }

    @Test
    @Disabled
    public void test_004() {
        // 計算所有員工薪資
        BigDecimal allSalary = genAllEmps().stream()
                .map(EmpVO::getSalary)
                .reduce(BigDecimal.ZERO, (salary1, salary2) -> {
                    return salary1.add(salary2);
                });
        System.out.println("allSalary = " + allSalary);
    }

    @Test
    @Disabled
    public void test_005() {
        List<Integer> intList = Arrays.asList(10, -12);
        Long num = intList.stream()
                .reduce(0L,
                        (Long a, Integer b) -> a + b,
                        (aLong, aLong2) -> {
                            System.out.println(">>> 我是 combiner，我只有在 parallelStream 會被執行 <<<");
                            return null;
                        });
        System.out.println("long num = " + num);
    }

    @Test
    @Disabled
    public void test_006() {
        // 測試 reduce：迭代將 element 加入list
        List<String> empNames = genAllEmps().parallelStream()
                .reduce(new ArrayList<>(), (ArrayList<String> previous, EmpVO following) -> {
                    previous.add(following.getEmpName());
                    return previous;
                }, (ArrayList<String> a, ArrayList<String> b) -> {
                    System.out.println(">>> 我是 combiner，我只有在 parallelStream 會被執行 <<<");
                    return b;
                });
        System.out.println("empNames = " + empNames);
    }

    @Test
    @Disabled
    public void test_007() {
        IntStream intStream = IntStream.rangeClosed(1, 10);

        // Integer sumAns = intStream.reduce(100, (int1, int2) -> {
        //     System.out.println(Thread.currentThread().getName() + " - " + (int1 + int2));
        //     return int1 + int2;
        // });

        // Integer sumAns = intStream.parallel()
        //         .reduce(100, (int1, int2) -> {
        //             System.out.println(Thread.currentThread().getName() + " - " + (int1 + int2));
        //             return int1 + int2;
        //         });
        // System.out.println("sumAns = " + sumAns);
    }

    // 建立員工List
    public static List<EmpVO> genAllEmps() {
        return Stream.of(
                EmpVO.getInstance("A001", "Roger", new BigDecimal(22000)),
                EmpVO.getInstance("A002", "Kelly", new BigDecimal(22000)),
                EmpVO.getInstance("A003", "Tom", new BigDecimal(22000)),
                EmpVO.getInstance("A004", "Cathy", new BigDecimal(22000)),
                EmpVO.getInstance("A005", "Robert", new BigDecimal(22000))

        ).collect(Collectors.toList());
    }
}
