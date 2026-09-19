package algorithimPatterns.HashMap_HashSet;

import java.util.LinkedList;
import java.util.List;
public class Design_HashSet {

    public static void main(String[] args) {

        MyHashSet obj = new MyHashSet();

        int key = 890;

        obj.add(key);
        obj.add(key - 76);
        obj.remove(key);

        boolean param_3 = obj.contains(key);

        System.out.println(param_3);
    }

    static class MyHashSet {

        int BucketSize = 769;
        Bucket[] bucket;

        public MyHashSet() {
            this.bucket = new Bucket[BucketSize];

            for (int i = 0; i < BucketSize; i++) {
                this.bucket[i] = new Bucket();
            }
        }

        public int hashFunction(int key) {
            return key % BucketSize;
        }

        public void add(int key) {
            int index = hashFunction(key);
            bucket[index].insert(key);
        }

        public void remove(int key) {
            int index = hashFunction(key);
            bucket[index].remove(key);
        }

        public boolean contains(int key) {
            int index = hashFunction(key);
            return bucket[index].contains(key);
        }
    }

    static class Bucket {

        List<Integer> list;

        public Bucket() {
            this.list = new LinkedList<>();
        }

        public void insert(int val) {
            int index = list.indexOf(val);

            if (index == -1) {
                list.addFirst(val);
            }
        }

        public void remove(Integer val) {
            list.remove(val);
        }

        public boolean contains(int val) {
            int index = list.indexOf(val);
            return index != -1;
        }
    }
}