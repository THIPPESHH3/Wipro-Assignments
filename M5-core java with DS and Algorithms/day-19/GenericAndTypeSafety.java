Day_19;

public class GenericAndTypeSafety<U, V> {
    private final U first;
    private final V second;

    public GenericAndTypeSafety(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public GenericAndTypeSafety<V, U> reverse() {
        return new GenericAndTypeSafety<>(second, first);
    }

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }

    public static void main(String[] args) {
        GenericAndTypeSafety<Integer, String> pair = new GenericAndTypeSafety<>(1, "one");
        System.out.println("Original pair: " + pair);
        GenericAndTypeSafety<String, Integer> reversedPair = pair.reverse();
        System.out.println("Reversed pair: " + reversedPair);
    }
}

