package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un compte comptable d'une école.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AccountingAccountSchoolDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_ACCOUNT_IDENTIFIER)
  private String accountIdentifier;

  @JsonbProperty(JSON_ACCOUNT_AS_STRING)
  private String accountAsString;

  @JsonbProperty(JSON_PLAN_AS_STRING)
  private String planAsString;
  
  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;

  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;
  
  public static final String JSON_ACCOUNT_IDENTIFIER = "idCompte";

  public static final String JSON_ACCOUNT_AS_STRING = "compteChaine";

  public static final String JSON_PLAN_AS_STRING = "planChaine";
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";

  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";
  
  public static final String NAME = "compte comptable d'école";

  public static final String PLURAL_NAME = "comptes comptables d'écoles";
}
