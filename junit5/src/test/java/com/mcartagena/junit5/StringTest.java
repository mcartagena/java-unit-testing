package com.mcartagena.junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

  private String str;

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
  @Disabled // @Ignored in JUnit4
  void length_basic() {
    assertEquals("ABCD".length(), 4);
  }

  @Test
  @DisplayName("When lenght is null, throw an exception")
  void length_exception(){
    String str = null;
    assertThrows(NullPointerException.class, () -> {
      str.length();
    });
  }

  @Test
  void length_greater_than_zero(){
    assertTrue("ABCD".length()>0);
    assertTrue("ABC".length()>0);
    assertTrue("A".length()>0);
    assertTrue("DEF".length()>0);
  }

  @ParameterizedTest
  @ValueSource(strings = { "ABCD", "ABC", "A", "DEF" })
  void length_greater_than_zero_using_parameterized_test(String str){
    assertTrue(str.length()>0);
  }

  @ParameterizedTest(name = "{0} toUpperCase is {1}")
  @CsvSource(value = { "abcd, ABCD", "abc, ABC", "'',''", "abcdefg, ABCDEFG" })
  void uppercase(String word, String capitalizedWord){
    assertEquals(capitalizedWord, word.toUpperCase());
  }

  @ParameterizedTest(name = "{0} length is {1}")
  @CsvSource(value = { "abcd, 4", "abc, 3", "'',0", "abcdefg, 7" })
  void length(String word, int expectedLength){
    assertEquals(expectedLength, word.length());
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
  @RepeatedTest(10)
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

  @Test
  @Disabled
  void performanceTest(){
    assertTimeout(Duration.ofSeconds(5), 
      () -> {
        for(int i=0;i<=1000000;i++){
          int j = i;
          System.out.println(j);
        }
      }
    );
  }

  @Nested
  @DisplayName("For an empty String")
  class EmptyStringTests {
    @BeforeEach
    void setToEmpty() {
      str = "";
      System.out.println("Before each empty string test");
    }

    @Test
    @DisplayName("length should be zero")
    void lengthIsZero() {
      assertEquals(0, str.length());
    }

    @Test
    @DisplayName("uppercase is empty")
    void uppercaseIsEmpty() {
      assertEquals("", str.toUpperCase());
    }


  }

  @Nested
  @DisplayName("For large Strings")
  class LargeStringTests {
    @BeforeEach
    void setToLargeString() {
      str = "fsafhskjfhskjfslkjflskjdslfjslkfjslfhslfhslfjslkdj";
      System.out.println("Before each large string test");
    }

    @Test
    void largeIsGreater10(){
      assertTrue(str.length()>10);
    }

    @Test
    void largeStringContainsSubString(){
      assertEquals("fsaf", str.substring(0, 4));
    }

  }


}
