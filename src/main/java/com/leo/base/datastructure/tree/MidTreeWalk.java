package com.leo.base.datastructure.tree;

import java.util.Stack;

/**
 * Created by leo on 2017/8/17.
 */
public class MidTreeWalk {
    public static void main(String[] args) {
        Stack<Tree> stack = new Stack<Tree>();
        Tree root = null;

        Tree x = root;

        while (x != null || !stack.empty()) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }

            x = stack.pop();

            System.out.println(x.key);

            x = x.right;
        }
    }
}

class Tree {
    Tree parent;
    Tree left;
    Tree right;
    int key;
}
