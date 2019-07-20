package PalkoWK2;

public class BasicPair<T> implements PairInterface<T> {

    protected T first;     // first element of the pair
    protected T second;    //second element of the pair

    public BasicPair(T first, T second){

        this.first = first;

        this.second = second;
    }

    public T getFirst() {

        return first;
    }

    public T getSecond() {

        return second;
    }


    public void setFirst(T first) {

        this.first = first;
    }

    public void setSecond(T second) {

        this.second = second;
    }
}
