package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.BranchDto;

/**
 * Cette classe représente une décision de subvention.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SubsidyDecisionDto extends AbstractIdentifiableCodableNamableAuditableDto {
  
  @JsonbProperty(JSON_BRANCH_IDENTIFIER)
  private String branchIdentifier;

  @JsonbProperty(JSON_BRANCH_AS_STRING)
  private String branchAsString;
  
  @JsonbProperty(JSON_AMOUNT)
  private Integer amount;
  
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  public static final String JSON_BRANCH_IDENTIFIER = BranchDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_BRANCH_AS_STRING = BranchDto.JSON_THIS_AS_STRING;
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
