public class LinkedListPalindrome {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Function to check if linked list is palindrome
    boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Step 3: Compare halves
        Node temp = secondHalf;
        boolean isPalin = true;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        // Step 4: (Optional) Restore list
        reverse(secondHalf);

        return isPalin;
    }

    // Helper to reverse linked list
    Node reverse(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Add a node at the end
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        LinkedListPalindrome list = new LinkedListPalindrome();
        list.append(1);
        list.append(2);
        list.append(2);
        list.append(1);
        System.out.println("Is Palindrome: " + list.isPalindrome());
    }
}
