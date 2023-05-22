package com.learner.leetcodelearner.lib.bean.v17;

import lombok.Data;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/05/18 16:05
 **/
@Data
public sealed class Fruit permits Apple, Pear {
    private String name;

    private int price;
}
