package org.cyk.system.poulsscolaire.server.api.payment;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un paiement.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PaymentDto extends AbstractIdentifiableCodableAuditableDto {
  
  @JsonbProperty(JSON_MODE_IDENTIFIER)
  private String modeIdentifier;
  
  @JsonbProperty(JSON_MODE_AS_STRING)
  private String modeAsString;
    
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  @JsonbProperty(JSON_DATE_AS_STRING)
  private String dateAsString;
  
  public static final String FIELD_MODE_IDENTIFIER = "modeIdentifier";
  public static final String FIELD_MODE_AS_STRING = "modeAsString";
  public static final String FIELD_AMOUNT_AS_STRING = "amountAsString";
  public static final String FIELD_DATE_AS_STRING = "dateAsString";
  
  public static final String JSON_MODE_IDENTIFIER = "idMode";
  public static final String JSON_MODE_AS_STRING = "modeChaine";
  public static final String JSON_AMOUNT = "montant";
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  public static final String JSON_DATE_AS_STRING = "dateChaine";
}
