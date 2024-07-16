package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une scolarité.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SchoolingDto extends AbstractIdentifiableCodableAuditableDto {

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;

  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;

  @JsonbProperty(JSON_BRANCH_IDENTIFIER)
  private String branchIdentifier;

  @JsonbProperty(JSON_BRANCH_AS_STRING)
  private String branchAsString;

  @JsonbProperty(JSON_PERIOD_IDENTIFIER)
  private String periodIdentifier;

  @JsonbProperty(JSON_PERIOD_AS_STRING)
  private String periodAsString;

  @JsonbProperty(JSON_PRE_REGISTRATION_AMOUNT)
  private Integer preRegistrationAmount;

  @JsonbProperty(JSON_PRE_REGISTRATION_AMOUNT_AS_STRING)
  private String preRegistrationAmountAsString;

  @JsonbProperty(JSON_FEE_AMOUNT_VALUE)
  private Integer feeAmountValue;

  @JsonbProperty(JSON_FEE_AMOUNT_VALUE_AS_STRING)
  private String feeAmountValueAsString;

  @JsonbProperty(JSON_NOT_OPTIONAL_FEE_AMOUNT_VALUE)
  private Integer notOptionalFeeAmountValue;

  @JsonbProperty(JSON_NOT_OPTIONAL_FEE_AMOUNT_VALUE_AS_STRING)
  private String notOptionalFeeAmountValueAsString;

  @JsonbProperty(JSON_FEE_AMOUNT_REGISTRATION_VALUE_PART)
  private Integer feeAmountRegistrationValuePart;

  @JsonbProperty(JSON_FEE_AMOUNT_REGISTRATION_VALUE_PART_AS_STRING)
  private String feeAmountRegistrationValuePartAsString;

  @JsonbProperty(JSON_NOT_OPTIONAL_FEE_AMOUNT_REGISTRATION_VALUE_PART)
  private Integer notOptionalFeeAmountRegistrationValuePart;

  @JsonbProperty(JSON_NOT_OPTIONAL_FEE_AMOUNT_REGISTRATION_VALUE_PART_AS_STRING)
  private String notOptionalFeeAmountRegistrationValuePartAsString;

  public static final String JSON_PRE_REGISTRATION_AMOUNT = "montantPreInscription";
  public static final String JSON_PRE_REGISTRATION_AMOUNT_AS_STRING = "montantPreInscriptionChaine";
  public static final String JSON_FEE_AMOUNT_VALUE = "montantFrais";
  public static final String JSON_FEE_AMOUNT_VALUE_AS_STRING = "montantFraisChaine";
  public static final String JSON_NOT_OPTIONAL_FEE_AMOUNT_VALUE = "montantFraisNonFacultatif";
  public static final String JSON_NOT_OPTIONAL_FEE_AMOUNT_VALUE_AS_STRING =
      "montantFraisNonFacultatifChaine";
  public static final String JSON_FEE_AMOUNT_REGISTRATION_VALUE_PART =
      "montantFraisPartValeurInscription";
  public static final String JSON_FEE_AMOUNT_REGISTRATION_VALUE_PART_AS_STRING =
      "montantFraisPartValeurInscriptionChaine";
  public static final String JSON_NOT_OPTIONAL_FEE_AMOUNT_REGISTRATION_VALUE_PART =
      "montantFraisPartValeurInscriptionNonFacultatif";
  public static final String JSON_NOT_OPTIONAL_FEE_AMOUNT_REGISTRATION_VALUE_PART_AS_STRING =
      "montantFraisPartValeurInscriptionNonFacultatifChaine";
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";
  public static final String JSON_BRANCH_IDENTIFIER = "idBranche";
  public static final String JSON_BRANCH_AS_STRING = "brancheChaine";
  public static final String JSON_PERIOD_IDENTIFIER = "idPeriode";
  public static final String JSON_PERIOD_AS_STRING = "periodeChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "scolarité";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}
