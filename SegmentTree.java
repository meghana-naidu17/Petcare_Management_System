public class SegmentTree {

    private int[] tree;
    private int n;

    public SegmentTree(
            int[] data) {

        n = data.length;

        tree =
                new int[4 * n];

        build(
                data,
                1,
                0,
                n - 1);
    }

    private void build(
            int[] data,
            int node,
            int start,
            int end) {

        if(start == end) {

            tree[node] =
                    data[start];
        }
        else {

            int mid =
                    (start + end) / 2;

            build(
                    data,
                    2 * node,
                    start,
                    mid);

            build(
                    data,
                    2 * node + 1,
                    mid + 1,
                    end);

            tree[node] =
                    tree[2 * node]
                    +
                    tree[2 * node + 1];
        }
    }

    public int query(
            int node,
            int start,
            int end,
            int left,
            int right) {

        if(right < start
                ||
           end < left) {

            return 0;
        }

        if(left <= start
                &&
           end <= right) {

            return tree[node];
        }

        int mid =
                (start + end) / 2;

        return query(
                2 * node,
                start,
                mid,
                left,
                right)
                +
                query(
                        2 * node + 1,
                        mid + 1,
                        end,
                        left,
                        right);
    }

    public int getRangeSum(
            int left,
            int right) {

        return query(
                1,
                0,
                n - 1,
                left,
                right);
    }
}