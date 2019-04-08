package test;

import java.io.File;
import java.util.Stack;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2019/3/13 21:33
 * @since 1.0.0
 */

public class Test7 {

    public static void main(String[] args) {
//        Integer[] list = {10,2,8,4,6,5,4,3,9,1};
//        Integer[] bubble = bubble(list);
//        for (int i = 0; i < bubble.length; i++){
//            System.out.println(bubble[i]);
//        }

//        Node<Integer> root = makeNode();
//        test(root);
//        root = reverseNode1(root);
//        test(root);
//        int[] arr = {12,23,34,56,56,56,78};
//        bubbleSort(arr);

        File file = new File("G:\\test");
        printFile(file,"");

    }

    private static void printFile(File file,String tmp) {
        if(file == null){
            return;
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()){
                System.out.println(tmp+file1.getName());
                printFile(file1,tmp + "--");
            }else{
                System.out.println(tmp+file1.getName());
            }
        }

    }



    private static Node<Integer> makeNode() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> root1 = new Node<>(2);
        Node<Integer> root2 = new Node<>(3);
        Node<Integer> root3 = new Node<>(4);
        Node<Integer> root4 = new Node<>(5);
        Node<Integer> root5 = new Node<>(6);
        Node<Integer> root6 = new Node<>(7);
        Node<Integer> root7 = new Node<>(8);
        Node<Integer> root8 = new Node<>(9);
        Node<Integer> root9 = new Node<>(10);

        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;
        root5.next = root6;
        root6.next = root7;
        root7.next = root8;
        root8.next = root9;
        return root;
    }


    private static Node<Integer> reverseNode(Node<Integer> root) {
        if(root == null){
            return null;
        }
        Node<Integer> node = root;
        Stack<Integer> stack = new Stack<>();
        while(node != null){
            stack.push(node.t);
            node = node.next;
        }

        while(!stack.empty()){
            Integer tmp = stack.pop();
            System.out.println(tmp);
            root.t = tmp;
            root = root.next;
        }
        return root;

    }
    private static Node<Integer> reverseNode1(Node<Integer> root){
        Node<Integer> pre = null;
        Node<Integer> cur = root;
        Node<Integer> rehead = null;
        while (cur != null) {
            //暂时保存下一个节点
            Node<Integer> tmp = cur.next;
            //将指针逆转
            cur.next = pre;
            //如果当前节点下一位是空，则当前节点为逆转后的链表的头
            if (tmp == null) {
                rehead = cur;
            }
            //节点移位，当前节点赋给pre  下一个节点赋给cur（当前节点）
            pre = cur;
            cur = tmp;
        }
        return rehead;
    }
    private static Node<Integer> reverseNode2(Node<Integer> root){
        Node<Integer> pre = null;
        Node<Integer> temp = null;
        while (root != null){
            temp = root.next;
            root.next = pre;

            pre = root;
            root = temp;
        }
        return pre;
    }



    public static void test(Node<Integer> node){
        while(node != null){
            System.out.println(node.t);
            node = node.next;
        }
    }
    //
    public static Integer[] bubble(Integer[] list){
        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                if(list[i] > list[j]){
                    int tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        }
        return list;
    }

    public static void bubbleSort(int []arr) {
        for(int i =0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {//-1为了防止溢出
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }


}

class Node<T> {
    T t;
    Node<T> next;

    public Node(Node<T> next, T t) {
        this.next = next;
        this.t = t;
    }

    public Node(T t) {
        this.t = t;
        this.next = null;
    }
}


// 1. double check 单例
class Singleton{
    private static Singleton singleton;
    private Singleton() {
    }
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}





