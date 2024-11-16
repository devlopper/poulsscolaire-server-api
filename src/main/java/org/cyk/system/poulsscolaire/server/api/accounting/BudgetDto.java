package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolDto;

/**
 * Cette classe représente un budget.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class BudgetDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;

  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;

  @JsonbProperty(JSON_PLAN_IDENTIFIER)
  private String planIdentifier;

  @JsonbProperty(JSON_PLAN_AS_STRING)
  private String planAsString;

  @JsonbProperty(JSON_YEAR)
  private Integer year;
  
  @JsonbProperty(JSON_YEAR_AS_STRING)
  private String yearAsString;

  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;

  public static final String JSON_THIS_IDENTIFIER = "idBudget";

  public static final String JSON_THIS_AS_STRING = "budgetChaine";

  public static final String JSON_SCHOOL_IDENTIFIER = SchoolDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_SCHOOL_AS_STRING = SchoolDto.JSON_THIS_AS_STRING;

  public static final String JSON_PLAN_IDENTIFIER = AccountingPlanDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_PLAN_AS_STRING = AccountingPlanDto.JSON_THIS_AS_STRING;

  public static final String JSON_YEAR = "annee";
  
  public static final String JSON_YEAR_AS_STRING = "anneeChaine";

  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";

  public static final String NAME = "budget";

  public static final String PLURAL_NAME = NAME + "s";
}
