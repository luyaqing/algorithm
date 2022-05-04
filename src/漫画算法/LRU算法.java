package 漫画算法;


import java.util.HashMap;

/**
 * LRU算法的实现
 *
 * 最近最少访问的数据被删除，只保留最近访问的数据，是一种内存管理模型，Linux系统中
 *      尾部是最近访问的数据， 头部是访问较少的数据
 * 使用的数据结构 - 哈希链表
 */
public class LRU算法 {

    private Node head;
    private Node end;

    // 缓存存储上限
    private int limit;
    private HashMap<String, Node> hashMap;

    public LRU算法(int limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }

        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {

        Node node = hashMap.get(key);
        if (node == null) {
            // 如果key不存在，则插入K-V
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            // 如果key存在的话，刷新value值， 刷新一下节点
            node.value = value;
            refreshNode(node);
        }

    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }


    /**
     * 刷新被访问的节点位置
     * @param node
     */
    private void refreshNode(Node node) {

        // 如果访问的是尾结点， 则无需移动节点
        if (node == end) {
            return;
        }

        // 移除节点
        removeNode(node);

        // 重新插入节点
        addNode(node);
    }

    private void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }

        end = node;
        if (head == null) {
            head = node;
        }
    }

    /**
     * 删除节点
     * @param node
     */
    private String removeNode(Node node) {
        if (node == head && node == end) {
            // 移除唯一节点
            head = null;
            end = null;
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else if (node == head) {
            head= head.next;
            head.pre = null;
        } else {
            // 移除中间的节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        return node.key;
    }


    class Node {
        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node pre;
        public Node next;
        public String key;
        public String value;
    }

    public static void main(String[] args) {
        LRU算法 lru = new LRU算法(5);
        lru.put("001", "用户1信息");
        lru.put("002", "用户2信息");
        lru.put("003", "用户3信息");
        lru.put("004", "用户4信息");
        lru.put("005", "用户5信息");

        lru.get("002");
        lru.put("004", "用户4信息更新");
        lru.put("006", "用户6信息");
        System.out.println(lru.get("001"));
        System.out.println(lru.get("006"));
    }
}
