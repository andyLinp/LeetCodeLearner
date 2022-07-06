package com.learner.leetcodelearner.lib.bean;

import java.util.List;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/07/06 09:31
 **/
public class NodeWithChildren {
    public int val;
    public List<NodeWithChildren> children;

    public NodeWithChildren() {}

    public NodeWithChildren(int _val) {
        val = _val;
    }

    public NodeWithChildren(int _val, List<NodeWithChildren> _children) {
        val = _val;
        children = _children;
    }
}
