package com.twu.biblioteca.elementusage;

import java.util.List;

public interface ElementManagement<T> {
    public void viewList(List<T> elements);
    public boolean checkoutElement(List<T> elements, int elementNumber);
    public boolean isInTheList(List<T> elements, int elementNumber);
    public boolean isChecked(List<T> elements, int elementNumber);
}
