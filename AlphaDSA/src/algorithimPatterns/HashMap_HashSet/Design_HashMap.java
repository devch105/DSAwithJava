package algorithimPatterns.HashMap_HashSet;


import java.util.LinkedList;
import java.util.List;
package algorithimPatterns.HashMap_HashSet;

import java.util.LinkedList;
import java.util.List;

public class Design_HashMap {

    public static void main(String[] args) {

        MyHashMap obj = new MyHashMap();

        int key = 2;
        int value = 4;

        obj.put(key, value);

        System.out.println("Get: " + obj.get(key));

        obj.put(key, 10);

        System.out.println("After update: " + obj.get(key));

        obj.remove(key);

        System.out.println("After remove: " + obj.get(key));
    }

    static class MyHashMap {

        int bucketSize = 769;
        Bucket[] bucket;

        public MyHashMap() {

            bucket = new Bucket[bucketSize];

            for(int i = 0; i < bucketSize; i++) {
                bucket[i] = new Bucket();
            }
        }

        public int hashFunction(int key) {
            return Math.floorMod(key, bucketSize);
        }

        public void put(int key, int value) {

            int index = hashFunction(key);

            bucket[index].put(key, value);
        }

        public int get(int key) {

            int index = hashFunction(key);

            return bucket[index].get(key);
        }

        public void remove(int key) {

            int index = hashFunction(key);

            bucket[index].remove(key);
        }
    }

    static class Bucket {

        static class Pair {

            int key;
            int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        List<Pair> list;

        public Bucket() {
            list = new LinkedList<>();
        }

        private int findIndex(int key) {

            for(int i = 0; i < list.size(); i++) {

                if(list.get(i).key == key) {
                    return i;
                }
            }

            return -1;
        }

        public void put(int key, int val) {

            int index = findIndex(key);

            if(index == -1) {

                // Key doesn't exist
                list.add(new Pair(key, val));

            } else {

                // Key already exists -> update value
                list.get(index).value = val;
            }
        }

        public int get(int key) {

            int index = findIndex(key);

            if(index != -1) {

                return list.get(index).value;
            }

            return -1;
        }

        public void remove(int key) {

            int index = findIndex(key);

            if(index != -1) {
                list.remove(index);
            }
        }
    }
}


