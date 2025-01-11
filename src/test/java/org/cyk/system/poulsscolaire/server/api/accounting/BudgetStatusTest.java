package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BudgetStatusTest {

  @Test
  void getByName() {
    assertEquals(BudgetStatus.CREATED,
        BudgetStatus.getByCode(BudgetStatusCode.CREATED));
  }

  @Test
  void testToString() {
    assertEquals(BudgetStatus.CREATED.getName(),
        BudgetStatus.CREATED.toString());
  }

  @Test
  void isWorkflowStepInput_whenCreated() {
    assertTrue(BudgetStatus.CREATED.isWorkflowStepInput());
  }

  @Test
  void isWorkflowStepInput_whenTransmitted() {
    assertFalse(BudgetStatus.TRANSMITTED.isWorkflowStepInput());
  }

  @ParameterizedTest
  @CsvSource(value = {"CREATED,true", "TRANSMITTED,false", "ACCEPTED,false", "APPROVED,false",
      "RETURNED,true"})
  void isAmountUpdatable(BudgetStatus status, boolean expected) {
    assertEquals(status.isAmountUpdatable(), expected);
  }
  
  @ParameterizedTest
  @CsvSource(value = {"CREATED,false", "TRANSMITTED,true", "ACCEPTED,true", "APPROVED,false",
      "RETURNED,false"})
  void isCommentUpdatable(BudgetStatus status, boolean expected) {
    assertEquals(status.isCommentUpdatable(), expected);
  }
}
