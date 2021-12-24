package patterns;

public class TwoPointer {

    void reverseString(char[] chars) {
        int left=0, right=chars.length;
        while(left<right){
            swap(chars,left,right);
            left++;
            right--;
        }
    }
    void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i]=chars[j];
        chars[j]= temp;
    }
    static void twoPointer() {
        int[] arr= new int[]{1,2,3,4,5,6,7,8,9,10};
        int p1=0, p2=arr.length-1;
        while(p1<p2) {
            System.out.printf("%s %s ", arr[p1],  arr[p2]);
            p1++;
            p2--;
        }
    }
    public static void main(String[] args) {
        twoPointer();
    }
}

// Fast and slow pointer
class ListNode {
    int data;
    ListNode next;
}

class LinkedListHasCycle {
    boolean hasCycle(ListNode head) {

        ListNode slow=head, fast = head;;
        while(fast !=null && fast.next.next !=null) {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

}
