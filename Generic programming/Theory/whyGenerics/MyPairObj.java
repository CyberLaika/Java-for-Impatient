package Theory.whyGenerics;

public class MyPairObj {
    Object key;
    Object value;

    public MyPairObj(Object key, Object value){
        this.key=key;
        this.value=value;
    }

    public Object getKey(){
        return key;
    }

    public Object getValue(){
        return value;
    }
}
