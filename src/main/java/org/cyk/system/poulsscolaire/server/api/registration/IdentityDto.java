package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une identité.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class IdentityDto extends AbstractIdentifiableAuditableDto {
  
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
  
  @JsonbProperty(JSON_BIRTH_DATE)
  private LocalDateTime birthDate;
  
  @JsonbProperty(JSON_BIRTH_PLACE)
  private String birthPlace;
  
  @JsonbProperty(JSON_BIRTH_CERTIFICATE_REFERENCE)
  private String birthCertificateReference;
  
  @JsonbProperty(JSON_RELATIONSHIP_PARENT_IDENTIFIER)
  private String relationshipParentIdentifier;
  
  @JsonbProperty(JSON_PROFESSION)
  private String profession;
  
  @JsonbProperty(JSON_RESIDENCE)
  private String residence;
  
  @JsonbProperty(JSON_HEALTH_STATUS)
  private String healthStatus;
  
  @JsonbProperty(JSON_RELATIONSHIP_CHILD_IDENTIFIER)
  private String relationshipChildIdentifier;
  
  @JsonbProperty(JSON_RELATIONSHIP_TYPE)
  private IdentityRelationshipType relationshipType;
  
  @JsonbProperty(JSON_RELATIONSHIP_TYPE_AS_STRING)
  private String relationshipTypeAsString;
  
  @JsonbProperty(JSON_RELATIONSHIP_TYPE_PARENT_AS_STRING)
  private String relationshipTypeParentAsString;
  
  public static final String JSON_REGISTRATION_NUMBER = "matricule";
  
  public static final String JSON_FIRST_NAME = "nom";
  public static final String JSON_ARABIC_FIRST_NAME = "nomArabe";
  public static final String JSON_LAST_NAMES = "prenoms";
  public static final String JSON_ARABIC_LAST_NAMES = "prenomsArabe";
  
  public static final String JSON_BLOOD_GROUP = "groupeSanguin";
  
  public static final String JSON_GENDER_IDENTIFIER = "idGenre";
  public static final String JSON_GENDER_AS_STRING = "genreChaine";
  public static final String JSON_IS_MASCULINE = "estMasculin";
  
  public static final String JSON_BIRTH_DATE = "dateNaissance";
  public static final String JSON_BIRTH_PLACE = "lieuNaissance";
  public static final String JSON_BIRTH_CERTIFICATE_REFERENCE = "referenceExtraitNaissance";
  
  public static final String JSON_NATIONALITY = "nationalite";
  public static final String JSON_SITUATION = "situation";
  public static final String JSON_PROFESSION = "profession";
  public static final String JSON_RESIDENCE = "residence";
  
  public static final String JSON_EMAIL_ADDRESS = "adresseEmail";
  public static final String JSON_PHONE_NUMBER = "numeroTelephone";
  public static final String JSON_OTHERS_CONTACTS = "autresContacts";
  public static final String JSON_HEALTH_STATUS = "etatSante";
  
  public static final String JSON_RELATIONSHIP_PARENT_IDENTIFIER = "idParentRelation";
  public static final String JSON_RELATIONSHIP_CHILD_IDENTIFIER = "idEnfantRelation";
  public static final String JSON_RELATIONSHIP_TYPE = "idTypeRelation";
  public static final String JSON_RELATIONSHIP_TYPE_AS_STRING = "idTypeRelationChaine";
  public static final String JSON_RELATIONSHIP_TYPE_PARENT_AS_STRING = "idTypeRelationParentChaine";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "identité";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}
