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
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolUserService.GetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolUserService.SchoolUserRepatriateRequestDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolUserService.SchoolUserRepatriateResponseDto;

/**
 * Cette classe représente un client de {@link SchoolUserService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class SchoolUserClient extends AbstractClient<SchoolUserService>
    implements GetByIdentifier<SchoolUserDto>, GetMany<GetManyResponseDto> {

  @Override
  public SchoolUserClient service(SchoolUserService service) {
    return (SchoolUserClient) super.service(service);
  }

  /**
   * {@link SchoolUserService#repatriate}.
   *
   * @param request requëte
   * @return réponse
   */
  public SchoolUserRepatriateResponseDto repatriate(SchoolUserRepatriateRequestDto request) {
    return new GetOneExecutor<SchoolUserRepatriateResponseDto>(
        SchoolUserRepatriateResponseDto.class, SchoolUserService.REPATRIATE_IDENTIFIER)
            .execute(() -> service().repatriate(request));
  }

  /**
   * {@link SchoolUserService#repatriate}.
   *
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SchoolUserRepatriateResponseDto repatriate(String auditWho, String auditSession) {
    SchoolUserRepatriateRequestDto request = new SchoolUserRepatriateRequestDto();
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return repatriate(request);
  }

  public GetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<GetManyResponseDto>(GetManyResponseDto.class,
        SchoolUserService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * {@link SchoolUserService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public GetManyResponseDto getMany(ProjectionDto projection, FilterDto filter, PageDto page,
      String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public SchoolUserDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<SchoolUserDto>(SchoolUserDto.class,
        SchoolUserService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link SchoolUserService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SchoolUserDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link SchoolUserService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public SchoolUserDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<SchoolUserDto>(SchoolUserDto.class,
        SchoolUserService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link SchoolUserService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public SchoolUserDto getByIdentifier(String identifier, ProjectionDto projection, String auditWho,
      String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }
}
