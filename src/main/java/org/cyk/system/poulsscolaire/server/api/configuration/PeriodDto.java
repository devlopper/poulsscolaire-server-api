package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une période.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PeriodDto extends AbstractIdentifiableCodableNamableDto {
  /*
   * Amount
   */
  @JsonbProperty(JSON_TOTAL_AMOUNT_AS_STRING)
  private String totalAmountAsString;

  @JsonbProperty(JSON_PAID_AMOUNT_AS_STRING)
  private String paidAmountAsString;

  @JsonbProperty(JSON_PAYABLE_AMOUNT_AS_STRING)
  private String payableAmountAsString;

  /*
   * Registration amount
   */
  @JsonbProperty(JSON_TOTAL_REGISTRATION_AMOUNT_AS_STRING)
  private String totalRegistrationAmountAsString;

  @JsonbProperty(JSON_PAID_REGISTRATION_AMOUNT_AS_STRING)
  private String paidRegistrationAmountAsString;

  @JsonbProperty(JSON_PAYABLE_REGISTRATION_AMOUNT_AS_STRING)
  private String payableRegistrationAmountAsString;
  
  public static final String FIELD_TOTAL_AMOUNT_AS_STRING = "totalAmountAsString";
  public static final String FIELD_PAID_AMOUNT_AS_STRING = "paidAmountAsString";
  public static final String FIELD_PAYABLE_AMOUNT_AS_STRING = "payableAmountAsString";

  public static final String FIELD_TOTAL_REGISTRATION_AMOUNT_AS_STRING =
      "totalRegistrationAmountAsString";
  public static final String FIELD_PAID_REGISTRATION_AMOUNT_AS_STRING =
      "paidRegistrationAmountAsString";
  public static final String FIELD_PAYABLE_REGISTRATION_AMOUNT_AS_STRING =
      "payableRegistrationAmountAsString";
  
  public static final String JSON_TOTAL_AMOUNT_AS_STRING = "montantTotalChaine";
  public static final String JSON_PAID_AMOUNT_AS_STRING = "montantPayeChaine";
  public static final String JSON_PAYABLE_AMOUNT_AS_STRING = "montantPayableChaine";

  public static final String JSON_TOTAL_REGISTRATION_AMOUNT_AS_STRING =
      "montantInscriptionTotalChaine";
  public static final String JSON_PAID_REGISTRATION_AMOUNT_AS_STRING =
      "montantInscriptionPayeChaine";
  public static final String JSON_PAYABLE_REGISTRATION_AMOUNT_AS_STRING =
      "montantInscriptionPayableChaine";
  
  public static final String JSON_OPENED = "ouvert";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "période";
  
  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}
