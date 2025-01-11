package org.cyk.system.poulsscolaire.server.api.accounting;


import ci.gouv.dgbf.extension.core.Core;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lombok.Getter;

/**
 * Cette classe représente les statuts de {@link BudgetDto}.
 *
 * @author Christian
 *
 */
@Getter
public enum BudgetStatus {

  /**
   * Créé.
   */
  CREATED(BudgetStatusCode.CREATED, "Créé", "Créer", "Création", WorkflowStep.INPUT),

  /**
   * Transmis.
   */
  TRANSMITTED(BudgetStatusCode.TRANSMITTED, "Transmis", "Transmettre", "Transmission",
      WorkflowStep.VALIDATION),

  /**
   * Accepté.
   */
  ACCEPTED(BudgetStatusCode.ACCEPTED, "Accepté", "Accepter", "Acceptation",
      WorkflowStep.APPROVAL),

  /**
   * Retourné.
   */
  RETURNED(BudgetStatusCode.RETURNED, "Retourné", "Retourner", "Retour",
      WorkflowStep.INPUT),

  /**
   * Approuvé.
   */
  APPROVED(BudgetStatusCode.APPROVED, "Approuvé", "Approuver", "Approbation", null);

  private BudgetStatus(String code, String name, String action, String actionName,
      WorkflowStep workflowStep) {
    this.code = code;
    this.name = name;
    this.action = action;
    this.actionName = actionName;
    this.workflowStep = workflowStep;
  }

  private String code;
  private String name;
  private String action;
  private String actionName;
  private WorkflowStep workflowStep;
  private Set<BudgetStatus> previous;

  /**
   * Cette méthode permet de savoir si {@link BudgetStatus} correspond à
   * {@link WorkflowStep#INPUT}.
   *
   * @return vrai sinon faux
   */
  public boolean isWorkflowStepInput() {
    return WorkflowStep.INPUT.equals(workflowStep);
  }

  /**
   * Cette méthode permet de savoir si le montant est modifiable.
   *
   * @return vrai si le montant est modifiable sinon faux
   */
  public boolean isAmountUpdatable() {
    return isWorkflowStepInput();
  }

  /**
   * Cette méthode permet de savoir si le commentaire est modifiable.
   *
   * @return vrai si le commentaire est modifiable sinon faux
   */
  public boolean isCommentUpdatable() {
    return WorkflowStep.VALIDATION.equals(workflowStep)
        || WorkflowStep.APPROVAL.equals(workflowStep);
  }

  @Override
  public String toString() {
    return name;
  }

  /**
   * Cette méthode permet d'obtenir le statut par code.
   *
   * @param code code
   * @return statut
   */
  public static BudgetStatus getByCode(String code) {
    return Stream.of(BudgetStatus.values())
        .filter(status -> status.getCode().equals(code)).findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  static {
    CREATED.previous = Collections.emptySet();
    TRANSMITTED.previous = Core.getSet(List.of(CREATED, RETURNED));
    ACCEPTED.previous = Core.getSet(List.of(TRANSMITTED));
    RETURNED.previous = Core.getSet(List.of(TRANSMITTED, ACCEPTED));
    APPROVED.previous = Core.getSet(List.of(TRANSMITTED, ACCEPTED));
  }

  /**
   * Cette classe représente les étapes du circuit de travail.
   *
   * @author Christian
   *
   */
  @Getter
  public enum WorkflowStep {
    /**
     * Saisie.
     */
    INPUT("Saisie", "Saisir les montants des financements. "
        + "Ensuite, veuillez transmettre pour validation"),
    /**
     * Validation.
     */
    VALIDATION("Validation", "Vérifier les montants des financements. "
        + "Accepter si vous êtes d'accord sinon retouner à la saisie"),
    /**
     * Approbation.
     */
    APPROVAL("Approbation", "Vérifier les montants des financements. "
        + "Approuver si vous êtes d'accord sinon retouner à la saisie");

    private String name;
    private String description;

    private WorkflowStep(String name, String description) {
      this.name = name;
      this.description = description;
    }
  }
}
