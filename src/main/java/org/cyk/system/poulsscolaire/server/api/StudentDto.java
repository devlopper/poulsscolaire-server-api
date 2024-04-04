package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un élève.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StudentDto extends AbstractIdentifiableCodableAuditableDto {
  
  @JsonbProperty(JSON_REGISTRATION_NUMBER)
  private String registrationNumber;
  
  @JsonbProperty(JSON_FIRST_NAME)
  private String firstName;
  
  @JsonbProperty(JSON_LAST_NAMES)
  private String lastNames;
  
  @JsonbProperty(JSON_EMAIL_ADDRESS)
  private String emailAddress;
  
  @JsonbProperty(JSON_PHONE_NUMBER)
  private String phoneNumber;
  
  @JsonbProperty(JSON_GENDER_IDENTIFIER)
  private String genderIdentifier;
  
  @JsonbProperty(JSON_GENDER_AS_STRING)
  private String genderAsString;
  
  @JsonbProperty(JSON_IS_MASCULINE)
  private Boolean isMasculine;
  
  @JsonbProperty(JSON_FATHER_AS_STRING)
  private String fatherAsString;
  
  @JsonbProperty(JSON_MOTHER_AS_STRING)
  private String motherAsString;
  
  @JsonbProperty(JSON_TUTOR_AS_STRING)
  private String tutorAsString;
  
  @JsonbProperty(JSON_BRANCH_AS_STRING)
  private String branchAsString;
  
  @JsonbProperty(JSON_ASSIGNMENT_TYPE_AS_STRING)
  private String assignmentTypeAsString;
  
  @JsonbProperty(JSON_SENIORITY_AS_STRING)
  private String seniorityAsString;
  
  public static final String FIELD_REGISTRATION_NUMBER = "registrationNumber";
  public static final String FIELD_FIRST_NAME = "firstName";
  public static final String FIELD_LAST_NAMES = "lastNames";
  public static final String FIELD_EMAIL_ADDRESS = "emailAddress";
  public static final String FIELD_PHONE_NUMBER = "phoneNumber";
  public static final String FIELD_GENDER_AS_STRING = "genderAsString";
  public static final String FIELD_IS_MASCULINE = "isMasculine";
  public static final String FIELD_FATHER_AS_STRING = "fatherAsString";
  public static final String FIELD_MOTHER_AS_STRING = "motherAsString";
  public static final String FIELD_TUTOR_AS_STRING = "tutorAsString";
  public static final String FIELD_BRANCH_AS_STRING = "branchAsString";
  public static final String FIELD_ASSIGNMENT_TYPE_AS_STRING = "assignmentTypeAsString";
  public static final String FIELD_SENIORITY_AS_STRING = "seniorityAsString";
  
  public static final String JSON_REGISTRATION_NUMBER = "matricule";
  public static final String JSON_FIRST_NAME = "nom";
  public static final String JSON_LAST_NAMES = "prenoms";
  public static final String JSON_EMAIL_ADDRESS = "adresseEmail";
  public static final String JSON_PHONE_NUMBER = "numeroTelephone";
  public static final String JSON_GENDER_IDENTIFIER = "idGenre";
  public static final String JSON_GENDER_AS_STRING = "genreChaine";
  public static final String JSON_IS_MASCULINE = "estMasculin";
  public static final String JSON_FATHER_AS_STRING = "pereChaine";
  public static final String JSON_MOTHER_AS_STRING = "mereChaine";
  public static final String JSON_TUTOR_AS_STRING = "tuteurChaine";
  public static final String JSON_BRANCH_AS_STRING = "brancheChaine";
  public static final String JSON_ASSIGNMENT_TYPE_AS_STRING = "typeAffectationChaine";
  public static final String JSON_SENIORITY_AS_STRING = "ancienneteChaine";
}
