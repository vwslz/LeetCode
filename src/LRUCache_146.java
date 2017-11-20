import java.util.HashMap;

public class LRUCache_146 {
    class LRUCache {
        private HashMap<Integer, Node> map;
        private int capacity;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            map = new HashMap<Integer, Node>();
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.pre = null;
            head.nxt = tail;
            tail.pre = head;
            tail.nxt = null;
        }

        public int get(int key) {
            //System.out.println("get: " + key);
            Node node = map.get(key);
            if(node == null)
                return -1;
            remove(node);
            add(node);
            return node.val;
        }

        public void put(int key, int value) {
            //System.out.println("put: " + key + " " + value);
            Node node = map.get(key);
            if (node == null)
            {
                //System.out.println("  new");

                Node newNode = new Node();
                newNode.key = key;
                newNode.val = value;
                add(newNode);
                map.put(key, newNode);
                if (map.size() > capacity)
                {
                    int tailKey = tail.pre.key;
                    remove(map.get(tailKey));
                    map.remove(tailKey);
                }
            }
            else
            {
                //System.out.println("  old");

                node.val = value;
                remove(node);
                add(node);
            }
        }

        private void add(Node node){
            //System.out.println("-add- " + node.key);

            node.pre = head;
            node.nxt = head.nxt;
            head.nxt.pre = node;
            head.nxt = node;

            //printList();
        }

        private void remove(Node node)
        {
            //System.out.println("-remove- " + node.key);

            node.pre.nxt = node.nxt;
            node.nxt.pre = node.pre;

            //printList();
        }

        private void printList()
        {
            Node node = head;
            while (node.nxt != tail)
            {
                node = node.nxt;
                System.out.print("[" + node.key + ", " + node.val + "]");
            }
            System.out.println("");
        }
    }

    class Node {
        int key;
        int val;
        Node pre;
        Node nxt;
    }
}
