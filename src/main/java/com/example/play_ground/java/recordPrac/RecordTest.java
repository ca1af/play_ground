package com.example.play_ground.java.recordPrac;

public class RecordTest {
    public static void main(String[] args) {
        TestRecord testRecord = new TestRecord("foo", 400, true);

        String foo = testRecord.foo();

        System.out.println(foo);
    }
}
