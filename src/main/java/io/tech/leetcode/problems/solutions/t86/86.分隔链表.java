package io.tech.leetcode.problems.solutions.t86;/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode.cn/problems/partition-list/description/
 *
 * algorithms
 * Medium (63.45%)
 * Likes:    588
 * Dislikes: 0
 * Total Accepted:    161.2K
 * Total Submissions: 254.1K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 
 * -200 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import io.tech.leetcode.common.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode l1 = dummy1;
        ListNode l2 = dummy2;
        while(head != null){
            if(head.val < x){
                l1.next = new ListNode(head.val);
                l1 = l1.next;
            }else{
                l2.next = new ListNode(head.val);
                l2 = l2.next;
            }

            head = head.next;
        }

        l1.next = dummy2.next;
        return dummy1.next;
    }
}
// @lc code=end

