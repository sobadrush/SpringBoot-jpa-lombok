package com.cathaybk.springbootjpalombok.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * - @Getter/@Setter
 * - @ToString
 * - @EqualsAndHashCode
 * - @RequiredArgsConstructor
 */
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class DeptVO implements Serializable {

    @Builder.Default
    private Integer deptId = 0;
    @Builder.Default
    private String deptName = "調查局";
    @Builder.Default
    private final Integer deptHeadCount = 99;

    // @Tolerate
    // public DeptVO(){
    //     System.out.println("I'm default constructor.");
    // }
    //
    // @Tolerate
    // public DeptVO(DeptData deptData){
    //     this.setDeptName(deptData.DEPT_NAME_DATA);
    // }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     DeptVO deptVO = (DeptVO) o;
    //     return deptId.equals(deptVO.deptId);
    // }
    //
    // @Override
    // public int hashCode() {
    //     return deptId.hashCode();
    // }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
