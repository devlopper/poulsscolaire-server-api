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
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolService.SchoolGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolService.SchoolRepatriateRequestDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolService.SchoolRepatriateResponseDto;

/**
 * Cette classe représente un client de {@link SchoolService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class SchoolClient extends AbstractClient<SchoolService>
    implements GetByIdentifier<SchoolDto>, GetMany<SchoolGetManyResponseDto> {

  @Override
  public SchoolClient service(SchoolService service) {
    return (SchoolClient) super.service(service);
  }

  public SchoolRepatriateResponseDto repatriate(SchoolRepatriateRequestDto request) {
    return new GetOneExecutor<SchoolRepatriateResponseDto>(SchoolRepatriateResponseDto.class,
        SchoolService.REPATRIATE_IDENTIFIER).execute(() -> service().repatriate(request));
  }

  /**
   * {@link SchoolService#repatriate}.
   *
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SchoolRepatriateResponseDto repatriate(String auditWho, String auditSession) {
    SchoolRepatriateRequestDto request = new SchoolRepatriateRequestDto();
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return repatriate(request);
  }
  
  public SchoolGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<SchoolGetManyResponseDto>(SchoolGetManyResponseDto.class,
        SchoolService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * {@link SchoolService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SchoolGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter, PageDto page,
      String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public SchoolDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<SchoolDto>(SchoolDto.class, SchoolService.GET_ONE_IDENTIFIER)
        .execute(() -> service().getOne(request));
  }

  /**
   * {@link SchoolService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SchoolDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link SchoolService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public SchoolDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<SchoolDto>(SchoolDto.class,
        SchoolService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link SchoolService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public SchoolDto getByIdentifier(String identifier, ProjectionDto projection, String auditWho,
      String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }
}
