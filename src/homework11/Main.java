package homework11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println ("Задание 1");
        List<Integer> setOfNumbers = new ArrayList<>();
        setOfNumbers.add(522);
        setOfNumbers.add(684964);
        setOfNumbers.add(234);
        setOfNumbers.add(-12);
        setOfNumbers.add(0);
        setOfNumbers.add(231);
        setOfNumbers.add(11);
        setOfNumbers.add(2);
        setOfNumbers.add(-3856);
        setOfNumbers.add(1279);
        setOfNumbers.add(999);
        Stream<Integer> streamOfNumbers = setOfNumbers.stream();
        findMinMax(streamOfNumbers, Integer::compareTo, (x, y) ->
                System.out.println ("Минимальное значение: " + x + "\n" + "Максимальное значение: " + y));
        System.out.println();
        System.out.println("Задание 2");
        findAndCountevenNumers(setOfNumbers);
    }
    public static <T> void findMinMax(Stream<? extends T> stream , Comparator<? super T> order , BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> arrayList;
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList ());
        if (arrayList.size () != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min , max);

    }
    public static void findAndCountevenNumers(List<Integer> list) {
        List<Integer> findAndCountevenNumersList = list.stream ()
                .filter (x -> x % 2 == 0)
                .collect (Collectors.toList ());
        System.out.println ("Количество четных чисел: " + findAndCountevenNumersList.size() + " (" + findAndCountevenNumersList + ")");
    }
}
