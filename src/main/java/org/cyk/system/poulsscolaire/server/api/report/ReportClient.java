package org.cyk.system.poulsscolaire.server.api.report;

import ci.gouv.dgbf.extension.server.service.api.client.AbstractClient;
import ci.gouv.dgbf.extension.server.service.api.client.AbstractExecutableReturningResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import java.util.List;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.report.ReportService.GetBytesByIdentifierRequestDto;
import org.cyk.system.poulsscolaire.server.api.report.ReportService.ParameterDto;

/**
 * Cette classe représente le client de {@link ReportService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
public class ReportClient extends AbstractClient<ReportService> {

  @Override
  public ReportClient service(ReportService service) {
    return (ReportClient) super.service(service);
  }

  /**
   * Cette méthode permet d'obtenir les octets par identifiant.
   *
   * @param request requête
   * @return octets
   */
  public byte[] getBytesByIdentifier(GetBytesByIdentifierRequestDto request) {
    return new GetBytesByIdentifierService().execute(() -> service().getBytesByIdentifier(request));
  }

  /**
   * Cette méthode permet d'obtenir les octets par identifiant.
   *
   * @param identifier identifiant
   * @param fileType type de fichier
   * @param parameters paramètres
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return octets
   */
  public byte[] getBytesByIdentifier(String identifier, String fileType,
      List<ParameterDto> parameters, String auditWho, String auditSession) {
    GetBytesByIdentifierRequestDto request = new GetBytesByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setFileType(fileType);
    request.setParameters(parameters);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getBytesByIdentifier(request);
  }

  class GetBytesByIdentifierService extends AbstractExecutableReturningResponse<byte[]> {

    GetBytesByIdentifierService() {
      super(ReportService.GET_BYTES_BY_IDENTIFIER_IDENTIFIER);
    }

    @Override
    protected byte[] processWhenExpectedResponseStatus(Response response) {
      return response.readEntity(byte[].class);
    }
  }
}
