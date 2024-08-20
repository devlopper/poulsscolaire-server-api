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

  @JsonbProperty(JSON_FATHER_FIRST_NAME)
  private String fatherFirstName;

  @JsonbProperty(JSON_FATHER_LAST_NAMES)
  private String fatherLastNames;

  @JsonbProperty(JSON_FATHER_SITUATION)
  private String fatherSituation;

  @JsonbProperty(JSON_FATHER_PROFESSION)
  private String fatherProfession;

  @JsonbProperty(JSON_FATHER_EMAIL_ADDRESS)
  private String fatherEmailAddress;

  @JsonbProperty(JSON_FATHER_PHONE_NUMBER)
  private String fatherPhoneNumber;

  @JsonbProperty(JSON_FATHER_OTHERS_CONTACTS)
  private String fatherOthersContacts;

  @JsonbProperty(JSON_FATHER_RESIDENCE)
  private String fatherResidence;

  @JsonbProperty(JSON_FATHER_AS_STRING)
  private String fatherAsString;

  @JsonbProperty(JSON_FATHER_IDENTIFIER)
  private String fatherIdentifier;

  /* Mother */

  @JsonbProperty(JSON_MOTHER_FIRST_NAME)
  private String motherFirstName;

  @JsonbProperty(JSON_MOTHER_LAST_NAMES)
  private String motherLastNames;

  @JsonbProperty(JSON_MOTHER_SITUATION)
  private String motherSituation;

  @JsonbProperty(JSON_MOTHER_PROFESSION)
  private String motherProfession;

  @JsonbProperty(JSON_MOTHER_EMAIL_ADDRESS)
  private String motherEmailAddress;

  @JsonbProperty(JSON_MOTHER_PHONE_NUMBER)
  private String motherPhoneNumber;

  @JsonbProperty(JSON_MOTHER_OTHERS_CONTACTS)
  private String motherOthersContacts;

  @JsonbProperty(JSON_MOTHER_RESIDENCE)
  private String motherResidence;

  @JsonbProperty(JSON_MOTHER_AS_STRING)
  private String motherAsString;

  @JsonbProperty(JSON_MOTHER_IDENTIFIER)
  private String motherIdentifier;

  /* Tutor */

  @JsonbProperty(JSON_TUTOR_FIRST_NAME)
  private String tutorFirstName;

  @JsonbProperty(JSON_TUTOR_LAST_NAMES)
  private String tutorLastNames;

  @JsonbProperty(JSON_TUTOR_SITUATION)
  private String tutorSituation;

  @JsonbProperty(JSON_TUTOR_PROFESSION)
  private String tutorProfession;

  @JsonbProperty(JSON_TUTOR_EMAIL_ADDRESS)
  private String tutorEmailAddress;

  @JsonbProperty(JSON_TUTOR_PHONE_NUMBER)
  private String tutorPhoneNumber;

  @JsonbProperty(JSON_TUTOR_OTHERS_CONTACTS)
  private String tutorOthersContacts;

  @JsonbProperty(JSON_TUTOR_RESIDENCE)
  private String tutorResidence;

  @JsonbProperty(JSON_TUTOR_AS_STRING)
  private String tutorAsString;

  @JsonbProperty(JSON_TUTOR_IDENTIFIER)
  private String tutorIdentifier;

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

  private static final String JSON_FATHER_SUFFIX = "Pere";
  public static final String JSON_FATHER_FIRST_NAME = JSON_FIRST_NAME + JSON_FATHER_SUFFIX;
  public static final String JSON_FATHER_LAST_NAMES = JSON_LAST_NAMES + JSON_FATHER_SUFFIX;
  public static final String JSON_FATHER_SITUATION = JSON_SITUATION + JSON_FATHER_SUFFIX;
  public static final String JSON_FATHER_PROFESSION = JSON_PROFESSION + JSON_FATHER_SUFFIX;
  public static final String JSON_FATHER_EMAIL_ADDRESS = JSON_EMAIL_ADDRESS + JSON_FATHER_SUFFIX;
  public static final String JSON_FATHER_PHONE_NUMBER = JSON_PHONE_NUMBER + JSON_FATHER_SUFFIX;
  public static final String JSON_FATHER_OTHERS_CONTACTS =
      JSON_OTHERS_CONTACTS + JSON_FATHER_SUFFIX;
  public static final String JSON_FATHER_RESIDENCE = JSON_RESIDENCE + JSON_FATHER_SUFFIX;
  public static final String JSON_FATHER_IDENTIFIER = "id" + JSON_FATHER_SUFFIX;
  public static final String JSON_FATHER_AS_STRING = "pereChaine";

  private static final String JSON_MOTHER_SUFFIX = "Mere";
  public static final String JSON_MOTHER_FIRST_NAME = JSON_FIRST_NAME + JSON_MOTHER_SUFFIX;
  public static final String JSON_MOTHER_LAST_NAMES = JSON_LAST_NAMES + JSON_MOTHER_SUFFIX;
  public static final String JSON_MOTHER_SITUATION = JSON_SITUATION + JSON_MOTHER_SUFFIX;
  public static final String JSON_MOTHER_PROFESSION = JSON_PROFESSION + JSON_MOTHER_SUFFIX;
  public static final String JSON_MOTHER_EMAIL_ADDRESS = JSON_EMAIL_ADDRESS + JSON_MOTHER_SUFFIX;
  public static final String JSON_MOTHER_PHONE_NUMBER = JSON_PHONE_NUMBER + JSON_MOTHER_SUFFIX;
  public static final String JSON_MOTHER_OTHERS_CONTACTS =
      JSON_OTHERS_CONTACTS + JSON_MOTHER_SUFFIX;
  public static final String JSON_MOTHER_RESIDENCE = JSON_RESIDENCE + JSON_MOTHER_SUFFIX;
  public static final String JSON_MOTHER_IDENTIFIER = "id" + JSON_MOTHER_SUFFIX;
  public static final String JSON_MOTHER_AS_STRING = "mereChaine";

  private static final String JSON_TUTOR_SUFFIX = "Tuteur";
  public static final String JSON_TUTOR_FIRST_NAME = JSON_FIRST_NAME + JSON_TUTOR_SUFFIX;
  public static final String JSON_TUTOR_LAST_NAMES = JSON_LAST_NAMES + JSON_TUTOR_SUFFIX;
  public static final String JSON_TUTOR_SITUATION = JSON_SITUATION + JSON_TUTOR_SUFFIX;
  public static final String JSON_TUTOR_PROFESSION = JSON_PROFESSION + JSON_TUTOR_SUFFIX;
  public static final String JSON_TUTOR_EMAIL_ADDRESS = JSON_EMAIL_ADDRESS + JSON_TUTOR_SUFFIX;
  public static final String JSON_TUTOR_PHONE_NUMBER = JSON_PHONE_NUMBER + JSON_TUTOR_SUFFIX;
  public static final String JSON_TUTOR_OTHERS_CONTACTS = JSON_OTHERS_CONTACTS + JSON_TUTOR_SUFFIX;
  public static final String JSON_TUTOR_RESIDENCE = JSON_RESIDENCE + JSON_TUTOR_SUFFIX;
  public static final String JSON_TUTOR_IDENTIFIER = "id" + JSON_TUTOR_SUFFIX;
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
