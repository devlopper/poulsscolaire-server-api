package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.client.AbstractClient;
import ci.gouv.dgbf.extension.server.service.api.client.executor.GetOneExecutor;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.PageDto;
import ci.gouv.dgbf.extension.server.service.api.request.ProjectionDto;
import ci.gouv.dgbf.extension.server.service.api.segregation.GetByIdentifier;
import ci.gouv.dgbf.extension.server.service.api.segregation.GetMany;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cyk.system.poulsscolaire.server.api.configuration.PeriodService.PeriodGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.configuration.PeriodService.PeriodRepatriateRequestDto;
import org.cyk.system.poulsscolaire.server.api.configuration.PeriodService.PeriodRepatriateResponseDto;

/**
 * Cette classe représente un client de {@link PeriodService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class PeriodClient extends AbstractClient<PeriodService>
    implements GetByIdentifier<PeriodDto>, GetMany<PeriodGetManyResponseDto> {

  @Override
  public PeriodClient service(PeriodService service) {
    return (PeriodClient) super.service(service);
  }

  public PeriodRepatriateResponseDto repatriate(PeriodRepatriateRequestDto request) {
    return new GetOneExecutor<PeriodRepatriateResponseDto>(PeriodRepatriateResponseDto.class,
        PeriodService.REPATRIATE_IDENTIFIER).execute(() -> service().repatriate(request));
  }

  /**
   * {@link PeriodService#repatriate}.
   *
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public PeriodRepatriateResponseDto repatriate(String auditWho, String auditSession) {
    PeriodRepatriateRequestDto request = new PeriodRepatriateRequestDto();
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return repatriate(request);
  }
  
  public PeriodGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<PeriodGetManyResponseDto>(PeriodGetManyResponseDto.class,
        PeriodService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * {@link PeriodService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public PeriodGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter, PageDto page,
      String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public PeriodDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<PeriodDto>(PeriodDto.class, PeriodService.GET_ONE_IDENTIFIER)
        .execute(() -> service().getOne(request));
  }

  /**
   * {@link PeriodService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public PeriodDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link PeriodService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public PeriodDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<PeriodDto>(PeriodDto.class,
        PeriodService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link PeriodService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public PeriodDto getByIdentifier(String identifier, ProjectionDto projection, String auditWho,
      String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }
}
