package org.cyk.system.poulsscolaire.server.api.fee;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un frais ajusté.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AdjustedFeeDto extends AbstractAmountContainerDto {

  /* From Fee */

  @JsonbProperty(JSON_FEE_IDENTIFIER)
  private String feeIdentifier;

  @JsonbProperty(JSON_FEE_OPTIONAL)
  private Boolean feeOptional;

  @JsonbProperty(JSON_FEE_AS_STRING)
  private String feeAsString;

  @JsonbProperty(JSON_FEE_CATEGORY_AS_STRING)
  private String feeCategoryAsString;

  /* From Registration */

  @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
  private String registrationIdentifier;

  @JsonbProperty(JSON_REGISTRATION_AS_STRING)
  private String registrationAsString;

  @JsonbProperty(JSON_REGISTRATION_STUDENT_AS_STRING)
  private String registrationStudentAsString;

  @JsonbProperty(JSON_REGISTRATION_SCHOOLING_AS_STRING)
  private String registrationSchoolingAsString;

  @JsonbProperty(JSON_REGISTRATION_SCHOOLING_SCHOOL_AS_STRING)
  private String registrationSchoolingSchoolAsString;

  @JsonbProperty(JSON_REGISTRATION_SCHOOLING_BRANCH_AS_STRING)
  private String registrationSchoolingBranchAsString;

  @JsonbProperty(JSON_REGISTRATION_SCHOOLING_PERIOD_AS_STRING)
  private String registrationSchoolingPeriodAsString;

  @JsonbProperty(JSON_REGISTRATION_SENIORITY_AS_STRING)
  private String registrationSeniorityAsString;

  @JsonbProperty(JSON_REGISTRATION_ASSIGNMENT_TYPE_AS_STRING)
  private String registrationAssignmentTypeAsString;

  /* From Amount */

  @JsonbProperty(JSON_AMOUNT_VALUE_PAID)
  private Long amountValuePaid;

  @JsonbProperty(JSON_AMOUNT_VALUE_PAID_AS_STRING)
  private String amountValuePaidAsString;

  @JsonbProperty(JSON_AMOUNT_VALUE_PAYABLE)
  private Long amountValuePayable;

  @JsonbProperty(JSON_AMOUNT_VALUE_PAYABLE_AS_STRING)
  private String amountValuePayableAsString;

  public static final String FIELD_FEE_IDENTIFIER = "feeIdentifier";
  public static final String FIELD_FEE_OPTIONAL = "feeOptional";
  public static final String FIELD_FEE_AS_STRING = "feeAsString";
  public static final String FIELD_REGISTRATION_IDENTIFIER = "registrationIdentifier";
  public static final String FIELD_REGISTRATION_AS_STRING = "registrationAsString";
  public static final String FIELD_AMOUNT_VALUE_PAID = "amountValuePaid";
  public static final String FIELD_AMOUNT_VALUE_PAID_AS_STRING = "amountValuePaidAsString";
  public static final String FIELD_AMOUNT_VALUE_PAYABLE = "amountValuePayable";
  public static final String FIELD_AMOUNT_VALUE_PAYABLE_AS_STRING = "amountValuePayableAsString";

  /* Fee */
  public static final String JSON_FEE_IDENTIFIER = "idFrais";
  public static final String JSON_FEE_AS_STRING = "fraisChaine";
  public static final String JSON_FEE_OPTIONAL = "fraisFacultatif";
  public static final String JSON_FEE_CATEGORY_AS_STRING = "categorieFraisChaine";
  public static final String JSON_FEE_CATEGORY_IDENTIFIER = "idCategorieFrais";
  /* Registration */
  public static final String JSON_REGISTRATION_IDENTIFIER = "idInscription";
  public static final String JSON_REGISTRATION_AS_STRING = "inscriptionChaine";
  public static final String JSON_REGISTRATION_STUDENT_AS_STRING = "inscriptionEleveChaine";
  public static final String JSON_REGISTRATION_STUDENT_IDENTIFIER = "idEleve";
  public static final String JSON_REGISTRATION_SCHOOLING_AS_STRING = "inscriptionScolariteChaine";
  public static final String JSON_REGISTRATION_SCHOOLING_SCHOOL_AS_STRING =
      "inscriptionScolariteEcoleChaine";
  public static final String JSON_REGISTRATION_SCHOOLING_SCHOOL_IDENTIFIER =
      "idEcole";
  public static final String JSON_REGISTRATION_SCHOOLING_BRANCH_AS_STRING =
      "inscriptionScolariteBrancheChaine";
  public static final String JSON_REGISTRATION_SCHOOLING_BRANCH_IDENTIFIER =
      "idBranche";
  public static final String JSON_REGISTRATION_SCHOOLING_PERIOD_AS_STRING =
      "inscriptionScolaritePeriodeChaine";
  public static final String JSON_REGISTRATION_SCHOOLING_PERIOD_IDENTIFIER =
      "idPeriode";
  public static final String JSON_REGISTRATION_SENIORITY_AS_STRING = "inscriptionAncienneteChaine";
  public static final String JSON_REGISTRATION_ASSIGNMENT_TYPE_AS_STRING =
      "inscriptionTypeAffectationChaine";

  /* Amount */
  public static final String JSON_AMOUNT_VALUE_PAID = "valeurPayeMontant";
  public static final String JSON_AMOUNT_VALUE_PAID_AS_STRING = "valeurPayeMontantChaine";
  public static final String JSON_AMOUNT_VALUE_PAYABLE = "montantValeurPayable";
  public static final String JSON_AMOUNT_VALUE_PAYABLE_AS_STRING =
      JSON_AMOUNT_VALUE_PAYABLE + "Chaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "frais ajusté";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "frais ajustés";
}
