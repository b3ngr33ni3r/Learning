package com.bengreenier.utils.core;

/**
 * the interface to check a sorter
 * @author B3N
 *
 * @param <T>
 */
public interface SorterCondition<T> {

	public boolean isLess(T element,T compare);
	public boolean isMore(T element,T compare);
	public boolean isEqual(T element,T compare);
}
