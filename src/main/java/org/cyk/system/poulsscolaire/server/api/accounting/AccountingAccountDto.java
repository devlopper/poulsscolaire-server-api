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
@EqualsAndHashCode(callSuper = true)
public class AccountingAccountDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_PLAN_IDENTIFIER)
  private String planIdentifier;

  @JsonbProperty(JSON_PLAN_AS_STRING)
  private String planAsString;

  @JsonbProperty(JSON_TYPE)
  private AccountingAccountType type;

  @JsonbProperty(JSON_TYPE_AS_STRING)
  private String typeAsString;
  
  public static final String JSON_PLAN_IDENTIFIER = "idPlanComptable";

  public static final String JSON_PLAN_AS_STRING = "planComptableChaine";

  public static final String JSON_TYPE = "type";

  public static final String JSON_TYPE_AS_STRING = "typeChaine";
  
  public static final String NAME = "compte comptable";

  public static final String PLURAL_NAME = "comptes comptables";
}
