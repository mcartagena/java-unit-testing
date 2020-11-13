package com.mcartagena.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class StringTest {

  @BeforeAll
  static void beforeAll(){
    System.out.println("Initialize connection to database");
  }

  @AfterAll
  static void afterAll(){
    System.out.println("Close connection to database");
  }

  @BeforeEach  // JUnit4 @Before
  void beforeEach(TestInfo info){  // TestInfo only in Junit5
    System.out.println("Initialize Test Data for " + info.getDisplayName());
  }

  @AfterEach  // JUnit4 @After
  void afterEach(TestInfo info){  // TestInfo only in Junit5
    System.out.println("Clean up unit test data for " + info.getDisplayName());
  }

  @Test
  void length_basic() {
    assertEquals("ABCD".length(), 4);
  }

  @Test
  void length_exception(){
    String str = null;
    assertThrows(NullPointerException.class, () -> {
      str.length();
    });
  }

  @Test
  void toUpperCase_basic(){
    String str = "abcd";
    String result = str.toUpperCase();

    assertEquals("ABCD", result);
  }

  @Test
  void toBoolean(){
    boolean bln = Math.random() > 0;
    assertNotNull(bln);
    assertTrue(bln);
  }

  @Test
  void contains_basic(){
    assertFalse("abcdefgh".contains("ijk"));
  }

  @Test
  void split_basic(){
    String str = "abc def ghi";

    String actualResult[] = str.split(" ");
    String[] expectedResult = new String[] {"abc","def","ghi"};

    assertArrayEquals(expectedResult, actualResult);
  }

}
