package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AmountStatisticsTest {

  AmountStatisticsDto dto = new AmountStatisticsDto();

  @Test
  void initializeWithValue() {
    AmountStatisticable statisticable = new AmountStatisticable() {

      @Override
      public String getTotalRegistrationAmountAsString() {
        return null;
      }

      @Override
      public String getTotalAmountAsString() {
        return null;
      }

      @Override
      public String getPayableRegistrationAmountAsString() {
        return null;
      }

      @Override
      public String getPayableAmountAsString() {
        return null;
      }

      @Override
      public String getPaidRegistrationAmountAsString() {
        return null;
      }

      @Override
      public String getPaidAmountAsString() {
        return null;
      }
    };
    dto.initializeWithValue(statisticable);
    assertEquals(statisticable.getTotalAmountAsString(), dto.getTotalAsString());
  }

  @Test
  void initializeWithRegistration() {
    AmountStatisticable statisticable = new AmountStatisticable() {

      @Override
      public String getTotalRegistrationAmountAsString() {
        return null;
      }

      @Override
      public String getTotalAmountAsString() {
        return null;
      }

      @Override
      public String getPayableRegistrationAmountAsString() {
        return null;
      }

      @Override
      public String getPayableAmountAsString() {
        return null;
      }

      @Override
      public String getPaidRegistrationAmountAsString() {
        return null;
      }

      @Override
      public String getPaidAmountAsString() {
        return null;
      }
    };
    dto.initializeWithRegistration(statisticable);
    assertEquals(statisticable.getTotalRegistrationAmountAsString(), dto.getTotalAsString());
  }

}
