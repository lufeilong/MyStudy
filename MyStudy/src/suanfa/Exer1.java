package suanfa;

public class Exer1 {
	public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		int[] twoSum = Exer1.twoSum(nums, 9);
		if(twoSum != null){
			for (int i : twoSum) {
				System.out.println(i);
			}
		}
		
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		listNode4.nextNode = listNode3;
		ListNode listNode2 = new ListNode(2);
		listNode2.nextNode = listNode4;
		
		ListNode listNode7 = new ListNode(4);
		ListNode listNode6 = new ListNode(6);
		listNode6.nextNode = listNode7;
		ListNode listNode5 = new ListNode(5);
		listNode5.nextNode = listNode6;
		
		@SuppressWarnings("unused")
		ListNode node = Exer1.addTwoNumbers(listNode2, listNode5);
	}
//	
//	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        
////		输入：（2 - > 4 - > 3）+（5 - > 6 - > 4）
////		输出： 7 - > 0 - > 8
//		
//		
//		return null;
//    }
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode prev = new ListNode(0);
	        ListNode head = prev;
	        int carry = 0;
	        while (l1 != null || l2 != null || carry != 0) {
	            ListNode cur = new ListNode(0);
	            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
	            cur.val = sum % 10;
	            carry = sum / 10;
	            prev.nextNode = cur;
	            prev = cur;
	            
	            l1 = (l1 == null) ? l1 : l1.nextNode;
	            l2 = (l2 == null) ? l2 : l2.nextNode;
	        }
	        return head.nextNode;
	    }
}

class ListNode{
    int val;
    ListNode nextNode;
    ListNode beforeNode;
    ListNode(int val){
        this.val=val;
        this.nextNode=null;
    }
}
