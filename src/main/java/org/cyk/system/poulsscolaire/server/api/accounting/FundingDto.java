package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import java.time.LocalDateTime;
import java.time.Month;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingStatusUpdateResponseDto;
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

  @JsonbProperty(JSON_COMMITMENT_AMOUNT_AS_STRING)
  private String commitmentAmountAsString;

  @JsonbProperty(JSON_INPUT_DEADLINE)
  private LocalDateTime inputDeadline;
  
  @JsonbProperty(JSON_INPUT_DEADLINE_AS_STRING)
  private String inputDeadlineAsString;
  
  /* Status Start */

  /**
   * Statut du programme triennal.
   */
  @JsonbProperty(JSON_STATUS)
  private FundingStatus status;

  /**
   * Statut du programme triennal au format chaine de caractère.
   */
  @JsonbProperty(JSON_STATUS_AS_STRING)
  private String statusAsString;

  /**
   * Raison du statut.
   */
  @JsonbProperty(JSON_STATUS_REASON)
  private String statusReason;

  /**
   * Transmittable.
   */
  @JsonbProperty(JSON_TRANSMITABLE)
  private Boolean transmitable;

  /**
   * Acceptable.
   */
  @JsonbProperty(JSON_ACCEPTABLE)
  private Boolean acceptable;

  /**
   * Retournable.
   */
  @JsonbProperty(JSON_RETURNABLE)
  private Boolean returnable;

  /**
   * Approuvable.
   */
  @JsonbProperty(JSON_APPROVABLE)
  private Boolean approvable;

  /* Status End */

  /**
   * Cette méthode permet de copier à partir d'une réponse de changement de statut.
   *
   * @param statusUpdateResponse {@link FundingStatusUpdateResponseDto}
   */
  public void copy(FundingStatusUpdateResponseDto statusUpdateResponse) {
    status = statusUpdateResponse.getStatus();
    statusAsString = statusUpdateResponse.getStatusAsString();
    statusReason = statusUpdateResponse.getReason();
    transmitable = statusUpdateResponse.getTransmitable();
    acceptable = statusUpdateResponse.getAcceptable();
    approvable = statusUpdateResponse.getApprovable();
    returnable = statusUpdateResponse.getReturnable();
  }
  
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

  public static final String JSON_COMMITMENT_AMOUNT_AS_STRING = "montantEngageChaine";

  public static final String JSON_JUSTIFICATION = "justification";

  public static final String JSON_INPUT_DEADLINE = "delaiSaisie";
  
  public static final String JSON_INPUT_DEADLINE_AS_STRING = "delaiSaisieChaine";
  
  /**
   * Identifiant json champ {@link #status}.
   */
  public static final String JSON_STATUS = "statut";

  /**
   * Identifiant json champ {@link #statusAsString}.
   */
  public static final String JSON_STATUS_AS_STRING = "statutChaine";

  /**
   * Identifiant json champ {@link #acceptable}.
   */
  public static final String JSON_ACCEPTABLE = "acceptable";

  /**
   * Identifiant json champ {@link #transmitable}.
   */
  public static final String JSON_TRANSMITABLE = "transmettable";

  /**
   * Identifiant json champ {@link #returnable}.
   */
  public static final String JSON_RETURNABLE = "retournable";

  /**
   * Identifiant json champ {@link #approvable}.
   */
  public static final String JSON_APPROVABLE = "approuvable";

  /**
   * Identifiant json champ {@link #statusReason}.
   */
  public static final String JSON_STATUS_REASON = "raisonStatut";

  public static final String NAME = "financement";

  public static final String PLURAL_NAME = NAME + "s";
}
