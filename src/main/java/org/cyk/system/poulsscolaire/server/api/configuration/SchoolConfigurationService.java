package org.cyk.system.poulsscolaire.server.api.configuration;

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
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link SchoolConfigurationDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = SchoolConfigurationService.PATH)
@Tag(name = "Gestion des configurations d'écoles")
public interface SchoolConfigurationService extends SpecificService {

  String PATH = "configurations-ecoles";

  String CREATE_IDENTIFIER = "CREATION_CONFIGURATION_ECOLE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une configuration d'école",
      description = "Ce service permet de créer une configuration d'école")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(SchoolConfigurationCreateRequestDto request);

  /**
   * Cette classe représente la requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface SchoolConfigurationSaveRequestDto {
    String getSchoolIdentifier();

    void setSchoolIdentifier(String schoolIdentifier);

    String getPaymentAccountingAccountIdentifier();

    void setPaymentAccountingAccountIdentifier(String paymentAccountingAccountIdentifier);

    String JSON_SCHOOL_IDENTIFIER = SchoolConfigurationDto.JSON_SCHOOL_IDENTIFIER;
    String JSON_PAYMENT_ACCOUNTING_ACCOUNT_IDENTIFIER =
        SchoolConfigurationDto.JSON_PAYMENT_ACCOUNTING_ACCOUNT_IDENTIFIER;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class SchoolConfigurationCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements SchoolConfigurationSaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_PAYMENT_ACCOUNTING_ACCOUNT_IDENTIFIER)
    private String paymentAccountingAccountIdentifier;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_CONFIGURATION_ECOLE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des configurations d'écoles")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class SchoolConfigurationGetManyResponseDto
      extends AbstractGetByPageResponseDto<SchoolConfigurationDto> {

    @JsonbProperty(JSON_DATAS)
    private List<SchoolConfigurationDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_CONFIGURATION_ECOLE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une configuration d'école")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_CONFIGURATION_ECOLE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une configuration d'école")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_CONFIGURATION_ECOLE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une configuration d'école")
  Response update(SchoolConfigurationUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class SchoolConfigurationUpdateRequestDto extends ByIdentifierRequestDto
      implements SchoolConfigurationSaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_PAYMENT_ACCOUNTING_ACCOUNT_IDENTIFIER)
    private String paymentAccountingAccountIdentifier;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_CONFIGURATION_ECOLE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une configuration d'école")
  Response delete(DeleteOneRequestDto request);
}
