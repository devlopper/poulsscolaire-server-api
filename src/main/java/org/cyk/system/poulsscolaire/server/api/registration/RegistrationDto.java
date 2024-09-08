package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.fee.AmountStatisticable;

/**
 * Cette classe représente une inscription.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RegistrationDto extends AbstractIdentifiableCodableAuditableDto
    implements AmountStatisticable {

  @JsonbProperty(JSON_STUDENT_IDENTIFIER)
  private String studentIdentifier;

  @JsonbProperty(JSON_STUDENT_AS_STRING)
  private String studentAsString;

  @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
  private String schoolingIdentifier;
  
  @JsonbProperty(JSON_BRANCH_INSTANCE_IDENTIFIER)
  private String branchInstanceIdentifier;
  
  @JsonbProperty(JSON_SCHOOLING_2_IDENTIFIER)
  private String schooling2Identifier;

  @JsonbProperty(JSON_BRANCH_INSTANCE_2_IDENTIFIER)
  private String branchInstance2Identifier;
  
  @JsonbProperty(JSON_SCHOOLING_AS_STRING)
  private String schoolingAsString;

  @JsonbProperty(JSON_ASSIGNMENT_TYPE_IDENTIFIER)
  private String assignmentTypeIdentifier;

  @JsonbProperty(JSON_ASSIGNMENT_TYPE_AS_STRING)
  private String assignmentTypeAsString;

  @JsonbProperty(JSON_SENIORITY_IDENTIFIER)
  private String seniorityIdentifier;

  @JsonbProperty(JSON_SENIORITY_AS_STRING)
  private String seniorityAsString;

  @JsonbProperty(JSON_PRE_REGISTRATION_AMOUNT)
  private Integer preRegistrationAmount;

  @JsonbProperty(JSON_PRE_REGISTRATION_AMOUNT_AS_STRING)
  private String preRegistrationAmountAsString;
  
  @JsonbProperty(JSON_BRANCH_INSTANCE_AS_STRING)
  private String branchInstanceAsString;
  
  /*
   * Amount
   */
  @JsonbProperty(JSON_TOTAL_AMOUNT_AS_STRING)
  private String totalAmountAsString;

  @JsonbProperty(JSON_PAID_AMOUNT_AS_STRING)
  private String paidAmountAsString;

  @JsonbProperty(JSON_PAYABLE_AMOUNT_AS_STRING)
  private String payableAmountAsString;

  /*
   * Registration amount
   */
  @JsonbProperty(JSON_TOTAL_REGISTRATION_AMOUNT_AS_STRING)
  private String totalRegistrationAmountAsString;

  @JsonbProperty(JSON_PAID_REGISTRATION_AMOUNT_AS_STRING)
  private String paidRegistrationAmountAsString;

  @JsonbProperty(JSON_PAYABLE_REGISTRATION_AMOUNT_AS_STRING)
  private String payableRegistrationAmountAsString;

  public static final String FIELD_STUDENT_IDENTIFIER = "studentIdentifier";
  public static final String FIELD_STUDENT_AS_STRING = "studentAsString";
  public static final String FIELD_SCHOOLING_IDENTIFIER = "schoolingIdentifier";
  public static final String FIELD_SCHOOLING_AS_STRING = "schoolingAsString";
  public static final String FIELD_ASSIGNMENT_TYPE_IDENTIFIER = "assignmentTypeIdentifier";
  public static final String FIELD_ASSIGNMENT_TYPE_AS_STRING = "assignmentTypeAsString";
  public static final String FIELD_SENIORITY_IDENTIFIER = "seniorityIdentifier";
  public static final String FIELD_SENIORITY_AS_STRING = "seniorityAsString";

  public static final String FIELD_TOTAL_AMOUNT_AS_STRING = "totalAmountAsString";
  public static final String FIELD_PAID_AMOUNT_AS_STRING = "paidAmountAsString";
  public static final String FIELD_PAYABLE_AMOUNT_AS_STRING = "payableAmountAsString";

  public static final String FIELD_TOTAL_REGISTRATION_AMOUNT_AS_STRING =
      "totalRegistrationAmountAsString";
  public static final String FIELD_PAID_REGISTRATION_AMOUNT_AS_STRING =
      "paidRegistrationAmountAsString";
  public static final String FIELD_PAYABLE_REGISTRATION_AMOUNT_AS_STRING =
      "payableRegistrationAmountAsString";

  public static final String JSON_STUDENT_IDENTIFIER = "idEleve";
  public static final String JSON_STUDENT_AS_STRING = "eleveChaine";
  public static final String JSON_SCHOOLING_IDENTIFIER = "idScolarite";
  public static final String JSON_SCHOOLING_2_IDENTIFIER = "idScolarite2";
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
  public static final String JSON_PERIOD_IDENTIFIER = "idPeriod";
  public static final String JSON_SCHOOLING_AS_STRING = "scolariteChaine";
  public static final String JSON_ASSIGNMENT_TYPE_IDENTIFIER = "idTypeAffectation";
  public static final String JSON_ASSIGNMENT_TYPE_AS_STRING = "typeAffectationChaine";
  public static final String JSON_SENIORITY_IDENTIFIER = "idAnciennete";
  public static final String JSON_SENIORITY_AS_STRING = "ancienneteChaine";
  public static final String JSON_BRANCH_INSTANCE_IDENTIFIER = "idClasse";
  public static final String JSON_BRANCH_INSTANCE_2_IDENTIFIER = "idClasse2";
  
  public static final String JSON_PRE_REGISTRATION_AMOUNT = "montantPreInscription";
  public static final String JSON_PRE_REGISTRATION_AMOUNT_AS_STRING = "montantPreInscriptionChaine";
  
  public static final String JSON_TOTAL_AMOUNT_AS_STRING = "montantTotalChaine";
  public static final String JSON_PAID_AMOUNT_AS_STRING = "montantPayeChaine";
  public static final String JSON_PAYABLE_AMOUNT_AS_STRING = "montantPayableChaine";
  
  public static final String JSON_BRANCH_INSTANCE_AS_STRING = "classeChaine";

  public static final String JSON_TOTAL_REGISTRATION_AMOUNT_AS_STRING =
      "montantInscriptionTotalChaine";
  public static final String JSON_PAID_REGISTRATION_AMOUNT_AS_STRING =
      "montantInscriptionPayeChaine";
  public static final String JSON_PAYABLE_REGISTRATION_AMOUNT_AS_STRING =
      "montantInscriptionPayableChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "inscription";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}
