package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractAuditedRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.response.AbstractGetByPageResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {IdentityCreateRequestDto.FIELD_FIRST_NAME,
      IdentityCreateRequestDto.FIELD_LAST_NAMES, IdentityCreateRequestDto.FIELD_EMAIL_ADDRESS,
      IdentityCreateRequestDto.FIELD_PHONE_NUMBER, IdentityCreateRequestDto.FIELD_GENDER_IDENTIFIER,
      AbstractRequestDto.FIELD_AUDIT_WHO, AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class IdentityCreateRequestDto extends AbstractAuditedRequestJsonDto implements IdentityData {
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

    public static final String FIELD_FIRST_NAME = "firstName";
    public static final String FIELD_LAST_NAMES = "lastNames";
    public static final String FIELD_EMAIL_ADDRESS = "emailAddress";
    public static final String FIELD_PHONE_NUMBER = "phoneNumber";
    public static final String FIELD_GENDER_IDENTIFIER = "genderIdentifier";
  }

  /**
   * Cette interface représente les informations d'identité.
   *
   * @author Christian
   *
   */
  interface IdentityData {
    String getFirstName();

    String getLastNames();

    String getEmailAddress();

    String getPhoneNumber();

    String getGenderIdentifier();

    String JSON_FIRST_NAME = IdentityDto.JSON_FIRST_NAME;
    String JSON_LAST_NAMES = IdentityDto.JSON_LAST_NAMES;
    String JSON_EMAIL_ADDRESS = IdentityDto.JSON_EMAIL_ADDRESS;
    String JSON_PHONE_NUMBER = IdentityDto.JSON_PHONE_NUMBER;
    String JSON_GENDER_IDENTIFIER = IdentityDto.JSON_GENDER_IDENTIFIER;
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
  public static class GetManyResponseDto extends AbstractGetByPageResponseDto<IdentityDto> {

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
  @JsonbPropertyOrder(value = {ByIdentifierRequestDto.FIELD_IDENTIFIER,
      IdentityUpdateRequestDto.FIELD_FIRST_NAME, IdentityUpdateRequestDto.FIELD_LAST_NAMES,
      IdentityUpdateRequestDto.FIELD_EMAIL_ADDRESS, IdentityUpdateRequestDto.FIELD_PHONE_NUMBER,
      IdentityUpdateRequestDto.FIELD_GENDER_IDENTIFIER, AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class IdentityUpdateRequestDto extends ByIdentifierRequestDto implements IdentityData {
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

    public static final String FIELD_FIRST_NAME = "firstName";
    public static final String FIELD_LAST_NAMES = "lastNames";
    public static final String FIELD_EMAIL_ADDRESS = "emailAddress";
    public static final String FIELD_PHONE_NUMBER = "phoneNumber";
    public static final String FIELD_GENDER_IDENTIFIER = "genderIdentifier";
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
