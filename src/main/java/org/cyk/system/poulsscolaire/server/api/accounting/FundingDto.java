package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import java.time.Month;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.DepartmentDto;

/**
 * Cette classe représente un financement.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FundingDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_BUDGET_IDENTIFIER)
  private String budgetIdentifier;

  @JsonbProperty(JSON_BUDGET_AS_STRING)
  private String budgetAsString;

  @JsonbProperty(JSON_DEPARTMENT_IDENTIFIER)
  private String departmentIdentifier;

  @JsonbProperty(JSON_DEPARTMENT_AS_STRING)
  private String departmentAsString;

  @JsonbProperty(JSON_MONTH)
  private Month month;

  @JsonbProperty(JSON_MONTH_AS_STRING)
  private String monthAsString;

  @JsonbProperty(JSON_ACCOUNTING_ACCOUNT_IDENTIFIER)
  private String accountingAccountIdentifier;

  @JsonbProperty(JSON_ACCOUNTING_ACCOUNT_AS_STRING)
  private String accountingAccountAsString;

  @JsonbProperty(JSON_SOURCE_IDENTIFIER)
  private String sourceIdentifier;

  @JsonbProperty(JSON_SOURCE_AS_STRING)
  private String sourceAsString;

  @JsonbProperty(JSON_AMOUNT)
  private Long amount;
  
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;

  @JsonbProperty(JSON_AMOUNT_INPUTABLE)
  private Boolean amountInputable;
  
  @JsonbProperty(JSON_JUSTIFICATION)
  private String justification;
  
  public static final String JSON_THIS_IDENTIFIER = "idFinancement";

  public static final String JSON_THIS_AS_STRING = "financementChaine";
  
  public static final String JSON_BUDGET_IDENTIFIER = BudgetDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_BUDGET_AS_STRING = BudgetDto.JSON_THIS_AS_STRING;

  public static final String JSON_DEPARTMENT_IDENTIFIER = DepartmentDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_DEPARTMENT_AS_STRING = DepartmentDto.JSON_THIS_AS_STRING;

  public static final String JSON_MONTH = "mois";

  public static final String JSON_MONTH_AS_STRING = "moisChaine";

  public static final String JSON_ACCOUNTING_ACCOUNT_IDENTIFIER =
      AccountingAccountDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_ACCOUNTING_ACCOUNT_AS_STRING =
      AccountingAccountDto.JSON_THIS_AS_STRING;

  public static final String JSON_SOURCE_IDENTIFIER = FundingSourceDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_SOURCE_AS_STRING = FundingSourceDto.JSON_THIS_AS_STRING;

  public static final String JSON_AMOUNT = "montant";
  
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";

  public static final String JSON_AMOUNT_INPUTABLE = "montantSaisissable";
  
  public static final String JSON_JUSTIFICATION = "justification";
  
  public static final String NAME = "financement";

  public static final String PLURAL_NAME = NAME + "s";
}
