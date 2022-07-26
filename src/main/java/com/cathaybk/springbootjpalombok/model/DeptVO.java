package com.cathaybk.springbootjpalombok.model;

import lombok.Builder;
import lombok.Data;
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
public class DeptVO implements Serializable {

    private Integer deptId;
    private String deptName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeptVO deptVO = (DeptVO) o;
        return deptId.equals(deptVO.deptId);
    }

    @Override
    public int hashCode() {
        return deptId.hashCode();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
