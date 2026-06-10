//Question : https://leetcode.com/problems/maximum-total-subarray-value-ii/description/
class Solution {
    private static class SegmentTree{
        private static class Node{
            int startIndex;
            int endIndex;
            int max;
            int min;
            Node left;
            Node right;

            Node(int startIndex, int endIndex){
                this.startIndex = startIndex;
                this.endIndex = endIndex;
            }
        }

        Node root;

        SegmentTree(int[] nums){
            this.root = buildTree(nums,0,nums.length-1);
        }

        private Node buildTree(int[] nums, int left, int right){
            Node node = new Node(left,right);

            if(left==right){
                node.max=nums[left];
                node.min = nums[left];
                return node;
            }

            int mid = left + (right-left)/2;
            node.left = buildTree(nums,left,mid);
            node.right = buildTree(nums,mid+1,right);

            node.max = Math.max(node.left.max,node.right.max);
            node.min = Math.min(node.left.min,node.right.min);

            return node;
        }

        // Query returns max, in for range
        private static class Pair{
            int max;
            int min;

            Pair(int max, int min){
                this.max = max;
                this.min=min;
            }
        }

        Pair query(int left, int right){
            return queryHelper(root,left,right);
        }

        private Pair queryHelper(Node node, int left, int right){
            // no overlap
            if(node==null || node.endIndex<left || node.startIndex>right){
                return new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE);
            }

            // complete overlap
            if(left<=node.startIndex && right>=node.endIndex){
                return new Pair(node.max,node.min);
            }

            Pair leftNode = queryHelper(node.left,left,right);
            Pair rightNode = queryHelper(node.right,left, right);

            return new Pair(
                    Math.max(leftNode.max,rightNode.max),
                    Math.min(leftNode.min,rightNode.min)
            );
        }
    }
    private static class State{
        long value;
        int left;
        int right;

        State(long value,int left, int right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static long maxTotalValue(int[] nums, int k){
        int n = nums.length;
        SegmentTree segmentTree = new SegmentTree(nums);
        PriorityQueue<State> pq = new PriorityQueue<>((state1, state2)->Long.compare(state2.value,state1.value));

        Set<String> vis = new HashSet<>();
        SegmentTree.Pair root = segmentTree.query(0,n-1);
        pq.add(new State((long) root.max-root.min,0,n-1));
        vis.add("0..."+(n-1));

        long ans =0;

        while(k>0 && !pq.isEmpty()){
            State curr = pq.poll();
            ans += curr.value;
            k--;

            int left = curr.left;
            int right = curr.right;

            // left++
            if(left+1<=right){
                String key = (left+1) + "..." + right;
                if(!vis.contains(key)){
                    SegmentTree.Pair pair = segmentTree.query(left+1,right);
                    pq.add(new State((long) pair.max- pair.min,left+1,right));
                    vis.add(key);
                }
            }

            // right--
            if(left<=right-1){
                String key = left + "..." + (right-1);
                if(!vis.contains(key)){
                    SegmentTree.Pair pair = segmentTree.query(left,right-1);
                    pq.add(new State((long)pair.max-pair.min,left,right-1));
                    vis.add(key);
                }
            }
        }

        return ans;
    }
}
