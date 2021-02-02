package n8;

public class Pair<E extends Comparable<E>> {
    private E item1;
    private E item2;
    public Pair(E item1,E item2){
        this.item1=item1;
        this.item2=item2;
    }


    public E getFirstItem(){
        return item1;
    }
    public E getSecondItem(){
        return item2;
    }
    public E max(){
        if(item1.compareTo(item2)>0)
            return item1;
        else
            return item2;
    }
    public E min(){
        if(item1.compareTo(item2)<0)
            return item1;
        else
            return item2;
    }

}
