/**
 * 
 */
package com.the.adatszerkezetek;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Veres Zoltán
 */
public class DataStructuresDemo
{
    void run()
    {
        //1.1 Tömb (Array) -> Karakterlánc (String)
        String[] strArray11 = {"apple", "banana", "orange", "kiwi"};
        System.out.println("1.1 Array as String: " + Arrays.toString(strArray11)); 
        //[apple, banana, orange, kiwi]

        //1.2 Karakterlánc (String) -> Tömb (Array)
        String str12 = "apple, banana, orange, kiwi";
        String[] strArray12 = str12.split(", ");
        System.out.println("1.2 String as Array: " + Arrays.toString(strArray12));
        //[apple, banana, orange, kiwi]

        //2.1 Lista (List) -> Karakterlánc (String)
        List<String> strList21 = Arrays.asList("apple", "banana", "orange", "kiwi");
        System.out.println("2.1 List as String: " + strList21.toString());
        //[apple, banana, orange, kiwi]

        //2.2 Karakterlánc (String) -> Lista (List)
        String str22 = "apple, banana, orange, kiwi";
        List<String> strList22 = Arrays.asList(str22.split(", "));
        System.out.println("2.2 String as List: " + strList22);
        //[apple, banana, orange, kiwi]

        //3.1 Halmaz (Set) -> Karakterlánc (String)
        Set<String> strSet31 = new HashSet<>();
        strSet31.add("apple");
        strSet31.add("banana");
        strSet31.add("orange");
        strSet31.add("kiwi");
        System.out.println("3.1 Set as String: " + String.join(", ", strSet31));
        //banana, orange, apple, kiwi

        //3.2 Karakterlánc (String) -> Halmaz (Set)
        String str32 = "apple, banana, orange, kiwi";
        Set<String> strSet32 = new HashSet<>(Arrays.asList(str32.split(", ")));
        System.out.println("3.2 Set as String: " + strSet32);
        //Output: Set: [apple, banana, orange, kiwi]

        //4.1 Map (Map) -> Karakterlánc (String)
        Map<Integer, String> map41 = new HashMap<>();
        map41.put(1, "apple");
        map41.put(2, "banana");
        map41.put(3, "orange");
        map41.put(4, "kiwi");
        StringBuilder sb41 = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map41.entrySet()) {
            sb41
                .append(entry.getKey())
                .append(":").append(entry.getValue()).append(", ");
        }
        System.out.println(
            "4.1 Map as String: " + sb41.deleteCharAt(sb41.length() - 1).toString()
        );
        //1:apple, 2:banana, 3:orange, 4:kiwi

        //4.2 Karakterlánc (String) -> Map (Map)
        String str42 = "1:apple, 2:banana, 3:orange, 4:kiwi";
        Map<Integer, String> map42 = new HashMap<>();
        for (String s : str42.split(", ")) {
            map42.put(Integer.parseInt(s.split(":")[0]), s.split(":")[1]);
        }
        System.out.println("4.2 Map as String: " + map42);
        ///{1=apple, 2=banana, 3=orange, 4=kiwi}

        //5.1 Verem (Stack): Last-In-First-Out (LIFO) -> Karakterlánc (String)
        Stack<String> stack51 = new Stack<>();
        stack51.push("apple");
        stack51.push("banana");
        stack51.push("orange");
        stack51.push("kiwi");

        StringBuilder sb51 = new StringBuilder();
        while (!stack51.isEmpty()) {
            sb51.append(stack51.pop()).append(", ");
        }

        System.out.println("5.1 Stack as String: " + sb51.toString().trim());
        //kiwi, orange, banana, apple

        //5.2 Karakterlánc (String) -> Verem (Stack): Last-In-First-Out (LIFO)
        String str52 = "kiwi, orange, banana, apple";
        Stack<String> stack = new Stack<>();

        for (String s : str52.split(", ")) {
            stack.push(s);
        }

        System.out.println("5.2 String as Stack: " + stack);
        //[kiwi, orange, banana, apple]

        //6.1 Sor (Queue): First-In-First-Out (FIFO) -> Karakterlánc (String)
        Queue<String> queue61 = new LinkedList<>();
        queue61.offer("apple");
        queue61.offer("banana");
        queue61.offer("orange");
        queue61.offer("kiwi");

        StringBuilder sb61 = new StringBuilder();
        while (!queue61.isEmpty()) {
            sb61.append(queue61.poll()).append(", ");
        }

        System.out.println("6.1 Queue as String: " + sb61.toString().trim());
        //apple, banana, orange, kiwi

        //6.2 Karakterlánc (String) -> Sor (Queue): First-In-First-Out (FIFO)
        String str62 = "apple, banana, orange, kiwi";
        Queue<String> queue = new LinkedList<>(Arrays.asList(str62.split(", ")));

        System.out.println("6.2 String as Queue: " + queue);
        //[apple, banana, orange, kiwi]

        //7.1 Vector (Vektor) -> Karakterlánc (String)
        Vector<String> vector71 = new Vector<>();
        vector71.add("apple");
        vector71.add("banana");
        vector71.add("orange");
        vector71.add("kiwi");

        System.out.println("7.1 Vector as String: " + vector71.toString());
        //Vector as String: [apple, banana, orange, kiwi]

        //7.2 Karakterlánc (String) -> Vector (Vektor)
        String str72 = "apple,banana,orange,kiwi";
        Vector<String> vector = new Vector<>(Arrays.asList(str72.split(",")));

        System.out.println("7.2 String as Vector: " + vector);
        //[apple, banana, orange, kiwi]
    }
}
