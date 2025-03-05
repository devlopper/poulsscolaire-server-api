package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FundingStatusTest {

  @Test
  void getByName() {
    assertEquals(FundingStatus.CREATED,
        FundingStatus.getByCode(FundingStatusCode.CREATED));
  }

  @Test
  void testToString() {
    assertEquals(FundingStatus.CREATED.getName(),
        FundingStatus.CREATED.toString());
  }

  @Test
  void isWorkflowStepInput_whenCreated() {
    assertTrue(FundingStatus.CREATED.isWorkflowStepInput());
  }

  @Test
  void isWorkflowStepInput_whenTransmitted() {
    assertFalse(FundingStatus.TRANSMITTED.isWorkflowStepInput());
  }

  @ParameterizedTest
  @CsvSource(value = {"CREATED,true", "TRANSMITTED,false", "ACCEPTED,false", "APPROVED,false",
      "RETURNED,true"})
  void isAmountUpdatable(FundingStatus status, boolean expected) {
    assertEquals(status.isAmountUpdatable(), expected);
  }
  
  @ParameterizedTest
  @CsvSource(value = {"CREATED,false", "TRANSMITTED,true", "ACCEPTED,true", "APPROVED,false",
      "RETURNED,false"})
  void isCommentUpdatable(FundingStatus status, boolean expected) {
    assertEquals(status.isCommentUpdatable(), expected);
  }
}
