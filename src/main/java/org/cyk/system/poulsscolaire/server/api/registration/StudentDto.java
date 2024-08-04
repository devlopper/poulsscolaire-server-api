package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.core.Core;
import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import java.time.LocalDateTime;
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

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;

  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;

  @JsonbProperty(JSON_REGISTRATION_NUMBER)
  private String registrationNumber;

  @JsonbProperty(JSON_FIRST_NAME)
  private String firstName;

  @JsonbProperty(JSON_ARABIC_FIRST_NAME)
  private String arabicFirstName;
  
  @JsonbProperty(JSON_LAST_NAMES)
  private String lastNames;

  @JsonbProperty(JSON_ARABIC_LAST_NAMES)
  private String arabicLastNames;
  
  @JsonbProperty(JSON_BLOOD_GROUP)
  private BloodGroup bloodGroup;
  
  @JsonbProperty(JSON_BLOOD_GROUP_AS_STRING)
  private String bloodGroupAsString;
  
  @JsonbProperty(JSON_GENDER_IDENTIFIER)
  private String genderIdentifier;

  @JsonbProperty(JSON_GENDER_AS_STRING)
  private String genderAsString;
  
  @JsonbProperty(JSON_IS_MASCULINE)
  private Boolean isMasculine;
  
  @JsonbProperty(JSON_BIRTH_DATE)
  private LocalDateTime birthDate;

  @JsonbProperty(JSON_BIRTH_DATE_AS_STRING)
  private String birthDateAsString;

  @JsonbProperty(JSON_BIRTH_PLACE)
  private String birthPlace;

  @JsonbProperty(JSON_BIRTH_CERTIFICATE_REFERENCE)
  private String birthCertificateReference;
  
  @JsonbProperty(JSON_NATIONALITY)
  private String nationality;
  
  @JsonbProperty(JSON_ORIGIN_SCHOOL)
  private String originSchool;
  
  @JsonbProperty(JSON_RESIDENCE)
  private String residence;
  
  @JsonbProperty(JSON_SITUATION)
  private String situation;
  
  @JsonbProperty(JSON_PROFESSION)
  private String profession;
  
  @JsonbProperty(JSON_EMAIL_ADDRESS)
  private String emailAddress;

  @JsonbProperty(JSON_PHONE_NUMBER)
  private String phoneNumber;
  
  @JsonbProperty(JSON_OTHERS_CONTACTS)
  private String othersContacts;
  
  /* Father */
  
  @JsonbProperty(JSON_FATHER_AS_STRING)
  private String fatherAsString;

  /* Mother */
  
  @JsonbProperty(JSON_MOTHER_AS_STRING)
  private String motherAsString;

  /* Tutor */
  
  @JsonbProperty(JSON_TUTOR_AS_STRING)
  private String tutorAsString;

  /* Schooling */
  
  @JsonbProperty(JSON_BRANCH_AS_STRING)
  private String branchAsString;

  @JsonbProperty(JSON_ASSIGNMENT_TYPE_AS_STRING)
  private String assignmentTypeAsString;

  @JsonbProperty(JSON_SENIORITY_AS_STRING)
  private String seniorityAsString;

  /**
   * Cette méthode permet de calculer la représentation en chaine de caractères.
   *
   * @param code code
   * @param registrationNumber matricule
   * @param firstName nom
   * @param lastNames prénoms
   * @return représentation en chaine de caractères
   */
  public static String computeAsString(String code, String registrationNumber, String firstName,
      String lastNames) {
    return String.format("%s - %s %s",
        Core.getOrDefaultIfNull(Core.getOrNullifyIfStringBlank(registrationNumber), code),
        firstName, lastNames);
  }

  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";
  public static final String JSON_ORIGIN_SCHOOL = "ecoleOrigine";
  
  public static final String JSON_REGISTRATION_NUMBER = "matricule";
  
  public static final String JSON_FIRST_NAME = "nom";
  public static final String JSON_ARABIC_FIRST_NAME = "nomArabe";
  public static final String JSON_LAST_NAMES = "prenoms";
  public static final String JSON_ARABIC_LAST_NAMES = "prenomsArabe";
  public static final String JSON_BLOOD_GROUP = "groupeSanguin";
  public static final String JSON_BLOOD_GROUP_AS_STRING = "groupeSanguinChaine";
  
  public static final String JSON_GENDER_IDENTIFIER = "idGenre";
  public static final String JSON_GENDER_AS_STRING = "genreChaine";
  public static final String JSON_IS_MASCULINE = "estMasculin";
  public static final String JSON_BIRTH_DATE = "dateNaissance";
  public static final String JSON_BIRTH_CERTIFICATE_REFERENCE = "referenceExtraiNaissance";
  public static final String JSON_BIRTH_DATE_AS_STRING = "dateNaissanceChaine";
  public static final String JSON_BIRTH_PLACE = "lieuNaissance";
  public static final String JSON_BIRTH_PLACE_AS_STRING = "lieuNaissanceChaine";
  
  public static final String JSON_NATIONALITY = "nationalite";
  public static final String JSON_PROFESSION = "profession";
  public static final String JSON_SITUATION = "situation";
  public static final String JSON_RESIDENCE = "residence";
  
  public static final String JSON_EMAIL_ADDRESS = "adresseEmail";
  public static final String JSON_PHONE_NUMBER = "numeroTelephone";
  public static final String JSON_OTHERS_CONTACTS = "autresContacts";
  
  public static final String JSON_FATHER_AS_STRING = "pereChaine";
  public static final String JSON_MOTHER_AS_STRING = "mereChaine";
  public static final String JSON_TUTOR_AS_STRING = "tuteurChaine";
  
  public static final String JSON_BRANCH_AS_STRING = "brancheChaine";
  public static final String JSON_ASSIGNMENT_TYPE_AS_STRING = "typeAffectationChaine";
  public static final String JSON_SENIORITY_AS_STRING = "ancienneteChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "élève";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}
