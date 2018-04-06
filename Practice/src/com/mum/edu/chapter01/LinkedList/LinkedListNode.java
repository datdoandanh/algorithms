package com.mum.edu.chapter01.LinkedList;

public class LinkedListNode {
	LinkedListNode next = null;
	int data;

	public LinkedListNode(int data) {
		this.data = data;
	}

	public LinkedListNode appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
		return this;
	}

	public LinkedListNode deleteNode(LinkedListNode head, int d) {
		LinkedListNode n = head;
		if (n.data == d) {
			head = n.next;
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			}
			n = n.next;
		}
		return head;
	}

	/**
	 * Remove duplicates from an unsorted linked list;
	 * 
	 * @param head
	 * @return
	 */
	public LinkedListNode removeDuplicate(LinkedListNode head) {
		LinkedListNode i = head;
		while (i != null) {
			LinkedListNode j = i.next;
			while (j != null) {
				if (i.data == j.data) {
					i.next = j.next.next;
					j = i.next;

				} else {
					j = j.next;
				}
			}
			i = i.next;
		}
		return head;
	}

	/**
	 * Find the kth to the last element of a singly linked list.
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public LinkedListNode nthToLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;

		// Move p1 k nodes into the list
		for (int i = 0; i < k; i++) {
			if (p1 == null)
				return null;
			p1 = p1.next;
		}

		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	/**
	 * Partition a singly linked list around x, such that all nodes less than x come
	 * before all nodes greater or equal to x. Solution: Create 2 singly linked
	 * list: one for elements greater than x and one for elements greater or equal
	 * to x After we have completed the splitting, we merge the two lists.
	 * 
	 * @param head
	 * @param x
	 * @return
	 */
	public LinkedListNode partition(LinkedListNode head, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		LinkedListNode n = head;
		while (n != null) {
			LinkedListNode node = new LinkedListNode(n.data);
			if (n.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			n = n.next;
		}
		if (beforeEnd != null) {
			beforeEnd.next = afterStart;
		}
		return beforeStart;
	}

	/**
	 * You have 2 numbers represented by a linked list, where each node contains a single digit.
	 * The digits are stored in reverse order.
	 * Implement to add the two numbers and return the sum as a linked list.
	 * @param first
	 * @param second
	 * @return
	 */
	public static LinkedListNode sumList(LinkedListNode first, LinkedListNode second) {
		LinkedListNode sum = null;
		int num = 0;
		int remainder = 0;
		while (first != null || second != null) {
			int num1 = first != null ? first.data : 0;
			int num2 = second != null ? second.data : 0;
			num = num1 + num2 + remainder;
			if (num >= 10) {
				remainder = num / 10;
				num = num % 10;
			} else {
				remainder = 0;
			}
			if (sum == null) {
				sum = new LinkedListNode(num);
			} else {
				sum.appendToTail(num);
			}
			first = first != null ? first.next : null;
			second = second != null ? second.next : null;
		}
		return sum;
	}
	
	/**
	 * Reverse the singly linked list
	 * @param head
	 * @return
	 */
	public static LinkedListNode reverse(LinkedListNode head) {
		LinkedListNode n = head;
		LinkedListNode reversedHead = null;
		while (n != null) {
			LinkedListNode node = new LinkedListNode(n.data);
			if (reversedHead == null) {
				reversedHead = node;
			} else {
				node.next = reversedHead;
				reversedHead = node;
				
			}
			n = n.next;
		}
		return reversedHead;
	}
	/**
	 * Check if a linked list is a palindrome.
	 * Solution: Reverse and Compare
	 * - Reverse the linked list and compare the reversed list to the original list. If they are the same, the list are identical. 
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(LinkedListNode orginalList) {
		LinkedListNode reversedList = reverse(orginalList);
		while (reversedList != null) {
			if (reversedList.data != orginalList.data) {
				return false;
			}
			reversedList = reversedList.next;
			orginalList = orginalList.next;
		}
		return true;
	}
	@Override
	public String toString() {
		StringBuilder print = new StringBuilder();
		LinkedListNode n = this;
		do {
			if (n.next == null) {
				print.append(n.data);
			} else {
				print.append(n.data).append("->");
			}
			n = n.next;
		} while (n != null);
		return print.toString();
	}

	public static void main(String[] args) {
		// LinkedListNode head = new LinkedListNode(1);
		// head.appendToTail(2).appendToTail(2).appendToTail(3).appendToTail(4).appendToTail(4).appendToTail(5);
		// System.out.println(head.toString());
		// System.out.println("Delete node where its value is 3");
		// head = head.deleteNode(head, 3);
		// System.out.println(head.toString());
		//// System.out.println("Remove duplicates");
		//// head = head.removeDuplicate(head);
		//// System.out.println(head.toString());
		// System.out.println("Find the kth to the last element of a singly linked
		// list");
		// LinkedListNode kthNode = head.nthToLast(head, 4);
		// System.out.println(kthNode.data);
		//
		// head = new LinkedListNode(3);
		// head.appendToTail(5).appendToTail(8).appendToTail(5).appendToTail(10).appendToTail(2).appendToTail(1);
		// System.out.println(head.toString());
		// head = head.partition(head, 5);
		// System.out.println("Partition this list around 5");
		// System.out.println(head.toString());
//		LinkedListNode first = new LinkedListNode(7);
//		first.appendToTail(1).appendToTail(6).appendToTail(3);
//		LinkedListNode second = new LinkedListNode(5);
//		second.appendToTail(9).appendToTail(2);
//		System.out.println("Input :" + first.toString() + " + " + second.toString());
//		LinkedListNode sum = LinkedListNode.sumList(first, second);
//		System.out.println(sum.toString());
		LinkedListNode originalList = new LinkedListNode(0);
		originalList.appendToTail(1).appendToTail(2).appendToTail(1).appendToTail(0);
		System.out.println(originalList.toString());
//		originalList = LinkedListNode.reverse(originalList);
//		System.out.println(originalList.toString());
		System.out.println("Is Palindrome " + LinkedListNode.isPalindrome(originalList));
		
	}

}
