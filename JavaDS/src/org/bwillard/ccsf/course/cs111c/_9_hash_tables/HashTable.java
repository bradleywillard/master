package org.bwillard.ccsf.course.cs111c._9_hash_tables;

public class HashTable<T> {

	//private final static int TABLE_SIZE = 128;
	private int tableSize;
	private LinkedAddress[] table;

	public HashTable(int tableSize) {
		table = new LinkedAddress[tableSize];
		for (int i = 0; i < tableSize; i++) {
			table[i] = null;
		}
		this.tableSize = tableSize;
	}

	public String get(String key) {
		int hash = 0;
		for(int i = 0; i < key.length(); i++) {
			int c = key.charAt(i);
			hash += c;
		}
		hash = (hash % tableSize);
		if (table[hash] == null) {
			return null;
		} else {
			LinkedAddress<T> entry = table[hash];
			while (entry != null && entry.getKey() != key) {
				entry = entry.getNext();
			}
			if (entry == null) {
				return null;
			} else {
				return entry.getValue();
			}
		}
	}

	public void put(String key, String value) {
		int hash = 0;
		for(int i = 0; i < key.length(); i++) {
			int c = key.charAt(i);
			hash += c;
		}
		hash = (hash % tableSize);
		if (table[hash] == null) {
			table[hash] = new LinkedAddress(key, value);
		} else {
			LinkedAddress entry = table[hash];
			while (entry.getNext() != null && entry.getKey() != key) {
				entry = entry.getNext();
			}
			if (entry.getKey() == key) {
				entry.setValue(value);
			} else {
				entry.setNext(new LinkedAddress(key, value));
			}
		}
	}

	public void remove(String key) {
		int hash = 0;
		for(int i = 0; i < key.length(); i++) {
			int c = key.charAt(i);
			hash += c;
		}
		hash = (hash % tableSize);
		if (table[hash] != null) {
			LinkedAddress prevEntry = null;
			LinkedAddress entry = table[hash];
			while (entry.getNext() != null && entry.getKey() != key) {
				prevEntry = entry;
				entry = entry.getNext();
			}

			if (entry.getKey() == key) {
				if (prevEntry == null) {
					table[hash] = entry.getNext();
				} else {
					prevEntry.setNext(entry.getNext());
				}
			}
		}
	}
}