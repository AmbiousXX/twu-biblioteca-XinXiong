package com.twu.biblioteca.elementusage;

import java.util.List;

public interface ElementManagement<T> {
    public void viewList(List<T> t);
    public void checkoutElement(List<T> t, int elementNumber);
}
