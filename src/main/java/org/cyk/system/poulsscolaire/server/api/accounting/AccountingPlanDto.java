package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un plan comptable.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AccountingPlanDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;
  
  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
  
  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";
  
  public static final String NAME = "plan comptable";
  
  public static final String PLURAL_NAME = "plans comptables";
}
