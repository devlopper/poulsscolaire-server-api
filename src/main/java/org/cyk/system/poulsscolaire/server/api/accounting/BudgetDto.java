package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetService.BudgetStatusUpdateResponseDto;
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

  @JsonbProperty(JSON_ACCOUNTING_PLAN_IDENTIFIER)
  private String accountingPlanIdentifier;

  @JsonbProperty(JSON_ACCOUNTING_PLAN_AS_STRING)
  private String accountingPlanAsString;

  @JsonbProperty(JSON_YEAR)
  private Integer year;

  @JsonbProperty(JSON_YEAR_AS_STRING)
  private String yearAsString;

  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;

  @JsonbProperty(JSON_COMMITMENT_AMOUNT_AS_STRING)
  private String commitmentAmountAsString;
  
  /**
   * Statut du programme triennal.
   */
  @JsonbProperty(JSON_STATUS)
  private BudgetStatus status;

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

  /**
   * Cette méthode permet de copier à partir d'une réponse de changement de statut.
   *
   * @param statusUpdateResponse {@link TriennialProgramStatusUpdateResponseDto}
   */
  public void copy(BudgetStatusUpdateResponseDto statusUpdateResponse) {
    status = statusUpdateResponse.getStatus();
    statusAsString = statusUpdateResponse.getStatusAsString();
    statusReason = statusUpdateResponse.getReason();
    transmitable = statusUpdateResponse.getTransmitable();
    acceptable = statusUpdateResponse.getAcceptable();
    approvable = statusUpdateResponse.getApprovable();
    returnable = statusUpdateResponse.getReturnable();
  }
  
  public static final String JSON_THIS_IDENTIFIER = "idBudget";

  public static final String JSON_THIS_YEAR = "annee";
  
  public static final String JSON_THIS_AS_STRING = "budgetChaine";

  public static final String JSON_SCHOOL_IDENTIFIER = SchoolDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_SCHOOL_AS_STRING = SchoolDto.JSON_THIS_AS_STRING;

  public static final String JSON_ACCOUNTING_PLAN_IDENTIFIER =
      AccountingPlanDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_ACCOUNTING_PLAN_AS_STRING = AccountingPlanDto.JSON_THIS_AS_STRING;

  public static final String JSON_YEAR = "annee";

  public static final String JSON_YEAR_AS_STRING = "anneeChaine";

  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";

  public static final String JSON_COMMITMENT_AMOUNT_AS_STRING = "montantEngageChaine";
  
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
  
  public static final String NAME = "budget";

  public static final String PLURAL_NAME = NAME + "s";
}
