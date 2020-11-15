package com.mcartagena;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayCompareTest {
  
  @BeforeClass
  public static void beforeClass(){
    System.out.println("BeforeClass test ...");
  }

  @AfterClass
  public static void AfterClass(){
    System.out.println("AfterClass test ...");
  }

  @Before
  public void setupBefore(){
    System.out.println("Before Test...");
  }

  @After
  public void setupAfter(){
    System.out.println("After Test... ");
  }

  @Test
  public void testArraySort_RandomArray(){
    int[] numbers = {12, 3, 4, 1 };
    int[] expected = {1, 3, 4, 12};

    Arrays.sort(numbers);
    assertArrayEquals(expected, numbers);
  }

  @Test(expected = NullPointerException.class)
  public void testArraySort_NullArray(){
    int[] numbers = null;
    Arrays.sort(numbers);
  }

  @Test(timeout = 10)
  public void testSort_Performance(){
    int array [] = {12,23,4};
    for(int i=1;i<=1000000;i++){
      array[0] = i;
      Arrays.sort(array);
    }
  }

  
}
