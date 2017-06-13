/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskreciosprojektas;

import java.util.Collection;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mantas.damijonaitis
 */
public class DynamicArrayTest {
    
    public DynamicArrayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd_GenericType() {
        DynamicArray<Student> studentArray = new DynamicArray<>();
        int initialNullAmount = studentArray.amountOfNulls();
        Student initialStudent = new Student("Bla", "Bla", "Bla", "Bla", "Bla");
        studentArray.add(initialStudent);
        int nullAmountAfterStudentInsertion = studentArray.amountOfNulls();
        boolean firstStudentInserted = studentArray.contains(initialStudent);
        for (int i = 0; i < 7; i++){
            Student student = new Student(i+"",i+"",i+"",i+"",i+"");
            studentArray.add(student);
        }
        boolean allElementsInserted = true;
        for (int i = 0; i < 7; i++){
            Student studentFromArray = studentArray.get(i + 1);
            Student student = new Student(i+"",i+"",i+"",i+"",i+"");
            allElementsInserted = student.compareTo(studentFromArray) == 0;
        }
        int nullAmountAfterListInsertion = studentArray.amountOfNulls();
        Assert.assertEquals(10, initialNullAmount);
        Assert.assertEquals(9, nullAmountAfterStudentInsertion);
        Assert.assertTrue(firstStudentInserted);
        Assert.assertEquals(2, nullAmountAfterListInsertion);
        Assert.assertTrue(allElementsInserted);
    }

    @Test
    public void testAdd_int_GenericType() {
        DynamicArray<Student> studentArray = new DynamicArray<>();
        Student firstStudent = new Student("first","first","first","first","first");
        Student secondStudent = new Student("second","second","second","second","second");
        Student thirdStudent = new Student("third","third","third","third","third");
        
        studentArray.add(firstStudent);
        studentArray.add(secondStudent);
        studentArray.add(0, thirdStudent);
        
        Assert.assertNotNull(studentArray.get(0));
        Assert.assertNotNull(studentArray.get(1));
        Assert.assertNotNull(studentArray.get(2));
        
        Assert.assertTrue(studentArray.get(0).compareTo(thirdStudent) == 0);
        Assert.assertTrue(studentArray.get(1).compareTo(firstStudent) == 0);
        Assert.assertTrue(studentArray.get(2).compareTo(secondStudent) == 0);
        
    }

    @Test
    public void testAddAll_Collection() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student fourth = new Student("4","1","1","1","1");
        Student fifth = new Student("5","1","1","1","1");
        Student sixth = new Student("6","1","1","1","1");
        
        DynamicArray<Student> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        DynamicArray<Student> secondArray = new DynamicArray<>();
        secondArray.add(fourth);
        secondArray.add(fifth);
        secondArray.add(sixth);
        
        studentArray.addAll(secondArray);
        
        Assert.assertNotNull(studentArray.get(0));
        Assert.assertNotNull(studentArray.get(1));
        Assert.assertNotNull(studentArray.get(2));
        Assert.assertNotNull(studentArray.get(3));
        Assert.assertNotNull(studentArray.get(4));
        Assert.assertNotNull(studentArray.get(5));
        
        Assert.assertTrue(studentArray.get(0).compareTo(first) == 0);
        Assert.assertTrue(studentArray.get(1).compareTo(second) == 0);
        Assert.assertTrue(studentArray.get(2).compareTo(third) == 0);
        Assert.assertTrue(studentArray.get(3).compareTo(fourth) == 0);
        Assert.assertTrue(studentArray.get(4).compareTo(fifth) == 0);
        Assert.assertTrue(studentArray.get(5).compareTo(sixth) == 0);
        
    }

    @Test
    public void testAddAll_int_Collection() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student fourth = new Student("4","1","1","1","1");
        Student fifth = new Student("5","1","1","1","1");
        Student sixth = new Student("6","1","1","1","1");
        
        DynamicArray<Student> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        DynamicArray<Student> secondArray = new DynamicArray<>();
        secondArray.add(fourth);
        secondArray.add(fifth);
        secondArray.add(sixth);
        
        studentArray.addAll(0, secondArray);
        
        Assert.assertNotNull(studentArray.get(0));
        Assert.assertNotNull(studentArray.get(1));
        Assert.assertNotNull(studentArray.get(2));
        Assert.assertNotNull(studentArray.get(3));
        Assert.assertNotNull(studentArray.get(4));
        Assert.assertNotNull(studentArray.get(5));
        
        Assert.assertTrue(studentArray.get(0).compareTo(fourth) == 0);
        Assert.assertTrue(studentArray.get(1).compareTo(fifth) == 0);
        Assert.assertTrue(studentArray.get(2).compareTo(sixth) == 0);
        Assert.assertTrue(studentArray.get(3).compareTo(first) == 0);
        Assert.assertTrue(studentArray.get(4).compareTo(second) == 0);
        Assert.assertTrue(studentArray.get(5).compareTo(third) == 0);
        
    }

    @Test
    public void testClear() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        
        DynamicArray<Student> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        studentArray.clear();
        Assert.assertEquals(0, studentArray.size());
        Assert.assertEquals(10, studentArray.amountOfNulls());
    }

    @Test
    public void testContains() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student fourth = new Student("4","1","1","1","1");
        
        DynamicArray<Student> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        Assert.assertTrue(studentArray.contains(first));
        Assert.assertTrue(studentArray.contains(second));
        Assert.assertTrue(studentArray.contains(third));
        Assert.assertFalse(studentArray.contains(fourth));
    }

    @Test
    public void testEnsureCapacity() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        
        DynamicArray<Student> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        int nullAmount = studentArray.amountOfNulls();
        
        Assert.assertEquals(nullAmount, 7);
        
        studentArray.ensureCapacity(100);
        
        int nullAmountAfterEnsurance = studentArray.amountOfNulls();
        
        Assert.assertEquals(97, nullAmountAfterEnsurance);
        
    }

    @Test
    public void testGet() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        
        DynamicArray<Student> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        Assert.assertTrue(studentArray.get(0).compareTo(first) == 0);
        Assert.assertTrue(studentArray.get(1).compareTo(second) == 0);
        Assert.assertTrue(studentArray.get(2).compareTo(third) == 0);
        
    }

    @Test
    public void testIndexOf() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        
        DynamicArray<Student> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        Assert.assertEquals(0, studentArray.indexOf(first));
        Assert.assertEquals(1, studentArray.indexOf(second));
        Assert.assertEquals(2, studentArray.indexOf(third));
        
    }

    @Test
    public void testIsEmpty() {
        Student first = new Student("1","1","1","1","1");
        DynamicArray<Student> studentArray = new DynamicArray<>();
        Assert.assertTrue(studentArray.isEmpty());
        studentArray.add(first);
        Assert.assertFalse(studentArray.isEmpty());
        studentArray.remove(first);
        Assert.assertTrue(studentArray.isEmpty());
    }

    @Test
    public void testIterator() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        
        DynamicArray<Student> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        Iterator<Student> studentArrayIterator = studentArray.iterator();
        
        Assert.assertTrue(studentArrayIterator.hasNext());
        Assert.assertTrue(studentArrayIterator.next().compareTo(first) == 0);
        Assert.assertTrue(studentArrayIterator.hasNext());
        Assert.assertTrue(studentArrayIterator.next().compareTo(second) == 0);
        Assert.assertTrue(studentArrayIterator.hasNext());
        Assert.assertTrue(studentArrayIterator.next().compareTo(third) == 0);
        Assert.assertFalse(studentArrayIterator.hasNext());
    }

    @Test
    public void testLastIndexOf() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student sameAsSecond = new Student("2","1","1","1","1");
        Student fifth = new Student("5","1","1","1","1");
        
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(sameAsSecond);
        dynamicArray.add(fifth);
        
        Assert.assertEquals(3, dynamicArray.lastIndexOf(second));
        Assert.assertEquals(3, dynamicArray.lastIndexOf(sameAsSecond));
        Assert.assertEquals(4, dynamicArray.lastIndexOf(fifth));
        
    }

    @Test
    public void testRemove_int() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student fourth = new Student("4","1","1","1","1");
        Student fifth = new Student("5","1","1","1","1");
        Student sixth = new Student("6","1","1","1","1");
        Student seventh = new Student("7","1","1","1","1");
        Student eighth = new Student("8","1","1","1","1");
        Student ninth = new Student("9","1","1","1","1");
        Student tenth = new Student("10","1","1","1","1");
        Student eleventh = new Student("11","1","1","1","1");
        
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        dynamicArray.add(seventh);
        dynamicArray.add(eighth);
        dynamicArray.add(ninth);
        dynamicArray.add(tenth);
        dynamicArray.add(eleventh);
        Assert.assertEquals(9, dynamicArray.amountOfNulls());
        
        dynamicArray.remove(0);
        Assert.assertEquals(9, dynamicArray.amountOfNulls());
        dynamicArray.remove(0);
        Assert.assertEquals(0, dynamicArray.amountOfNulls());
        
        
    }

    @Test
    public void testRemove_Object() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        
        Assert.assertTrue(dynamicArray.contains(first));
        dynamicArray.remove(first);
        Assert.assertFalse(dynamicArray.contains(first));
        
        Assert.assertTrue(dynamicArray.contains(second));
        dynamicArray.remove(second);
        Assert.assertFalse(dynamicArray.contains(second));
        
        Assert.assertTrue(dynamicArray.contains(third));
        dynamicArray.remove(third);
        Assert.assertFalse(dynamicArray.contains(third));
        
        Assert.assertTrue(dynamicArray.isEmpty());
        
    }

    @Test
    public void testRemoveAll() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student fourth = new Student("4","1","1","1","1");
        Student fifth = new Student("5","1","1","1","1");
        Student sixth = new Student("6","1","1","1","1");
        
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        
        DynamicArray<Student> dynamicArrayToRemove = new DynamicArray<>();
        dynamicArrayToRemove.add(fourth);
        dynamicArrayToRemove.add(fifth);
        dynamicArrayToRemove.add(sixth);
        
        Assert.assertTrue(dynamicArray.contains(fourth));
        Assert.assertTrue(dynamicArray.contains(fifth));
        Assert.assertTrue(dynamicArray.contains(sixth));
        
        dynamicArray.removeAll(dynamicArrayToRemove);
        
        Assert.assertFalse(dynamicArray.contains(fourth));
        Assert.assertFalse(dynamicArray.contains(fifth));
        Assert.assertFalse(dynamicArray.contains(sixth));
        
    }

    @Test
    public void testRemoveRange() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student fourth = new Student("4","1","1","1","1");
        Student fifth = new Student("5","1","1","1","1");
        Student sixth = new Student("6","1","1","1","1");
        
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        
        dynamicArray.removeRange(2, 4);
        
        Assert.assertTrue(dynamicArray.contains(first));
        Assert.assertTrue(dynamicArray.contains(second));
        Assert.assertFalse(dynamicArray.contains(third));
        Assert.assertFalse(dynamicArray.contains(fourth));
        Assert.assertFalse(dynamicArray.contains(fifth));
        Assert.assertTrue(dynamicArray.contains(sixth));
        
    }

    @Test
    public void testRetainAll() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student fourth = new Student("4","1","1","1","1");
        Student fifth = new Student("5","1","1","1","1");
        Student sixth = new Student("6","1","1","1","1");
        
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        
        DynamicArray<Student> arrayToRetain = new DynamicArray<>();
        arrayToRetain.add(first);
        arrayToRetain.add(second);
        arrayToRetain.add(third);
        
        dynamicArray.retainAll(arrayToRetain);
        
        Assert.assertTrue(dynamicArray.contains(first));
        Assert.assertTrue(dynamicArray.contains(second));
        Assert.assertTrue(dynamicArray.contains(third));
        Assert.assertFalse(dynamicArray.contains(fourth));
        Assert.assertFalse(dynamicArray.contains(fifth));
        Assert.assertFalse(dynamicArray.contains(sixth));
        
    }

    @Test
    public void testSet() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        
        Assert.assertTrue(dynamicArray.get(0).compareTo(first) == 0);
        Assert.assertTrue(dynamicArray.get(1).compareTo(second) == 0);
        Assert.assertTrue(dynamicArray.get(2).compareTo(third) == 0);
        
        dynamicArray.set(0, third);
        dynamicArray.set(1, first);
        dynamicArray.set(2, second);
        
        Assert.assertTrue(dynamicArray.get(0).compareTo(third) == 0);
        Assert.assertTrue(dynamicArray.get(1).compareTo(first) == 0);
        Assert.assertTrue(dynamicArray.get(2).compareTo(second) == 0);
        
    }

    @Test
    public void testSize() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        Assert.assertEquals(0, dynamicArray.size());
        dynamicArray.add(first);
        Assert.assertEquals(1, dynamicArray.size());
        dynamicArray.add(second);
        Assert.assertEquals(2, dynamicArray.size());
        dynamicArray.add(third);
        Assert.assertEquals(3, dynamicArray.size());
    }

    @Test
    public void testToArray_0args() {
    }

    @Test
    public void testTrimToSize() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student fourth = new Student("4","1","1","1","1");
        Student fifth = new Student("5","1","1","1","1");
        Student sixth = new Student("6","1","1","1","1");
        
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        
        Assert.assertEquals(4, dynamicArray.amountOfNulls());
        
        dynamicArray.trimToSize();
        
        Assert.assertEquals(0, dynamicArray.amountOfNulls());
        
    }

    @Test
    public void testContainsAll() {
        Student first = new Student("1","1","1","1","1");
        Student second = new Student("2","1","1","1","1");
        Student third = new Student("3","1","1","1","1");
        Student fourth = new Student("4","1","1","1","1");
        Student fifth = new Student("5","1","1","1","1");
        Student sixth = new Student("6","1","1","1","1");
        
        DynamicArray<Student> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        
        DynamicArray<Student> dynamicArrayToCompare = new DynamicArray<>();
        dynamicArrayToCompare.add(first);
        dynamicArrayToCompare.add(second);
        
        Assert.assertTrue(dynamicArray.containsAll(dynamicArrayToCompare));
        
        dynamicArrayToCompare.add(fifth);
        
        Assert.assertFalse(dynamicArray.contains(dynamicArrayToCompare));
        
    }
    
}
