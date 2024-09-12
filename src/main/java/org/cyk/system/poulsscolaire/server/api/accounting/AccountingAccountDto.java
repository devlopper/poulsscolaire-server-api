package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un compte comptable.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AccountingAccountDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_PLAN_IDENTIFIER)
  private String planIdentifier;
  
  @JsonbProperty(JSON_PLAN_AS_STRING)
  private String planAsString;
  
  public static final String JSON_PLAN_IDENTIFIER = "idPlanComptable";
  
  public static final String JSON_PLAN_AS_STRING = "planComptableChaine";
}
