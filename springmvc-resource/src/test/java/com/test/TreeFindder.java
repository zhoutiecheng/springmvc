package com.test;

import java.util.Arrays;

/**
 * Created by zhoutc on 2016-10-09.
 */
public class TreeFindder {
    public static void main(String[] args) throws Exception {
        int[] preSort={1,2,4,7,3,5,6,8};
        int[] inSort={4,7,2,1,5,3,8,6};
        BinaryTreeNode root=constructCore(preSort,inSort,0,0);
    }
    public static BinaryTreeNode constructCore(int[] preorder,int[] inorder, int lvl, int type) throws Exception{
        if(preorder==null||inorder==null){
            return null;
        }
        if(preorder.length!=inorder.length){
            throw new Exception("长度不一样，非法的输入");
        }
        BinaryTreeNode root=new BinaryTreeNode();
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                root.value=inorder[i];
                String name = "";
                switch (type){
                    case 0:name="根";break;
                    case 1:name="左";break;
                    case 2:name="右";break;
                }
                System.out.println(lvl+name+root.value);
                root.leftNode=constructCore(Arrays.copyOfRange(preorder,1, i+1), Arrays.copyOfRange(inorder, 0, i),lvl+1,1);
                root.rightNode=constructCore(Arrays.copyOfRange(preorder,i+1, preorder.length),Arrays.copyOfRange(inorder, i+1, inorder.length),lvl+1,2);
            }
        }
        return root;
    }
}
