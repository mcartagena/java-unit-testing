package com.mcartagena.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

  StringHelper helper = new StringHelper();

  @Test
  public void TestTruncateAInFirst2Positions_AIn2FirstPositions(){
    assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
  }

  @Test
  public void TestTruncateAInFirst2Positions_AInFirstPosition(){
    assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
  }

  @Test
  public void TestAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario(){
    assertFalse("The condition failed", helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
  }

  @Test
  public void TestAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario(){
    assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
  }


}
