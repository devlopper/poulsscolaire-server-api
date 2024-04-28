package org.cyk.system.poulsscolaire.server.api.payment;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un paiement de frais ajusté.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PaymentAdjustedFeeDto extends AbstractIdentifiableAuditableDto {
  
  @JsonbProperty(JSON_PAYMENT_IDENTIFIER)
  private String paymentIdentifier;
  
  @JsonbProperty(JSON_PAYMENT_AS_STRING)
  private String paymentAsString;
  
  @JsonbProperty(JSON_ADJUSTED_FEE_IDENTIFIER)
  private String adjustedFeeIdentifier;
  
  @JsonbProperty(JSON_ADJUSTED_FEE_AS_STRING)
  private String adjustedFeeAsString;
    
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  @JsonbProperty(JSON_DATE_AS_STRING)
  private String dateAsString;
  
  public static final String FIELD_PAYMENT_IDENTIFIER = "paymentIdentifier";
  public static final String FIELD_PAYMENT_AS_STRING = "paymentAsString";
  public static final String FIELD_ADJUSTED_FEE_IDENTIFIER = "adjustedFeeIdentifier";
  public static final String FIELD_ADJUSTED_FEE_AS_STRING = "adjustedFeeAsString";
  public static final String FIELD_AMOUNT_AS_STRING = "amountAsString";
  public static final String FIELD_DATE_AS_STRING = "dateAsString";
  
  public static final String JSON_PAYMENT_IDENTIFIER = "idPaiement";
  public static final String JSON_PAYMENT_AS_STRING = "paiementChaine";
  public static final String JSON_ADJUSTED_FEE_IDENTIFIER = "idFraisAjuste";
  public static final String JSON_ADJUSTED_FEE_AS_STRING = "fraisAjusteChaine";
  public static final String JSON_AMOUNT = "montant";
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  public static final String JSON_DATE_AS_STRING = "dateChaine";
}
