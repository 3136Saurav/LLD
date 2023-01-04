import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public Node buildSegmentTree(int start, int end) {
        if (start > end) {
            return null;
        }

        Node node = new Node(start, end);

        if (start == end) {
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = buildSegmentTree(start, mid);
        node.right = buildSegmentTree(mid + 1, end);
        return node;
    }

    public void update(Node root, int val) {
        if (root == null) {
            return;
        }

        if (root.start == val && root.end == val) {
            root.sum += 1;
            return;
        }

        int mid = (root.start + root.end) / 2;

        if (val <= mid) {
            update(root.left, val);
        } else {
            update(root.right, val);
        }

        root.sum = root.left.sum + root.right.sum;
    }

    public int query(Node root, int start, int end) {
        if (root == null || start > end) {
            return 0;
        }

        if (root.start == start && root.end == end) {
            return root.sum;
        }

        int mid = (root.start + root.end) / 2;

        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start > mid) {
            return query(root.right, start, end);
        }

        return query(root.left, start, mid) + query(root.right, mid + 1, end);
    }


    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int[] counts = new int[nums.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int el : nums) {
            min = Math.min(min, el);
            max = Math.max(max, el);
        }

        Node root = buildSegmentTree(min, max);

        for (int i = nums.length - 1; i >= 0; i--) {
            update(root, nums[i]);
            counts[i] = query(root, min, nums[i] - 1);
        }


        List<Integer> ans = new ArrayList<>();
        for (int i : counts) {
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums = {-1, -2};
        m.countSmaller(nums);
    }
}


class Node {
    Node left;
    Node right;
    int start;
    int end;
    int sum;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
    }
}

















