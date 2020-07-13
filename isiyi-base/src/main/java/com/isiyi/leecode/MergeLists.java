package com.isiyi.leecode;

/**
 * @ClassName MergeLists
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/20 23:20
 * @Version 1.0
 */
public class MergeLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode nodePre = head;


        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                nodePre.next = l1;
                l1 = l1.next;
            }else{
                nodePre.next = l2;
                l2 = l2.next;
            }
            //指针往后走一步
            nodePre = nodePre.next;
        }
        nodePre.next = l1 == null ? l2 : l1;
        return head.next;


    }

}
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
