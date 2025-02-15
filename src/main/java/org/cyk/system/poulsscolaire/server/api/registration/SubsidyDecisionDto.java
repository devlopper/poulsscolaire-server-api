package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingDto;

/**
 * Cette classe représente une décision de subvention.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SubsidyDecisionDto extends AbstractIdentifiableCodableAuditableDto {
  
  @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
  private String schoolingIdentifier;

  @JsonbProperty(JSON_SCHOOLING_AS_STRING)
  private String schoolingAsString;
  
  @JsonbProperty(JSON_AMOUNT)
  private Integer amount;
  
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  public static final String JSON_THIS_IDENTIFIER = "idDecisionSubvention";

  public static final String JSON_THIS_AS_STRING = "decisionSubventionChaine";
  
  public static final String JSON_SCHOOLING_IDENTIFIER = SchoolingDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_SCHOOLING_AS_STRING = SchoolingDto.JSON_THIS_AS_STRING;
  public static final String JSON_AMOUNT = "montant";
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "décision de subvention";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "décisions de subvention";
}
