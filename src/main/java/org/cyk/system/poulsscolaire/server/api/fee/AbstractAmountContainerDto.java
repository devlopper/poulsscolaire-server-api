package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente la base de conteneur de montant.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractAmountContainerDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_AMOUNT_IDENTIFIER)
  private String amountIdentifier;
  
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  @JsonbProperty(JSON_AMOUNT_VALUE)
  private int amountValue;

  @JsonbProperty(JSON_AMOUNT_VALUE_AS_STRING)
  private String amountValueAsString;

  @JsonbProperty(JSON_AMOUNT_REGISTRATION_VALUE_PART)
  private Long amountRegistrationValuePart;

  @JsonbProperty(JSON_AMOUNT_REGISTRATION_VALUE_PART_AS_STRING)
  private String amountRegistrationValuePartAsString;

  @JsonbProperty(JSON_AMOUNT_OPTIONAL)
  private Boolean amountOptional;

  @JsonbProperty(JSON_AMOUNT_OPTIONAL_AS_STRING)
  private String amountOptionalAsString;

  @JsonbProperty(JSON_AMOUNT_PAYMENT_ORDER_NUMBER)
  private Integer amountPaymentOrderNumber;

  @JsonbProperty(JSON_AMOUNT_PAYMENT_ORDER_NUMBER_AS_STRING)
  private String amountPaymentOrderNumberAsString;

  @JsonbProperty(JSON_AMOUNT_RENEWABLE)
  private Boolean amountRenewable;

  @JsonbProperty(JSON_AMOUNT_RENEWABLE_AS_STRING)
  private String amountRenewableAsString;

  @JsonbProperty(JSON_AMOUNT_DEADLINE_IDENTIFIER)
  private String amountDeadlineIdentifier;

  @JsonbProperty(JSON_AMOUNT_DEADLINE_AS_STRING)
  private String amountDeadlineAsString;

  public static final String FIELD_AMOUNT_IDENTIFIER = "amountIdentifier";
  public static final String FIELD_AMOUNT_AS_STRING = "amountAsString";
  public static final String FIELD_AMOUNT_VALUE = "amountValue";
  public static final String FIELD_AMOUNT_VALUE_AS_STRING = "amountValueAsString";
  public static final String FIELD_AMOUNT_REGISTRATION_VALUE_PART = "amountRegistrationValuePart";
  public static final String FIELD_AMOUNT_REGISTRATION_VALUE_PART_AS_STRING =
      "amountRegistrationValuePartAsString";
  public static final String FIELD_AMOUNT_OPTIONAL = "amountOptional";
  public static final String FIELD_AMOUNT_OPTIONAL_AS_STRING = "amountOptionalAsString";
  public static final String FIELD_AMOUNT_PAYMENT_ORDER_NUMBER = "amountPaymentOrderNumber";
  public static final String FIELD_AMOUNT_PAYMENT_ORDER_NUMBER_AS_STRING =
      "amountPaymentOrderNumberAsString";
  public static final String FIELD_AMOUNT_RENEWABLE = "amountRenewable";
  public static final String FIELD_AMOUNT_RENEWABLE_AS_STRING = "amountRenewableAsString";
  public static final String FIELD_AMOUNT_DEADLINE_IDENTIFIER = "amountDeadlineIdentifier";
  public static final String FIELD_AMOUNT_DEADLINE_AS_STRING = "amountDeadlineAsString";

  public static final String JSON_AMOUNT_IDENTIFIER = "idAmount";
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  public static final String JSON_AMOUNT_VALUE = "valeurMontant";
  public static final String JSON_AMOUNT_VALUE_AS_STRING = "valeurMontantChaine";
  public static final String JSON_AMOUNT_REGISTRATION_VALUE_PART = "partValeurInscriptionMontant";
  public static final String JSON_AMOUNT_REGISTRATION_VALUE_PART_AS_STRING =
      "partValeurInscriptionMontantChaine";
  public static final String JSON_AMOUNT_OPTIONAL = "facultatifMontant";
  public static final String JSON_AMOUNT_OPTIONAL_AS_STRING = "facultatifMontantChaine";
  public static final String JSON_AMOUNT_PAYMENT_ORDER_NUMBER = "numeroOrdrePaiementMontant";
  public static final String JSON_AMOUNT_PAYMENT_ORDER_NUMBER_AS_STRING =
      "numeroOrdrePaiementMontantChaine";
  public static final String JSON_AMOUNT_RENEWABLE = "reconductibleMontant";
  public static final String JSON_AMOUNT_RENEWABLE_AS_STRING = "reconductibleMontantChaine";
  public static final String JSON_AMOUNT_DEADLINE_IDENTIFIER = "idEcheanceMontant";
  public static final String JSON_AMOUNT_DEADLINE_AS_STRING = "echeanceMontantChaine";
}
