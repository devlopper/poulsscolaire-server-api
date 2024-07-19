package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une échéance de paiement de frais ajusté.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AdjustedFeePaymentDeadlineDto extends AbstractIdentifiableAuditableDto {
  
  @JsonbProperty(JSON_ADJUSTED_FEE_IDENTIFIER)
  private String adjustedFeeIdentifier;
  
  @JsonbProperty(JSON_ADJUSTED_FEE_AS_STRING)
  private String adjustedFeeAsString;
  
  @JsonbProperty(JSON_DEADLINE_IDENTIFIER)
  private String deadlineIdentifier;
  
  @JsonbProperty(JSON_DEADLINE_AS_STRING)
  private String deadlineAsString;
  
  @JsonbProperty(JSON_AMOUNT)
  private Integer amount;
  
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  public static final String JSON_ADJUSTED_FEE_IDENTIFIER = "idFraisAjuste";
  public static final String JSON_ADJUSTED_FEE_AS_STRING = "fraisAjusteChaine";
  public static final String JSON_DEADLINE_IDENTIFIER = "idEcheance";
  public static final String JSON_DEADLINE_AS_STRING = "echeanceChaine";
  public static final String JSON_AMOUNT = "montant";
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "échéance de paiement";
  
  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "échéances de paiement";
}
