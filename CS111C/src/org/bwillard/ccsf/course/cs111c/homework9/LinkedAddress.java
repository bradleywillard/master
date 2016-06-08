package org.bwillard.ccsf.course.cs111c.homework9;

public class LinkedAddress<T> {

    private String key;
    private String value;
    private LinkedAddress next;

    LinkedAddress(String key, String value) {
          this.key = key;
          this.value = value;
          this.next = null;
    }

    public String getValue() {
          return value;
    }

    public void setValue(String value) {
          this.value = value;
    }

    public String getKey() {
          return key;
    }

    public LinkedAddress getNext() {
          return next;
    }

    public void setNext(LinkedAddress next) {
          this.next = next;
    }
}