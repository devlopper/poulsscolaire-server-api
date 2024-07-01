package org.cyk.system.poulsscolaire.server.api.fee;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente les statistiques de montant.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AmountStatisticsDto {

  /**
   * Représentation en chaine de caractères du montant total.
   */
  @JsonbProperty(JSON_TOTAL_AS_STRING)
  private String totalAsString;

  /**
   * Représentation en chaine de caractères du montant payé.
   */
  @JsonbProperty(JSON_PAID_AS_STRING)
  private String paidAsString;

  /**
   * Représentation en chaine de caractères du montant restant à payer.
   */
  @JsonbProperty(JSON_PAYABLE_AS_STRING)
  private String payableAsString;

  /**
   * Cette méthode permet d'initialiser à partir d'un {@link AmountStatisticable}.
   *
   * @param statisticable {@link AmountStatisticable}
   */
  public void initializeWithValue(AmountStatisticable statisticable) {
    totalAsString = statisticable.getTotalAmountAsString();
    paidAsString = statisticable.getPaidAmountAsString();
    payableAsString = statisticable.getPayableAmountAsString();
  }

  /**
   * Cette méthode permet d'initialiser à partir de la part inscription d'un
   * {@link AmountStatisticable}.
   *
   * @param statisticable {@link AmountStatisticable}
   */
  public void initializeWithRegistration(AmountStatisticable statisticable) {
    totalAsString = statisticable.getTotalRegistrationAmountAsString();
    paidAsString = statisticable.getPaidRegistrationAmountAsString();
    payableAsString = statisticable.getPayableRegistrationAmountAsString();
  }

  public static final String JSON_TOTAL_AS_STRING = "totalChaine";
  public static final String JSON_PAID_AS_STRING = "payeChaine";
  public static final String JSON_PAYABLE_AS_STRING = "payableChaine";

}
