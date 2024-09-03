package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractAuditedRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.response.AbstractGetByPageResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link IdentityDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = IdentityService.PATH)
@Tag(name = "Gestion des identités")
public interface IdentityService extends SpecificService {

  String PATH = "identites";

  String CREATE_IDENTIFIER = "CREATION_IDENTITE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une identité.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une identité",
      description = "Ce service permet de créer une identité")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(IdentityCreateRequestDto request);

  /**
   * Cette interface représente une reuqête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface IdentitySaveRequest {
    String getRegistrationNumber();

    void setRegistrationNumber(String registrationNumber);

    String getFirstName();

    void setFirstName(String firstName);

    String getArabicFirstName();

    void setArabicFirstName(String arabicFirstName);

    String getLastNames();

    void setLastNames(String lastNames);

    String getArabicLastNames();

    void setArabicLastNames(String arabicLastNames);

    String getGenderIdentifier();

    void setGenderIdentifier(String genderIdentifier);

    BloodGroup getBloodGroup();

    void setBloodGroup(BloodGroup bloodGroup);

    LocalDateTime getBirthDate();

    void setBirthDate(LocalDateTime birthDate);

    String getBirthPlace();

    void setBirthPlace(String birthPlace);

    String getBirthCertificateReference();

    void setBirthCertificateReference(String birthCertificateReference);

    String getNationality();

    void setNationality(String nationality);

    String getSituation();

    void setSituation(String situation);

    String getProfession();

    void setProfession(String profession);

    String getResidence();

    void setResidence(String residence);

    String getEmailAddress();

    void setEmailAddress(String emailAddress);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getOthersContacts();

    void setOthersContacts(String othersContacts);
    
    String getHealthStatus();

    void setHealthStatus(String healthStatus);
    
    String getRelationshipParentIdentifier();

    void setRelationshipParentIdentifier(String relationshipParentIdentifier);
    
    String getRelationshipChildIdentifier();

    void setRelationshipChildIdentifier(String relationshipChildIdentifier);
    
    IdentityRelationshipType getRelationshipType();

    void setRelationshipType(IdentityRelationshipType relationshipType);

    String JSON_REGISTRATION_NUMBER = IdentityDto.JSON_REGISTRATION_NUMBER;
    String JSON_FIRST_NAME = IdentityDto.JSON_FIRST_NAME;
    String JSON_ARABIC_FIRST_NAME = IdentityDto.JSON_ARABIC_FIRST_NAME;
    String JSON_LAST_NAMES = IdentityDto.JSON_LAST_NAMES;
    String JSON_ARABIC_LAST_NAMES = IdentityDto.JSON_ARABIC_LAST_NAMES;
    String JSON_GENDER_IDENTIFIER = IdentityDto.JSON_GENDER_IDENTIFIER;
    String JSON_BLOOD_GROUP = IdentityDto.JSON_BLOOD_GROUP;
    String JSON_BIRTH_DATE = IdentityDto.JSON_BIRTH_DATE;
    String JSON_BIRTH_PLACE = IdentityDto.JSON_BIRTH_PLACE;
    String JSON_BIRTH_CERTIFICATE_REFERENCE = IdentityDto.JSON_BIRTH_CERTIFICATE_REFERENCE;
    String JSON_NATIONALITY = IdentityDto.JSON_NATIONALITY;
    String JSON_SITUATION = IdentityDto.JSON_SITUATION;
    String JSON_PROFESSION = IdentityDto.JSON_PROFESSION;
    String JSON_RESIDENCE = IdentityDto.JSON_RESIDENCE;
    String JSON_EMAIL_ADDRESS = IdentityDto.JSON_EMAIL_ADDRESS;
    String JSON_PHONE_NUMBER = IdentityDto.JSON_PHONE_NUMBER;
    String JSON_OTHERS_CONTACTS = IdentityDto.JSON_OTHERS_CONTACTS;
    String JSON_HEALTH_STATUS = IdentityDto.JSON_HEALTH_STATUS;
    String JSON_RELATIONSHIP_PARENT_IDENTIFIER = IdentityDto.JSON_RELATIONSHIP_PARENT_IDENTIFIER;
    String JSON_RELATIONSHIP_CHILD_IDENTIFIER = IdentityDto.JSON_RELATIONSHIP_CHILD_IDENTIFIER;
    String JSON_RELATIONSHIP_TYPE = IdentityDto.JSON_RELATIONSHIP_TYPE;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class IdentityCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements IdentitySaveRequest {
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

    @JsonbProperty(JSON_GENDER_IDENTIFIER)
    private String genderIdentifier;

    @JsonbProperty(JSON_BLOOD_GROUP)
    private BloodGroup bloodGroup;

    @JsonbProperty(JSON_BIRTH_DATE)
    private LocalDateTime birthDate;

    @JsonbProperty(JSON_BIRTH_PLACE)
    private String birthPlace;

    @JsonbProperty(JSON_BIRTH_CERTIFICATE_REFERENCE)
    private String birthCertificateReference;

    @JsonbProperty(JSON_NATIONALITY)
    private String nationality;

    @JsonbProperty(JSON_SITUATION)
    private String situation;

    @JsonbProperty(JSON_PROFESSION)
    private String profession;

    @JsonbProperty(JSON_RESIDENCE)
    private String residence;

    @JsonbProperty(JSON_EMAIL_ADDRESS)
    private String emailAddress;

    @JsonbProperty(JSON_PHONE_NUMBER)
    private String phoneNumber;

    @JsonbProperty(JSON_OTHERS_CONTACTS)
    private String othersContacts;

    @JsonbProperty(JSON_HEALTH_STATUS)
    private String healthStatus;
    
    @JsonbProperty(JSON_RELATIONSHIP_PARENT_IDENTIFIER)
    private String relationshipParentIdentifier;

    @JsonbProperty(JSON_RELATIONSHIP_CHILD_IDENTIFIER)
    private String relationshipChildIdentifier;

    @JsonbProperty(JSON_RELATIONSHIP_TYPE)
    private IdentityRelationshipType relationshipType;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_IDENTITE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des identités")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class IdentityGetManyResponseDto extends AbstractGetByPageResponseDto<IdentityDto> {

    @JsonbProperty(JSON_DATAS)
    private List<IdentityDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_IDENTITE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une identité")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_IDENTITE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une identité")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_IDENTITE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une identité")
  Response update(IdentityUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class IdentityUpdateRequestDto extends ByIdentifierRequestDto implements IdentitySaveRequest {
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

    @JsonbProperty(JSON_GENDER_IDENTIFIER)
    private String genderIdentifier;

    @JsonbProperty(JSON_BLOOD_GROUP)
    private BloodGroup bloodGroup;

    @JsonbProperty(JSON_BIRTH_DATE)
    private LocalDateTime birthDate;

    @JsonbProperty(JSON_BIRTH_PLACE)
    private String birthPlace;

    @JsonbProperty(JSON_BIRTH_CERTIFICATE_REFERENCE)
    private String birthCertificateReference;

    @JsonbProperty(JSON_NATIONALITY)
    private String nationality;

    @JsonbProperty(JSON_SITUATION)
    private String situation;

    @JsonbProperty(JSON_PROFESSION)
    private String profession;

    @JsonbProperty(JSON_RESIDENCE)
    private String residence;

    @JsonbProperty(JSON_EMAIL_ADDRESS)
    private String emailAddress;

    @JsonbProperty(JSON_PHONE_NUMBER)
    private String phoneNumber;

    @JsonbProperty(JSON_OTHERS_CONTACTS)
    private String othersContacts;
    
    @JsonbProperty(JSON_HEALTH_STATUS)
    private String healthStatus;
    
    @JsonbProperty(JSON_RELATIONSHIP_PARENT_IDENTIFIER)
    private String relationshipParentIdentifier;

    @JsonbProperty(JSON_RELATIONSHIP_CHILD_IDENTIFIER)
    private String relationshipChildIdentifier;

    @JsonbProperty(JSON_RELATIONSHIP_TYPE)
    private IdentityRelationshipType relationshipType;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_IDENTITE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une identité")
  Response delete(DeleteOneRequestDto request);
}
