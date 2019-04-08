package leetCode;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2019/2/17 19:32
 * @since 1.0.0
 */

public class Q2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);


        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;


        ListNode listNode = addTwoNumbers(l1, l4);

    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            ListNode lTemp = l1 == null ? l2 : l1;
            if(lTemp == null){
                return null;
            }
            if(lTemp.val >= 10){
                lTemp.val = lTemp.val %10;
                if(lTemp.next == null){
                    lTemp.next = new ListNode(1);
                }else{
                    lTemp.next.val = lTemp.next.val + 1;
                    addTwoNumbers1(lTemp.next,null);
                }
                return lTemp;
            }
            return l1 == null ? l2 : l1;
        }else{
            int lr = l1.val + l2.val;
            ListNode temp,t1;
            if(lr >= 10){
                t1 = l1.next == null ? l2.next : l1.next;
                if(t1 == null){
                    ListNode ls = new ListNode((l1.val+l2.val)%10);
                    ls.next = new ListNode(1);
                    return ls;
                }
                t1.val = t1.val+1;
                temp = addTwoNumbers(t1, null);
            }else{
                temp = addTwoNumbers(l1.next, l2.next);
            }
            int i = (l1.val + l2.val) % 10;
            ListNode result = new ListNode(i);
            result.next = temp;
            return result;
        }

    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode tmp;
        if(l1 == null || l2 == null){
            tmp = l1 == null ? l2 : l1;
            if(tmp == null){
                return null;
            }else{
                if(tmp.val >= 10){
                    tmp.val = tmp.val % 10;
                    if(tmp.next == null){
                        tmp.next = new ListNode(1);
                    }else{
                        tmp.next.val = tmp.next.val +1 ;
                        tmp.next = addTwoNumbers(tmp.next,null);
                    }
                }
                return tmp;
            }
        }else{
            //都不为空
            int val = l1.val + l2.val;
            tmp = new ListNode(val%10);
            if(val >= 10){
                if(l1.next != null){
                    l1.next.val = l1.next.val + 1;
                    tmp.next = addTwoNumbers(l1.next,l2.next);
                }else if(l2.next != null){
                    l2.next.val = l2.next.val + 1;
                    tmp.next = addTwoNumbers(l1.next,l2.next);
                }else{
                    tmp.next = new ListNode(1);
                }
            }else{
                tmp.next = addTwoNumbers(l1.next,l2.next);
            }
            return tmp;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        //创建一个虚拟头结点
        ListNode listNode = new ListNode(0);
        //记录当前节点
        ListNode temp = listNode;
        int sum = 0;
        while (tmp1 != null || tmp2 != null){
            sum = sum / 10;
            if(tmp1 != null){
                sum = sum + tmp1.val;
                tmp1 = tmp1.next;
            }
            if(tmp2 != null){
                sum = sum + tmp2.val;
                tmp2 = tmp2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        if (sum > 9) {
            temp.next = new ListNode(1);
        }
        return listNode.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
