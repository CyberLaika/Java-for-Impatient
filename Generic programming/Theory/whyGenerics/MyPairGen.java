package Theory.whyGenerics;

public class  MyPairGen<K,V> {
    K key;
    V value;

    public MyPairGen(K key, V value){
        this.key=key;
        this.value=value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
