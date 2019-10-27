/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortedlist;

/**
 *
 * @author samda
 * @param <E>
 */
public interface SortedList<E> {
    int size();
    boolean isEmpty();
    void add(E val);
    E getMin();
    E removeMin();
}
