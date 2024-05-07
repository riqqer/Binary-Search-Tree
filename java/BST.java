
import java.util.*;
public class BST<K extends Comparable<K>, V>{
    private Node<K,V> root;
    private int size = 0;
    public static class Node <K, V>{
        private K key;
        private V value;
        private int length = 1;
        private Node<K,V> left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public BST(){
        root = null;
    }
    public BST(K key, V value){
        root = new Node<>(key, value);
    }

    public void put(K key, V value){
        root = put(root, key, value);
    }
    private Node<K,V> put(Node<K,V> node, K key, V value){
        if(node == null){
            node = new Node<>(key, value);
            size++;
            return node;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;
        return node;
    }

    public V get(K key){
        Node<K,V> node = root;
        while(node != null){
            int cmr = key.compareTo(node.key);
            if(cmr < 0) node = node.left;
            else if(cmr > 0) node = node.right;
            else return (V) node.value;
        }
        return null;
    }
    public void delete(K key){
        root = delete(root, key);
    }

    private Node<K,V> delete(Node<K,V> node, K key){
        if(node == null){
            return null;
        }

        int cmr = key.compareTo(node.key);
        if(cmr < 0) node.left = delete(node.left, key);
        else if(cmr > 0) node.right = delete(node.right, key);
        else{
            if(node.right == null) return node.left;
            if(node.left == null) return node.right;

            node = minValue(node.right);
            node = delete(node.right, (K) node.key);
        }
        return node;
    }

    private Node<K,V> minValue(Node<K,V> node){
        if(node.left == null) return node;
        return minValue(node.left);
    }
    public Iterator<K> iterator(){
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<K> {
        private List<K> keys = new ArrayList<>();
        private int index = 0;
        public BSTIterator() {
            inorder(root);
        }

        private void inorder(Node<K,V> node) {
            if(node == null) return;
            inorder(node.left);
            keys.add(node.key);
            inorder(node.right);
        }
        public boolean hasNext() {
            return index < keys.size();
        }
        public K next() {
            return keys.get(index++);
        }

    }
}
