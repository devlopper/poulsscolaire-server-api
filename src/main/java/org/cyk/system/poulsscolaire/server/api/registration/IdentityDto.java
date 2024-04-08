package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
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
  
  public static final String FIELD_FIRST_NAME = "firstName";
  public static final String FIELD_LAST_NAMES = "lastNames";
  public static final String FIELD_EMAIL_ADDRESS = "emailAddress";
  public static final String FIELD_PHONE_NUMBER = "phoneNumber";
  public static final String FIELD_GENDER_AS_STRING = "genderAsString";
  public static final String FIELD_IS_MASCULINE = "isMasculine";
  
  public static final String JSON_FIRST_NAME = "nom";
  public static final String JSON_LAST_NAMES = "prenoms";
  public static final String JSON_EMAIL_ADDRESS = "adresseEmail";
  public static final String JSON_PHONE_NUMBER = "numeroTelephone";
  public static final String JSON_GENDER_IDENTIFIER = "idGenre";
  public static final String JSON_GENDER_AS_STRING = "genreChaine";
  public static final String JSON_IS_MASCULINE = "estMasculin";
}
