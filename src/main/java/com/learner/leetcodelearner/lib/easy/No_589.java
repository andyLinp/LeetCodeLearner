package com.learner.leetcodelearner.lib.easy;

import com.learner.leetcodelearner.lib.bean.Node;
import com.learner.leetcodelearner.lib.bean.NodeWithChildren;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/07/06 09:29
 **/
public class No_589 {
    //给定一个 n 叉树的根节点 root ，返回 其节点值的 前序遍历 。
//
// n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
//
//
//示例 1：
//
//
//
//
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,3,5,6,2,4]
//
//
// 示例 2：
//
//
//
//
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
//
//
//
//
// 提示：
//
//
// 节点总数在范围 [0, 10⁴]内
// 0 <= Node.val <= 10⁴
// n 叉树的高度小于或等于 1000
//
//
//
//
// 进阶：递归法很简单，你可以使用迭代法完成此题吗?
// Related Topics 栈 树 深度优先搜索 👍 286 👎 0

    /**
     * 遍历方法
     * 栈 先进后出
     * @param root
     * @return
     */
    public List<Integer> preorder(NodeWithChildren root) {
        NodeWithChildren node = null;
        Stack<NodeWithChildren> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 栈中推入根节点
        stack.push(root);
        // 当栈中不为空时 取出栈顶的节点 值推入返回集合
        while (!stack.empty()) {
            node = stack.pop();
            res.add(node.val);
            // 将当前出去的节点的子节点按从后到前的顺序推入栈中 保证每次从栈中取出的节点顺序为从前到后
            for (int i = node.children.size() - 1; i >= 0; --i) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }

    /**
     * 递归方法
     * @param root
     * @return
     */
    public List<Integer> preorderRecursive(NodeWithChildren root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    public void dfs(List<Integer> res, NodeWithChildren root) {
        if (root == null) return;
        res.add(root.val);
        for (NodeWithChildren item : root.children) {
            dfs(res, item);
        }
    }
}
