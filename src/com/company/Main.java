package com.company;

import com.company.Day;
import com.company.Entry;

import javax.xml.ws.EndpointReference;
import java.util.*;
import java.util.stream.Collectors;

import static com.company.Day.*;

public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        printEntries(entries);
        printTuesdays(entries);
        countTueWedThur(entries);
        weekendList(entries);
        weekdaySet(entries);
      //  printDurationGreaterThan10(entries);
      //  findMaxDuration(entries);
      //  listGreaterThan50(entries);
    }


    public static void printEntries(List<Entry> entries) {
        System.out.println("For Loop:");
        for (Entry entry : entries) {
            System.out.println(entry + ", ");
        }
        System.out.println("\nStream, forEach:");
        entries.stream().forEach(entry -> System.out.println(entry + ", "));
        System.out.println();
    }

    public static void printTuesdays(List<Entry> entries) {

        //Print out tuesday entries

        System.out.println("For Loop:");
        // write for loop
        for (Entry entry : entries) {

            if (entry.getDay() == Day.TUESDAY) {
                System.out.println(entry + ",");
            }
        }
        System.out.println("\nStream, filter, forEach:");
        // write stream
        entries.stream()
                .filter(entry -> entry.getDay() == Day.TUESDAY)
                .forEach(System.out::println);

    }


    public static void countTueWedThur(List<Entry> entries) {
        //Count the number of Tuesday, Wednesday, and Thursday entries

        System.out.println("For Loop:");
        int count = 0;
        // write for loop

        for (Entry entry : entries) {
            if (entry.getDay() == Day.TUESDAY || entry.getDay() == Day.WEDNESDAY || entry.getDay() == Day.THURSDAY) {

                count++;
            }
        }
            System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count);
            System.out.println("Stream, filter, count: ");

        long count1 = 0;
        // write stream
        count1 = entries.stream()
                .filter(entry -> entry.getDay() == Day.TUESDAY || entry.getDay() == Day.WEDNESDAY || entry.getDay() == Day.THURSDAY)
                .count();
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count1);
        System.out.println();


    }

    public static void weekendList(List<Entry> entries) {
        //Create a list of weekend (Saturday and Sunday) entries
        System.out.println("For Loop:");
        List<Entry> weekends = new ArrayList<>();
        // write for loop
        for (Entry entry : entries) {
            if (entry.getDay() == SATURDAY || entry.getDay() == Day.SUNDAY) {
                weekends.add(entry);
            }
        }
        System.out.println(weekends);
        System.out.println("Stream, filter, collect:");

        weekends = entries.stream()
                .filter(entry -> entry.getDay() == Day.SATURDAY || entry.getDay() == Day.SUNDAY)
                .collect(Collectors.toList());

        System.out.println(weekends);
        System.out.println();
    }

    public static void weekdaySet(List<Entry> entries) {
        //Create a SET of weekday entries
        System.out.println("For Loop:");
        Set<String> weekdays = new HashSet<>();
        // write for loop
        for (Entry entry : entries) {
            if (entry.getDay() == Day.MONDAY || entry.getDay() == Day.TUESDAY || entry.getDay() == Day.WEDNESDAY || entry.getDay() == Day.THURSDAY || entry.getDay() == Day.FRIDAY) {
                weekdays.add(entry.getDay().toString());
            }
        }

            System.out.println(weekdays);
            System.out.println("Stream, filter, map, collect:");
            weekdays = entries.stream()
                    .filter(entry -> entry.getDay() != Day.SUNDAY && entry.getDay() != Day.TUESDAY)
                    .map(entry -> entry.getDay().toString()).collect(Collectors.toSet());
            System.out.println(weekdays);
            System.out.println();
        }
    }



//    public static void findMaxDuration(List<Entry> entries) {
//        System.out.println("For Loop:");
//        int temp = 0;
//        // write for loop
//        for (Entry entry : entries) {
//               if(entry.getDuration() > temp){
//                   temp = entry.getDuration;
//            temp++;
//        }
//    }
//
//}
//        System.out.println("The Max Duration is: " + temp);
//        System.out.println("Stream, mapToInt, max, getAsInt:");
//        temp = entries.stream()
//            .f
//        System.out.println("The Max Duration is: " + temp);
//        System.out.println();
//    }
//
//    public static void listGreaterThan50(List<Entry> entries){
//        System.out.println("For Loop:");
//        List<Entry> greaterThan50 = new ArrayList<>();
//        // write for looop
//        for(Entry entry: entries){
//            if (entry.getDuration() >50){
//                greaterThan50.add(entry);
//            }
//        }
//
//        System.out.println(greaterThan50);
//        System.out.println("Stream, filter, collect:");
//        entries.stream()
//                .filter(entries -> entries.)
//        System.out.println(greaterThan50);
//        System.out.println();
//    }
//}
