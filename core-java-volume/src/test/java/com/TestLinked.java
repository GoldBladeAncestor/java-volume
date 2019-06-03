package com;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 17:18 2019/5/8
 */
public class TestLinked {

    /**
     * 构造链表并填充数据
     * @return
     */
//    @Test
    public ListNode testLink(){
        ListNode firstNode = null;
        ListNode lastNode = null;
        int []num = {1,2,3,3,4,4,5,5,5,6,7,8,9,10};
        for (int i = 0; i < num.length; i++) {
            ListNode curNode = new ListNode(num[i]);
            if(lastNode == null){
                firstNode = curNode;
            }else{
                lastNode.next = curNode;
            }
            lastNode = curNode;
        }
//        lastNode.next = firstNode;
        ListNode temp = firstNode;
        while(temp != null){
            System.out.print(temp.val);
            temp = temp.next;
        }
        return firstNode;
    }

    /**
     * 反转链表
     */
    @Test
    public void solution(){
        ListNode listNode = testLink();
        ListNode prevNode = null;
        ListNode currNode = listNode;
        ListNode nextNode = null;
        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        System.out.println();
        while(prevNode != null){
            System.out.print(prevNode.val);
            prevNode = prevNode.next;
        }
    }

    /**
     * 反转链表
     */
    // 2.新建链表,头节点插入法
    @Test
    public void reverseList2() {
        ListNode dummy = new ListNode();
        ListNode pCur = testLink();
        while (pCur != null) {
            ListNode pNex = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = pNex;
        }
        System.out.println();
        while(dummy != null){
            System.out.print(dummy.val);
            dummy = dummy.next;
        }
    }

    /**
     * 检查链表是否存在循环
     * 最佳方法
     */
    @Test
    public void testRepeatBest(){
        ListNode p1 = testLink();
        ListNode p2 = p1.next.next;
        String flag = "";
        while (p1 != null && p2 != null) {
            if (p1 ==p2) {
                flag = "存在循环";
                break;
            }
            else if (p2 == null) {
                flag = "不存在循环";
                break;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if("".equals(flag)){
            flag = "不存在循环";
        }
        System.out.println(flag);
    }

    /**
     * 通过map或set判断是否链表是否存在循环
     */
    @Test
    public void testRepeatByMap(){
        ListNode p1 = testLink();
        Map<Object,Object> map = new HashMap<>();
        Set<Object> set = new HashSet<>();
        String flag = "";
        while (p1 != null) {
            if(map.get(p1) != null){
//            if(!set.add(p1)){
                flag = "存在循环";
                break;
            }else{
                map.put(p1,"");
            }
            p1 = p1.next;
        }
        if("".equals(flag)){
            flag = "不存在循环";
        }
        System.out.println(flag);
    }

    /**
     * 得到倒数第N个节点
     */
    @Test
    public void testGetNNode(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入：");
        int n = in.nextInt();
        ListNode p1 = testLink();
        ListNode p2 = null;
        int count = 0;
        while (p1 != null) {
            p1 = p1.next;
            count ++;
            if(count == n){
               p2 = testLink();
            }
            if(count > n ){
                p2 = p2.next;
            }

        }
        if(p2== null){
            System.out.println("请输入不超过链表长度的数字，" + count);
            return;
        }
        System.out.println("倒数第" + n + "个节点为：" + p2.val);
    }

    /**
     * 删除排序链表中的重复值，保留第一个
     */
    @Test
    public void testDelRepeat(){
        //构建链表并填充数据
        ListNode listNode = testLink();
        if(listNode ==null){
            return;
        }
        //创建两个指针，一个前驱指针，一个当前指针
        //前驱指针首次指向头链表，当前指针首次指向链表第二节
        ListNode prevNode = listNode;
        ListNode currNode = prevNode.next;
        //当前驱指针与当前指针相同时，当前指针直接指向当前指针的next
        //直至当前指针与前驱指针不同，就将前驱指针的next改为当前指针
        //循环至当前指针为null
        boolean flag = false;
        while (currNode != null){
            flag = false;
            if (prevNode.val != currNode.val){
                prevNode.next =currNode;
                prevNode = currNode;

            }else{
                flag = true;
            }
            currNode = currNode.next;
        }
        if (flag){
            prevNode.next = currNode;
        }
        System.out.println("去重后的链表为：");
        while(listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 删除排序链表中的所有重复值
     */
    @Test
    public void testDelRepeatAll(){
        //构建链表并填充数据
        ListNode listNode = testLink();
        if (listNode == null){
            return ;
        }
        //由于是删除所有重复值，考虑到头也有可能会重复，所以需要重新构建链表
        ListNode resultNode = null;
        ListNode lastNode = null;
        //声明一个标识，重复时为true
        boolean flag = false;
        //其余和之前的类似
        ListNode prevNode = listNode;
        ListNode currNode = prevNode.next;
        while (currNode != null){
            if (prevNode.val != currNode.val){
                ListNode tempNode = null;
                if (resultNode == null){
                    if (flag){
                        tempNode = currNode;
                        flag = false;
                    }else{
                        tempNode = prevNode;
                    }
                    resultNode = tempNode;
                }else{
                    if (flag){
                        tempNode = currNode;
                        flag = false;
                    }else{
                        tempNode = prevNode;
                    }
                    lastNode.next = tempNode;
                }
                lastNode = tempNode;
                prevNode = currNode;
            }else{
                flag = true;
            }
            currNode = currNode.next;
        }

        System.out.println("去重后的链表为：");
        while(resultNode != null){
            System.out.print(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    @Test
    public void testMain(){
        ListNode node = testLink();
        node = repeatDumplication(node);
        System.out.println("去重后的链表为：");
        while(node != null){
            System.out.print(node.val);
            node = node.next;
        }
    }

    public ListNode repeatDumplication(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        if(head.val == next.val){
            while(next.next != null && next.next.val == next.val){
                next = next.next;
            }
            return repeatDumplication(next);
        }else{
            head.next = repeatDumplication(next);
            return head;
        }
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Singleton {
    private Singleton() {
    }

    private static class HolderClass {
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return HolderClass.instance;
    }

    public static void main(String args[]) {
        Singleton s1, s2;
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        System.out.println(s1==s2);
    }
}