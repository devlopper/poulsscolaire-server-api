package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.client.AbstractClient;
import ci.gouv.dgbf.extension.server.service.api.client.executor.CreateExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.GetOneExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.IdentifiableExecutor;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.PageDto;
import ci.gouv.dgbf.extension.server.service.api.request.ProjectionDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import ci.gouv.dgbf.extension.server.service.api.segregation.DeleteByIdentifier;
import ci.gouv.dgbf.extension.server.service.api.segregation.GetByIdentifier;
import ci.gouv.dgbf.extension.server.service.api.segregation.GetMany;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cyk.system.poulsscolaire.server.api.fee.AmountDeadlineService.AmountDeadlineCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.AmountDeadlineService.AmountDeadlineUpdateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.AmountDeadlineService.GetManyResponseDto;

/**
 * Cette classe représente un client de {@link AmountDeadlineService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class AmountDeadlineClient
    extends AbstractClient<AmountDeadlineService>
    implements GetByIdentifier<AmountDeadlineDto>, GetMany<GetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public AmountDeadlineClient service(AmountDeadlineService service) {
    return (AmountDeadlineClient) super.service(service);
  }

  /**
   * {@link AmountDeadlineService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(AmountDeadlineCreateRequestDto request) {
    return new CreateExecutor(AmountDeadlineService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link AmountDeadlineService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public GetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<GetManyResponseDto>(GetManyResponseDto.class,
        AmountDeadlineService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link AmountDeadlineService#getMany}.
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

  /**
   * {@link AmountDeadlineService#getOne}.
   *
   * @param request requête
   * @return réponse
   */
  public AmountDeadlineDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<AmountDeadlineDto>(AmountDeadlineDto.class,
        AmountDeadlineService.GET_ONE_IDENTIFIER)
            .execute(() -> service().getOne(request));
  }

  /**
   * {@link AmountDeadlineService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public AmountDeadlineDto getOne(ProjectionDto projection, FilterDto filter,
      String auditWho, String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link AmountDeadlineService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public AmountDeadlineDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<AmountDeadlineDto>(AmountDeadlineDto.class,
        AmountDeadlineService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * Cette méthode permet d'obtenir par identifiant un groupe d'échéance.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public AmountDeadlineDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  /**
   * {@link AmountDeadlineService#update}.
   *
   * @param request requête
   * @return réponse
   */
  public IdentifiableResponseDto update(AmountDeadlineUpdateRequestDto request) {
    return new IdentifiableExecutor(AmountDeadlineService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  /**
   * {@link AmountDeadlineService#delete}.
   *
   * @param request requête
   * @return réponse
   */
  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(AmountDeadlineService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link AmountDeadlineService#delete}.
   *
   * @param identifier identifiant
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto deleteByIdentifier(String identifier, String auditWho,
      String auditSession) {
    DeleteOneRequestDto request = new DeleteOneRequestDto();
    request.setIdentifier(identifier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return delete(request);
  }
}
