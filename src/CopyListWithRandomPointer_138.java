import java.util.HashMap;

public class CopyListWithRandomPointer_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode iterOldHead = head;
        RandomListNode iterNewHead = newHead;
        while (iterOldHead != null)
        {
            if (map.containsKey(iterOldHead.label))
                iterNewHead.next = map.get(iterOldHead.label);
            else
            {
                RandomListNode newNode = new RandomListNode(iterOldHead.label);
                iterNewHead.next = newNode;
                map.put(iterOldHead.label, newNode);
            }

            if (iterOldHead.random == null)
                iterNewHead.next.random = null;
            else
            {
                if (map.containsKey(iterOldHead.random.label))
                    iterNewHead.next.random = map.get(iterOldHead.random.label);
                else
                {
                    RandomListNode newNodeRandom = new RandomListNode(iterOldHead.random.label);
                    iterNewHead.next.random = newNodeRandom;
                    map.put(iterOldHead.random.label, newNodeRandom);
                }
            }
            iterOldHead = iterOldHead.next;
            iterNewHead = iterNewHead.next;
        }
        return newHead.next;
    }
}
