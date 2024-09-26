package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une opération comptable.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AccountingOperationDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;

  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;

  @JsonbProperty(JSON_PLAN_IDENTIFIER)
  private String planIdentifier;

  @JsonbProperty(JSON_PLAN_AS_STRING)
  private String planAsString;
  
  @JsonbProperty(JSON_ACCOUNT_TYPE)
  private AccountingAccountType accountType;

  @JsonbProperty(JSON_ACCOUNT_TYPE_AS_STRING)
  private String accountTypeAsString;

  @JsonbProperty(JSON_BENEFICIARY)
  private String beneficiary;

  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";

  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";
  
  public static final String JSON_PLAN_IDENTIFIER = "idPlan";

  public static final String JSON_PLAN_AS_STRING = "planChaine";

  public static final String JSON_ACCOUNT_TYPE = "typeCompte";

  public static final String JSON_ACCOUNT_TYPE_AS_STRING = "typeCompteChaine";

  public static final String JSON_BENEFICIARY = "beneficiaire";

  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  
  public static final String NAME = "opération comptable";

  public static final String PLURAL_NAME = "opérations comptables";
}
