import java.util.Scanner;

public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode resultNode = new ListNode();
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    resultNode.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    resultNode.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }
            while (list1!=null){
                resultNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            while (list2!=null){
                resultNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            return resultNode.next;
        }
    }
}
