// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together 
// the nodes of the first two lists.

// Return the head of the merged linked list.


package Leetcode;

// ListNode -> represents one node 
class ListNode {
    int val; // store val
    ListNode next; // stores address (reference) of next node

    ListNode() {} // create empty node

    ListNode(int val) {
        this.val = val;
    }
    // 3rd constructor and creates a node and immeditately connects it
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class mergeTwoLists {

    public ListNode mergeDosLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        // current pointer -> points to the last node of the merged list
        ListNode current = dummy;

        // Continue unitl one list finishes
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        // attach the remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
 
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        mergeTwoLists solution = new mergeTwoLists();
        ListNode merged = solution.mergeDosLists(list1, list2);

        System.out.print("Merged List: ");
        while (merged != null) {
            System.out.print(merged.val);
            if (merged.next != null) {
                System.out.print(" -> ");
            }
            merged = merged.next;
        }

    }
}
