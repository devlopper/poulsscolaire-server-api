package org.cyk.system.poulsscolaire.server.api.fee;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un frais ajusté.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AdjustedFeeDto extends AbstractAmountContainerDto {

  @JsonbProperty(JSON_FEE_IDENTIFIER)
  private String feeIdentifier;

  @JsonbProperty(JSON_FEE_OPTIONAL)
  private Boolean feeOptional;
  
  @JsonbProperty(JSON_FEE_AS_STRING)
  private String feeAsString;
  
  @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
  private String registrationIdentifier;

  @JsonbProperty(JSON_REGISTRATION_AS_STRING)
  private String registrationAsString;

  @JsonbProperty(JSON_AMOUNT_VALUE_PAID)
  private Integer amountValuePaid;

  @JsonbProperty(JSON_AMOUNT_VALUE_PAID_AS_STRING)
  private String amountValuePaidAsString;

  @JsonbProperty(JSON_AMOUNT_VALUE_LEFT_TO_PAY)
  private Integer amountValueLeftToPay;

  @JsonbProperty(JSON_AMOUNT_VALUE_LEFT_TO_PAY_AS_STRING)
  private String amountValueLeftToPayAsString;
  
  public static final String FIELD_FEE_IDENTIFIER = "feeIdentifier";
  public static final String FIELD_FEE_OPTIONAL = "feeOptional";
  public static final String FIELD_FEE_AS_STRING = "feeAsString";
  public static final String FIELD_REGISTRATION_IDENTIFIER = "registrationIdentifier";
  public static final String FIELD_REGISTRATION_AS_STRING = "registrationAsString";
  public static final String FIELD_AMOUNT_VALUE_PAID = "amountValuePaid";
  public static final String FIELD_AMOUNT_VALUE_PAID_AS_STRING = "amountValuePaidAsString";
  public static final String FIELD_AMOUNT_VALUE_LEFT_TO_PAY = "amountValueLeftToPay";
  public static final String FIELD_AMOUNT_VALUE_LEFT_TO_PAY_AS_STRING =
      "amountValueLeftToPayAsString";

  public static final String JSON_FEE_IDENTIFIER = "idFrais";
  public static final String JSON_FEE_AS_STRING = "fraisChaine";
  public static final String JSON_FEE_OPTIONAL = "fraisFacultatif";
  public static final String JSON_REGISTRATION_IDENTIFIER = "idInscription";
  public static final String JSON_REGISTRATION_AS_STRING = "inscriptionChaine";
  public static final String JSON_AMOUNT_VALUE_PAID = "valeurPayeMontant";
  public static final String JSON_AMOUNT_VALUE_PAID_AS_STRING = "valeurPayeMontantChaine";
  public static final String JSON_AMOUNT_VALUE_LEFT_TO_PAY = "valeurResteAPayerMontant";
  public static final String JSON_AMOUNT_VALUE_LEFT_TO_PAY_AS_STRING =
      "valeurResteAPayerMontantChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "frais ajusté";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "frais ajustés";
}
