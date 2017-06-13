/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskreciosprojektas;

import java.util.ArrayList;

/**
 *
 * @author mantas.damijonaitis
 */
public class DynamicArrayPerformance {
    
    private static final int UPPER_ITERATIONS = 10;
    private static final int LOWER_ITERATIONS = 100;
    
    public DynamicArrayPerformance(){
        this.addComparison();
        this.getComparison();
        this.indexOfComparison();
        this.removeComparison();
        this.containsComparison();
        this.addAtComparison();
    }
    
    private void addComparison(){
        System.out.println("Add method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                dynamicArray.add(i + j);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    dynamicArrayTime);
        }
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                arrayList.add(i + j);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    arrayListTime);
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    private void printConclusions(double dynamicArrayTime, double arrayListTime){
        if (dynamicArrayTime < arrayListTime){
            System.out.println("Dynamic array is faster by: " + (arrayListTime - dynamicArrayTime)+ " ns");
        } else {
            System.out.println("Array list is faster by: " + (dynamicArrayTime - arrayListTime)+ " ns");
        }
        System.out.println();
    }
    
    private DynamicArray<Integer> formIntegerDynamicArray(){
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                dynamicArray.add(i + j);
            }
        }
        return dynamicArray;
    }
    
    private ArrayList<Integer> formIntegerArrayList(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                arrayList.add(i + j);
            }
        }
        return arrayList;
    }
    
    private void getComparison(){
        System.out.println("Get method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                dynamicArray.get(i + j);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    dynamicArrayTime);
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                arrayList.get(i + j);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    arrayListTime);
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    private void indexOfComparison(){
        System.out.println("Index of method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                dynamicArray.indexOf(i + j);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    dynamicArrayTime);
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                arrayList.indexOf(i + j);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    arrayListTime);
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    private void removeComparison(){
        System.out.println("RemoveAt method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                dynamicArray.remove((Object)value);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    dynamicArrayTime);
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                arrayList.remove((Object)value);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    arrayListTime);
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    private void containsComparison(){
        System.out.println("Contains method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                dynamicArray.contains(value);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    dynamicArrayTime);
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                arrayList.contains(value);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    arrayListTime);
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    private void addAtComparison(){
        System.out.println("Add with index method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                dynamicArray.add((i+j),value);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    dynamicArrayTime);
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                arrayList.add((i+j),value);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList amount of time after " + (i + 1)*LOWER_ITERATIONS + " iterations is " + 
                    arrayListTime);
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
}
