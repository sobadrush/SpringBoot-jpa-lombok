package com.cathaybk.springbootjpalombok.model;

import lombok.Data;

import java.io.Serializable;

/**
 * - @Getter/@Setter
 * - @ToString
 * - @EqualsAndHashCode
 * - @RequiredArgsConstructor
 */
@Data
public class DeptVO implements Serializable {

    private Integer deptId;
    private String deptName;

}
