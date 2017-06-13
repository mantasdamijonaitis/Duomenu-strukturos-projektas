/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskreciosprojektas;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author mantas.damijonaitis
 * @param <E>
 */
public class DynamicArray <E extends Comparable<E>> implements IDynamicArray<E>, Iterable<E> {
    
    protected E[] baseArray;
    
    private static final int DEFAULT_INITIAL_ARRAY_SIZE = 10;
    private static final int DEFAULT_EXTEND_SIZE = 10;
    
    private int initialArraySize = DEFAULT_INITIAL_ARRAY_SIZE;
    private int initialExtendSize = DEFAULT_EXTEND_SIZE;
    
    private int actualExtendSize = initialArraySize;
    private int actualExtendedArraySize = initialExtendSize;
    
    private int currentArraySize = 0;
    
    public DynamicArray(){
        this.baseArray = (E[])new Comparable[actualExtendedArraySize];
    }
    
    public DynamicArray(int extendSize, int initialArraySize, Class<E> type){
        this.initialArraySize = initialArraySize;
        this.initialExtendSize = extendSize;
        this.actualExtendSize = this.initialArraySize;
        this.actualExtendedArraySize = this.initialExtendSize;
        this.baseArray = (E[])new Comparable[initialArraySize];
    }

    @Override
    public boolean add(E e) {
        
        this.extendAllocations();
        
        this.baseArray[currentArraySize] = e;
        
        currentArraySize++;
        
        return true;
    }
    
    private void extendAllocations(){
        if (currentArraySize + 2 > actualExtendedArraySize){
            actualExtendedArraySize += actualExtendSize;
            baseArray = Arrays.copyOf(baseArray, actualExtendedArraySize);
        }
    }
    
    protected int amountOfNulls(){
        int amountOfNulls = 0;
        for (int i = 0; i < this.baseArray.length; i++){
            if (this.baseArray[i] == null){
                amountOfNulls++;
            }
        }
        return amountOfNulls;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= this.currentArraySize){
            return;
        }
        this.extendAllocations();
        for (int i = this.currentArraySize; i > index ; i--){
            this.baseArray[i] = this.baseArray[i - 1];
        }
        this.baseArray[index] = element;
        currentArraySize++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c){
            this.add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E element : c){
            this.add(index, element);
            index++;
        }
        return true;
    }

    @Override
    public void clear() {
        this.baseArray = (E[])new Comparable[this.initialArraySize];
        this.actualExtendSize = this.initialExtendSize;
        this.actualExtendedArraySize = this.initialArraySize;
        this.currentArraySize = 0;
    }

    @Override
    public boolean contains(Object o) {
        E objectWithType = null;
        try {
            objectWithType = (E)o;
        } catch(Exception e){
            return false;
        }
        for (int i = 0; i < this.currentArraySize; i++){
            if (this.baseArray[i].compareTo(objectWithType) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        this.actualExtendedArraySize = minCapacity;
        this.baseArray = Arrays.copyOf(baseArray, minCapacity);
    }

    @Override
    public E get(int index) {
        return index > this.currentArraySize ? null : this.baseArray[index];
    }

    @Override
    public int indexOf(Object o) {
        E objectWithType = null;
        try {
            objectWithType = (E)o;
        } catch (Exception e){
            return -1;
        }
        for (int i = 0; i < this.baseArray.length; i++){
            if (this.baseArray[i].compareTo(objectWithType) == 0){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.currentArraySize == 0;
    }

    @Override
    public Iterator<E> iterator() {
        
        return new Iterator<E>() {
            
            private int internalCounter = -1;
            
            @Override
            public boolean hasNext() {
                return internalCounter < currentArraySize && baseArray[internalCounter + 1] != null;
            }

            @Override
            public E next() {
                internalCounter++;
                return baseArray[internalCounter];
            }
        };
        
    }
    
    @Override
    public int lastIndexOf(Object o) {
        E objectWithType = null;
        try {
            objectWithType = (E)o;
        } catch (Exception e){
            return -1;
        }
        int lastIndex = -1;
        for (int i = 0; i < this.currentArraySize; i++){
            if (objectWithType.compareTo(this.baseArray[i]) == 0){
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.currentArraySize){
            return null;
        }
        E deletedElement = null;
        
        for (int i = 0; i < this.currentArraySize; i++){
            if (this.baseArray[i].compareTo(this.baseArray[index]) == 0){
                deletedElement = this.baseArray[i];
                this.baseArray[i] = null;
                this.shiftElements(i);
            }
        }
        
        this.currentArraySize--;
        
        this.trimUnnecessaryAllocations();
        
        return deletedElement;
    }

    @Override
    public boolean remove(Object o) {
        E objectWithType = null;
        try{
            objectWithType = (E)o;
        } catch (Exception e){
            return false;
        }
        for (int i = 0; i < this.currentArraySize; i++){
            if (objectWithType.compareTo(this.baseArray[i]) == 0){
                this.baseArray[i] = null;
                this.shiftElements(i);
            }
        }
        
        this.currentArraySize--;
        
        this.trimUnnecessaryAllocations();
        
        return true;
    }
    
    private void shiftElements(int deletedElementIndex){
        for (int j = deletedElementIndex + 1; j < this.currentArraySize; j++){
            this.baseArray[deletedElementIndex] = this.baseArray[j];
            deletedElementIndex++;
        }
    }
    
    private void trimUnnecessaryAllocations(){
        if (this.actualExtendedArraySize - this.currentArraySize > this.actualExtendSize){
            this.actualExtendedArraySize -= actualExtendSize;
            this.baseArray = Arrays.copyOf(baseArray, actualExtendedArraySize);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        
        int deletedItemsAmount = 0;
        for (Object obj : c){
            try {
                E objWithElement = (E)obj;
                for (int i = 0; i < this.currentArraySize; i++){
                    if (this.baseArray[i] != null && this.baseArray[i].compareTo(objWithElement) == 0){
                        this.baseArray[i] = null;
                        deletedItemsAmount++;
                    }
                }
            } catch (Exception e){
                return false;
            }
        }

        
        
        this.rearrangeDistantElements();
        this.currentArraySize -= deletedItemsAmount;
        this.trimUnnecessaryAllocations();
        
        return true;
        
    }
    
    private void rearrangeDistantElements(){
        for (int i = 0; i < this.baseArray.length - 1; i++){
            if (this.baseArray[i] == null){
                for (int j = i + 1; j < this.baseArray.length; j++){
                    if (this.baseArray[j] != null){
                        this.baseArray[i] = this.baseArray[j];
                        this.baseArray[j] = null;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex > toIndex){
            return;
        }
        if (fromIndex < 0 || fromIndex >= this.currentArraySize){
            return;
        }
        if (toIndex < 0 || toIndex >= this.currentArraySize){
            return;
        }
        
        for (int i = fromIndex; i <= toIndex; i++){
            this.baseArray[i] = null;
        }
        
        this.rearrangeDistantElements();
        
        this.currentArraySize -= (toIndex - fromIndex + 1);
        this.trimUnnecessaryAllocations();  
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int deletedItemsAmount = 0;
        for (int i = 0; i < this.currentArraySize; i++){
            boolean elementExistsInCollection = false;
            for (Object obj : c){
                try {
                    E objectWithType = (E)obj;
                    if (objectWithType.compareTo(this.baseArray[i]) == 0){
                        elementExistsInCollection = true;
                        break;
                    }
                } catch (Exception e){
                    break;
                }
            }
            if (!elementExistsInCollection){
                this.baseArray[i] = null;
                deletedItemsAmount++;
            }
        }
        this.rearrangeDistantElements();
        this.currentArraySize -= deletedItemsAmount;
        
        this.trimUnnecessaryAllocations();
        return true;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= this.currentArraySize){
            return null;
        }
        this.baseArray[index] = element;
        return element;
    }

    @Override
    public int size() {
        return this.currentArraySize;
    }

    @Override
    public E[] subArray(int fromIndex, int toIndex) {
        if (fromIndex > toIndex){
            return null;
        }
        if (fromIndex < 0 || fromIndex >= this.currentArraySize){
            return null;
        }
        if (toIndex < 0 || toIndex >= this.currentArraySize){
            return null;
        }
        E[] arrayToReturn = (E[])new Comparable[toIndex - fromIndex + 1];
        int arrayToReturnCounter = 0;
        for (int i = fromIndex; i <= toIndex; i++){
            arrayToReturn[arrayToReturnCounter] = this.baseArray[i];
            arrayToReturnCounter++;
        }
        return arrayToReturn;
    }

    @Override
    public Object[] toArray() {
        Object[] objArrayToReturn = new Object[this.currentArraySize];
        for (int i = 0; i < this.currentArraySize; i++){
            objArrayToReturn[i] = this.baseArray[i];
        }
        return objArrayToReturn;
    }

    @Override
    public void trimToSize() {
       this.baseArray = Arrays.copyOf(this.baseArray, this.currentArraySize);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int containedAmount = 0;
        for (Object obj : c){
            try {
                E objWithType = (E)obj;
                for (int i = 0; i < this.baseArray.length; i++){
                    if (this.baseArray[i].compareTo(objWithType) == 0){
                        containedAmount++;
                        break;
                    }
                }
            } catch (Exception e){
                return false;
            }
        }
        return containedAmount == c.size();
    }
    
}
