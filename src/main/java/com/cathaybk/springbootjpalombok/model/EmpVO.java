package com.cathaybk.springbootjpalombok.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
// @RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC, staticName = "getInstance"/*自訂*/)
@ToString
public class EmpVO {

    @lombok.NonNull
    private String empCode; // 員工編號
    @lombok.NonNull
    private String empName; // 員工姓名
    @lombok.NonNull
    private BigDecimal salary; // 薪資

}
