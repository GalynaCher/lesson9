package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[10];

        //for(String str : strings)
        //    System.out.println(str);
       for (int i = 0; i < strings.length; i++)
           strings[i] = "String " + i;

       // System.out.println(String.join(", ", strings));

        int[] intArr = {10, 20, 5, 4, 9, 1};
        int[] newIntArr = new int[intArr.length];
        System.arraycopy(intArr, 0, newIntArr, 0, intArr.length);

        printIntArray(intArr);

       // Sort = (N - 1) ^ 2
       for (int i = 0; i < intArr.length; i++) {
           for (int j = 0; j < intArr.length - 1; j ++) {
               if (intArr[j] > intArr[j + 1]) {
                   int tmp = intArr[j];
                   intArr[j] = intArr[j + 1];
                   intArr[j + 1] = tmp;
               }
           }
       }

        //printIntArray(intArr);

        //printIntArray(newIntArr);
        //Arrays.sort(newIntArr);
        //printIntArray(newIntArr);

       int[][] intMatrix1 = new int[5][7];
       System.out.println("intMatrix1: ");
       for (int i = 0; i < intMatrix1.length; i ++){
           for (int j = 0; j < intMatrix1[i].length; j ++){
               intMatrix1[i][j] = (i + 1) * 10 + j;
               System.out.print(intMatrix1[i][j] + " ");
           }
           System.out.println();
       }

        int[][] intMatrix = new int[5][];

       int matrixSizeCounter = 0;
        System.out.println("intMatrix: ");
        for (int i = 0; i < intMatrix.length; i ++) {
            intMatrix[i] = new int[i + 1];
            matrixSizeCounter += intMatrix[i].length;
            //System.out.println(matrixSizeCounter);
            for (int j = 0; j < intMatrix[i].length; j++) {
                intMatrix[i][j] = (i + 1) * 10 + j + 1;
                System.out.print(intMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Convert matrix to array
        int[] matrixToArr = new int[matrixSizeCounter];
        int matrixToArrCounter = 0;
        for (int i = 0; i < intMatrix.length; i ++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                matrixToArr[matrixToArrCounter] = intMatrix[i][j];
                matrixToArrCounter ++;
                //System.out.println(intMatrix[i][j] + " " + "i: " + i + ", j: " + j);
            }
        }
        printIntArray(matrixToArr);

        // Collection
        // ArrayList
        ArrayList<String> arrayList = new ArrayList<>(50);
        arrayList.ensureCapacity(100);
        arrayList.trimToSize();
        arrayList.add("String 1");
        arrayList.add("String 2");
        arrayList.add("String 3");
        arrayList.add("String 4");
        arrayList.add("String 5");

        System.out.println(String.join(", ", arrayList));
        arrayList.remove(1);
        System.out.println(String.join(", ", arrayList));

        // LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("String 1");
        linkedList.add("String 2");
        linkedList.add("String 3");
        linkedList.add("String 4");

        linkedList.remove(1);
        System.out.println(String.join(", ", linkedList));

        // HashMap
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Key 1", "String for Key 1");
        hashMap.put("Key 2", "String for Key 2");
        hashMap.put("Key 3", "String for Key 3");

        System.out.println(hashMap.get("Key 3"));

        for (Map.Entry<String,String> pair : hashMap.entrySet())  {
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }

        // Stream and lambda example
        List<String> mapValues = hashMap.values().stream().map(
                e -> e.equalsIgnoreCase("String for Key 3") ? e.toLowerCase() : e
        ).collect(Collectors.toList());
        List<String> mapValues2 = hashMap.values().stream().map(
                e -> {
                    if (e.equalsIgnoreCase("String for Key 3"))
                        return e.toLowerCase();
                    else
                        return e;
                }
        ).collect(Collectors.toList());
        List<String> mapValues3 = hashMap.values().stream().map(
                e -> {
                    return e.toLowerCase();
                }
        ).collect(Collectors.toList());
        //List<String> mapValues4 = hashMap.values().stream().map(
        //        e -> {
        //            String::toLowerCase;
        //        }
        //).collect(Collectors.toList());
        // mapValues == mapValues2
        // mapValues3 == mapValues4
        System.out.println(mapValues);
        System.out.println(mapValues2);

        for (int i = 0; i < mapValues.size(); i ++) {
            if(i == 2)
                mapValues.add("New string");
        }
        System.out.println(mapValues);

        Set<String> hashSet = new HashSet<>();
        hashSet.add("String 1");
        hashSet.add("String 2");
        hashSet.add("String 3");
        hashSet.add("String 4");
        hashSet.add("String 5");
        hashSet.add("String 5");
        hashSet.add("String 5");
        hashSet.add("String 5");

        System.out.println("HashSet");
        System.out.println(hashSet);

        //DZ
        String phrase = "Hello from Java";
        Map<Character, Integer> letters = new HashMap<>();

        // NOT OPTIMIZED
        //for (char ch : phrase.toCharArray()){
        //    if (letters.containsKey(ch))
        //        letters.put(ch, letters.get(ch) + 1);
        //    else
        //        letters.put(ch, 1);
        //}
        // OPTIMIZED
        for (char ch : phrase.toCharArray()){
            //int count = letters.containsKey(ch) ? letters.get(ch) : 0;
            int count = letters.getOrDefault(ch, 0);

            letters.put(ch, count + 1);
        }

        boolean isEveryLetterOccursTwice = true;
        for (Map.Entry<Character, Integer> pair : letters.entrySet()){
            //if ()
            //    isEveryLetterOccursTwice = false;
            // if (pair.getValue() == 1) // UNIQUE CHARS
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }



    public static void printIntArray(int[] array) {
        for(int intVal : array)
            System.out.print(intVal + ", ");
        System.out.println();
    }
}