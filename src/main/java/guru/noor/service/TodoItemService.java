package guru.noor.service;

import guru.noor.model.TodoData;
import guru.noor.model.TodoItem;

public interface TodoItemService {
    void addItem(final TodoItem todoItem);
    void removeItem(final int id);
    TodoItem getItem(final int id);
    void updateItem(final TodoItem todoItem);
    TodoData getData();
}
