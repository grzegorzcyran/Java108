package edu.sda.javaadvanced.threads.counter;

public enum ThreadName {
    THREAD_ONE("one"),
    THREAD_TWO("two");

    private String name;

    ThreadName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String findName(String name) {
        for (ThreadName value : ThreadName.values()) {
            if(name.equals(value.name)) {
                return value.name;
            }
        }
        return null;
    }
}
