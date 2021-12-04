package tester;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ListTestTable {

    private final static String heading = "|Called method|Number of calls|ArrayList|LinkedList|\n";;
    private final static String row = "|%13s|%15s|%9d|%10d|%n";
    private final static Map<String, BiConsumer<List<Integer>, Integer>> methodToLambda;
    private final static List<String> listOfMethods;

    static {
        listOfMethods = List.of("Add", "Get", "Remove");
        methodToLambda = Map.of(
                "Add", (list, index) -> list.add(100),
                "Get", (list, index) -> list.get(index),
                "Remove", (list, index) -> list.remove(list.size() - 1)
        );
    }

    public static void print(int numberOfMethodsCalls) {
        StringBuilder table = new StringBuilder();
        ListCollectionTester tester = new ListCollectionTester();

        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        long linkedListExecutionTime, arrayListExecutionTime;

        table.append(heading);
        for (String method : listOfMethods) {
            linkedListExecutionTime = tester.getExecutionTime(methodToLambda.get(method), linkedList, numberOfMethodsCalls);
            arrayListExecutionTime = tester.getExecutionTime(methodToLambda.get(method), arrayList, numberOfMethodsCalls);
            table.append(String.format(row, method, numberOfMethodsCalls, arrayListExecutionTime, linkedListExecutionTime));
        }

        System.out.println(table);
    }
}
