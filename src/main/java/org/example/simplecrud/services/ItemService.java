package org.example.simplecrud.services;

import org.example.simplecrud.models.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemService {
    private final Map<Integer, Item> items = new HashMap<>();
    private int currentId = 1;

    public Collection<Item> getAllItems() {
        return items.values();
    }

    public Item getItemById(int id) {
        return items.get(id);
    }

    public Item createItem(Item item) {
        item.setId(currentId++);
        items.put(item.getId(), item);
        return item;
    }

    public Item updateItem(int id, Item item) {
        if (!items.containsKey(id)) {
            return null;
        }
        item.setId(id);
        items.put(id, item);
        return item;
    }

    public boolean deleteItem(int id) {
        return items.remove(id) != null;
    }
}
