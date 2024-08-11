package org.cyk.system.poulsscolaire.server.api.report;

import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
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
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link ReportDto}.
 *
 * @author Christian
 *
 */
@Path(ReportService.PATH)
@Tag(name = "Gestion des rapports")
public interface ReportService {

  /**
   * Chemin de base des services.
   */
  String PATH = "rapports";

  /**
   * Cette classe représente l'objet de transfert de donnée de paramètre de rapport.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {ParameterDto.FIELD_NAME, ParameterDto.FIELD_VALUES})
  public static class ParameterDto {
    @JsonbProperty(JSON_NAME)
    private String name;

    @JsonbProperty(JSON_VALUES)
    private List<String> values;

    public static final String FIELD_NAME = "name";
    public static final String FIELD_VALUES = "values";

    public static final String JSON_NAME = "nom";
    public static final String JSON_VALUES = "valeurs";
  }

  /**
   * Identifiant du service d'obtention d'octets par identifiant.
   */
  String GET_BYTES_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_OCTETS_PAR_IDENTIFIANT";

  /**
   * Chemin du service d'obtention d'octets par identifiant.
   */
  String GET_BYTES_BY_IDENTIFIER_PATH = "octets-par-identifiant";

  /**
   * Cette méthode permet d'obtenir d'octets par identifiant.
   *
   * @param request requête
   * @return réponse
   */
  @Path(GET_BYTES_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_OCTET_STREAM + "," + MediaType.TEXT_PLAIN)
  @Operation(operationId = GET_BYTES_BY_IDENTIFIER_IDENTIFIER,
      summary = "Obtention octets par identifiant",
      description = "Ce service permet d'obtenir les octets par identifiant")
  @APIResponses(value = {
      @APIResponse(responseCode = "200",
          content = {@Content(mediaType = MediaType.APPLICATION_OCTET_STREAM,
              schema = @Schema(implementation = byte[].class))}),
      @APIResponse(responseCode = "500", content = {@Content(mediaType = MediaType.TEXT_PLAIN,
          schema = @Schema(implementation = String.class))})})

  Response getBytesByIdentifier(GetBytesByIdentifierRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la requête d'obtention d'octets par
   * identifiant.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {GetBytesByIdentifierRequestDto.FIELD_PARAMETERS,
      GetBytesByIdentifierRequestDto.FIELD_FILE_TYPE})
  public static class GetBytesByIdentifierRequestDto extends ByIdentifierRequestDto {

    @JsonbProperty(JSON_PARAMETERS)
    private List<ParameterDto> parameters;

    @JsonbProperty(JSON_FILE_TYPE)
    private String fileType;

    @JsonbProperty(JSON_FILE_NAME)
    private String fileName;
    
    public static final String FIELD_PARAMETERS = "parameters";
    public static final String FIELD_FILE_TYPE = "fileType";
    public static final String FIELD_FILE_NAME = "fileName";
    
    public static final String JSON_PARAMETERS = "parametres";
    public static final String JSON_FILE_TYPE = "typeFichier";
    public static final String JSON_FILE_NAME = "nomFichier";
  }
  
  String DEFAULT_FILE_TYPE = "pdf";
}
