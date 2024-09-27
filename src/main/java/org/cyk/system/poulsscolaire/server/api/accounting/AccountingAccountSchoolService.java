package org.cyk.system.poulsscolaire.server.api.accounting;

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
 * Cette interface représente les services de {@link AccountingAccountSchoolDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = AccountingAccountSchoolService.PATH)
@Tag(name = "Gestion des comptes comptables d'écoles")
public interface AccountingAccountSchoolService extends SpecificService {

  String PATH = "comptes-comptables-ecoles";

  String CREATE_IDENTIFIER = "CREATION_COMPTE_COMPTABLE_ECOLE";

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
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'un compte comptable d'école",
      description = "Ce service permet de créer un compte comptable d'école")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(AccountingAccountSchoolCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface AccountingAccountSaveRequestDto {

    String getAccountIdentifier();

    void setAccountIdentifier(String planIdentifier);

    String getSchoolIdentifier();

    void setSchoolIdentifier(String planIdentifier);

    String JSON_ACCOUNT_IDENTIFIER = AccountingAccountSchoolDto.JSON_ACCOUNT_IDENTIFIER;

    String JSON_SCHOOL_IDENTIFIER = AccountingAccountSchoolDto.JSON_SCHOOL_IDENTIFIER;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingAccountSchoolCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements AccountingAccountSaveRequestDto {

    @JsonbProperty(JSON_ACCOUNT_IDENTIFIER)
    private String accountIdentifier;

    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_COMPTE_COMPTABLE_ECOLE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir plusieurs comptes comptables d'écoles")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class AccountingAccountSchoolGetManyResponseDto
      extends AbstractGetByPageResponseDto<AccountingAccountSchoolDto> {

    @JsonbProperty(JSON_DATAS)
    private List<AccountingAccountSchoolDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_COMPTE_COMPTABLE_ECOLE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir un compte comptable d'école")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_COMPTE_COMPTABLE_ECOLE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant un compte comptable d'école")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_COMPTE_COMPTABLE_ECOLE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour un compte comptable d'école")
  Response update(AccountingAccountSchoolUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingAccountSchoolUpdateRequestDto extends ByIdentifierRequestDto
      implements AccountingAccountSaveRequestDto {
    @JsonbProperty(JSON_ACCOUNT_IDENTIFIER)
    private String accountIdentifier;

    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_COMPTE_COMPTABLE_ECOLE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer un compte comptable d'école")
  Response delete(DeleteOneRequestDto request);
}
