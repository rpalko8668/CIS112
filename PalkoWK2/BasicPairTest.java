package PalkoWK2;

public class BasicPairTest {

    public static void main(String[] args){

        PairInterface<String> stringPair = new BasicPair<>("chocolate", "vanilla");

        System.out.println(stringPair.getFirst() + " " + stringPair.getSecond());

        stringPair.setSecond("Strawberry");

        System.out.println(stringPair.getFirst() + " " + stringPair.getSecond());

        PairInterface<Integer> intPair = new BasicPair<>(100, 255);

        System.out.println(intPair.getFirst() + " " + intPair.getSecond());

        intPair.setFirst(8);

        System.out.println(intPair.getFirst() + " " + intPair.getSecond());
    }
}
