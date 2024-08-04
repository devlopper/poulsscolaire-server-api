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
  
  @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
  private String registrationIdentifier;
  
  @JsonbProperty(JSON_STUDENT_AS_STRING)
  private String studentAsString;
  
  @JsonbProperty(JSON_PERIOD_AS_STRING)
  private String periodAsString;
  
  @JsonbProperty(JSON_MODE_IDENTIFIER)
  private String modeIdentifier;
  
  @JsonbProperty(JSON_MODE_AS_STRING)
  private String modeAsString;
  
  @JsonbProperty(JSON_AMOUNT)
  private Integer amount;
  
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  @JsonbProperty(JSON_DATE_AS_STRING)
  private String dateAsString;
  
  @JsonbProperty(JSON_CANCELED)
  private Boolean canceled;
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
  public static final String JSON_PERIOD_IDENTIFIER = "idPeriode";
  public static final String JSON_PERIOD_AS_STRING = "periodeChaine";
  public static final String JSON_STUDENT_AS_STRING = "eleveChaine";
  public static final String JSON_REGISTRATION_IDENTIFIER = "idInscription";
  public static final String JSON_MODE_IDENTIFIER = "idMode";
  public static final String JSON_MODE_AS_STRING = "modeChaine";
  public static final String JSON_AMOUNT = "montant";
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  public static final String JSON_DATE_AS_STRING = "dateChaine";
  public static final String JSON_CANCELED = "annule";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "paiement";
  
  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}
