/**
 * Author: DatDoan Created Date: Apr 19, 2018
 */
package com.mum.edu.chapter01.LinkedList;

public class RemoveNthNode {
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode result = head;
    
    // find the length of LinkedList
    ListNode traverseNode = head;
    int length = 1;
    while(traverseNode != null) {
      length++;
      traverseNode = traverseNode.next;
    }
    ListNode prev = head;
    n = length - n;
    if (n == 1) {
      ListNode next = head.next;
      head = next;
      return head;
    }
    int count = 1;
    while (head != null) {
      ListNode current = head;
      if (count == n) {
        ListNode next = current.next;
        prev.next = next;
        current = null;
        break;
      }
      prev = head;
      head = head.next;
      count++;
    }
    return result;
  }
  
  public static void traverse(ListNode head) {
    StringBuilder sb = new StringBuilder();
    while(head != null) {
      sb.append(head.val);
     if (head.next != null) {
       sb.append("->");
     }
     
     head = head.next;
    }
    System.out.println(sb.toString());
  }
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode node2 = new ListNode(2);
    head.next = node2;
    
    ListNode node3 = new ListNode(3);
    node2.next = node3;
    
    ListNode node4 = new ListNode(4);
    node3.next = node4;
    
    ListNode node5 = new ListNode(5);
    node4.next = node5;
    
    traverse(head);
    // Remove the 2th node
    traverse(removeNthFromEnd(head, 3));
  }
}
