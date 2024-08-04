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
import org.cyk.system.poulsscolaire.server.api.registration.IdentityService.IdentitySaveRequest;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link StudentDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = StudentService.PATH)
@Tag(name = "Gestion des élèves")
public interface StudentService extends SpecificService {

  String PATH = "eleves";

  String CREATE_IDENTIFIER = "CREATION_ELEVE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer un élève.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'un élève",
      description = "Ce service permet de créer un élève")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(StudentCreateRequestDto request);

  /**
   * Cette classe représente la requete d'enregistrement.
   *
   * @author Christian
   *
   */
  interface StudentSaveRequestDto extends IdentitySaveRequest {

    String getSchoolIdentifier();

    void setSchoolIdentifier(String schoolIdentifier);

    String getOriginSchool();

    void setOriginSchool(String originSchool);

    String JSON_SCHOOL_IDENTIFIER = StudentDto.JSON_SCHOOL_IDENTIFIER;
    String JSON_ORIGIN_SCHOOL = StudentDto.JSON_ORIGIN_SCHOOL;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StudentCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements StudentSaveRequestDto {

    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_ORIGIN_SCHOOL)
    private String originSchool;

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
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_ELEVE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des élèves")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class StudentGetManyResponseDto extends AbstractGetByPageResponseDto<StudentDto> {

    @JsonbProperty(JSON_DATAS)
    private List<StudentDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_ELEVE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER, description = "Ce service permet d'obtenir un élève")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_ELEVE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant un élève")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_ELEVE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour un élève")
  Response update(StudentUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StudentUpdateRequestDto extends ByIdentifierRequestDto implements StudentSaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_ORIGIN_SCHOOL)
    private String originSchool;

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
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_ELEVE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer un élève")
  Response delete(DeleteOneRequestDto request);
}
