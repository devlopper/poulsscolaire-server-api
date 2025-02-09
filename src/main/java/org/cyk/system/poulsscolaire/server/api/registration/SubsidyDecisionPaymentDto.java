package org.cyk.system.poulsscolaire.server.api.registration;

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
public class SubsidyDecisionPaymentDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_SUBSIDY_DECISION_IDENTIFIER)
  private String subsidyDecisionIdentifier;

  @JsonbProperty(JSON_SUBSIDY_DECISION_AS_STRING)
  private String subsidyDecisionAsString;

  @JsonbProperty(JSON_AMOUNT)
  private Integer amount;

  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;

  public static final String JSON_SUBSIDY_DECISION_IDENTIFIER = "idPaiement";
  public static final String JSON_SUBSIDY_DECISION_AS_STRING = "paiementChaine";
  public static final String JSON_AMOUNT = "montant";
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  
  public static final String NAME = "paiement de décision de subvention";
  
  public static final String PLURAL_NAME = "paiements de décision de subvention";
}
