package org.cyk.system.poulsscolaire.server.api.fee;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un frais.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class FeeDto extends AbstractAmountContainerDto {

  @JsonbProperty(JSON_CATEGORY_IDENTIFIER)
  private String categoryIdentifier;
  
  @JsonbProperty(JSON_CATEGORY_AS_STRING)
  private String categoryAsString;
  
  @JsonbProperty(JSON_ASSIGNMENT_TYPE_IDENTIFIER)
  private String assignmentTypeIdentifier;
  
  @JsonbProperty(JSON_ASSIGNMENT_TYPE_AS_STRING)
  private String assignmentTypeAsString;
  
  @JsonbProperty(JSON_SENIORITY_IDENTIFIER)
  private String seniorityIdentifier;
  
  @JsonbProperty(JSON_SENIORITY_AS_STRING)
  private String seniorityAsString;
  
  @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
  private String schoolingIdentifier;
  
  @JsonbProperty(JSON_SCHOOLING_SCHOOL_AS_STRING)
  private String schoolingSchoolAsString;
  
  @JsonbProperty(JSON_SCHOOLING_PERIOD_AS_STRING)
  private String schoolingPeriodAsString;
  
  @JsonbProperty(JSON_SCHOOLING_BRANCH_AS_STRING)
  private String schoolingBranchAsString;
  
  public static final String FIELD_CATEGORY_IDENTIFIER = "categoryIdentifier";
  public static final String FIELD_CATEGORY_AS_STRING = "categoryAsString";
  public static final String FIELD_ASSIGNMENT_IDENTIFIER = "assignmentTypeIdentifier";
  public static final String FIELD_ASSIGNMENT_TYPE_AS_STRING = "assignmentTypeAsString";
  public static final String FIELD_SENIORITY_IDENTIFIER = "seniorityIdentifier";
  public static final String FIELD_SENIORITY_AS_STRING = "seniorityAsString";
  public static final String FIELD_SCHOOLING_IDENTIFIER = "schoolingIdentifier";
  public static final String FIELD_SCHOOLING_AS_STRING = "schoolingAsString";
  
  public static final String JSON_CATEGORY_IDENTIFIER = "idCategorie";
  public static final String JSON_CATEGORY_AS_STRING = "categorieChaine";
  public static final String JSON_ASSIGNMENT_TYPE_IDENTIFIER = "idTypeAffectation";
  public static final String JSON_ASSIGNMENT_TYPE_AS_STRING = "typeAffectationChaine";
  public static final String JSON_SENIORITY_IDENTIFIER = "idAnciennete";
  public static final String JSON_SENIORITY_AS_STRING = "ancienneteChaine";
  public static final String JSON_SCHOOLING_IDENTIFIER = "idScolarite";
  public static final String JSON_SCHOOLING_SCHOOL_AS_STRING = "ecoleScolariteChaine";
  public static final String JSON_SCHOOLING_PERIOD_AS_STRING = "periodeScolariteChaine";
  public static final String JSON_SCHOOLING_BRANCH_AS_STRING = "brancheScolariteChaine";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "frais";
  
  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "frais";
}
