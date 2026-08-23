// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by 
// continuously following the next pointer. Internally, pos is used to denote the index of the node that 
// tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.


package Leetcode;

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        // Ininitally slow points to first node
        // Head also initially starts at first node
        // IMPORTANT -> Head moves 2 steps while slow moves 1
        ListNode slow = head;
        ListNode fast = head;

        // Loop continues as long as fast is able to
        // If fast = null -> reached end of list
        while (fast != null && fast.next != null) {
            // Slow moves one node
            slow = slow.next;
            // Fast moves 2 nodes
            fast = fast.next.next;

            // Check if both slow and fast point to same nodes, if so return true
            if (slow == fast) {
                return true;
            }
        }

        // Loop ends or returns false if fast reached end of list
        return false;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);


        head1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node4.next = node2;

        System.out.println("List 1 has Cycle: " + hasCycle(head1));

        // Test 2: List without a cycle
        // 1 -> 2 -> 3 -> null
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println("List 2 has cycle: " + hasCycle(head2));
    }
    
}
