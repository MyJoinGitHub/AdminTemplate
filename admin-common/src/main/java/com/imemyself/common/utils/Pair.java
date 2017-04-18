package com.imemyself.common.utils;

/**
 * Created by linjie1 on 2017/3/3.
 */
public class Pair<K,V> {

    /**
     * 配对键
     */
    private K key;

    /**
     * 配对值
     */
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
