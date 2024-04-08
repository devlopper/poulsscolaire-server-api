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
import java.time.LocalDateTime;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cyk.system.poulsscolaire.server.api.fee.DeadlineService.DeadlineCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.DeadlineService.DeadlineUpdateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.DeadlineService.GetManyResponseDto;

/**
 * Cette classe représente un client de {@link DeadlineService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class DeadlineClient extends AbstractClient<DeadlineService>
    implements GetByIdentifier<DeadlineDto>, GetMany<GetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public DeadlineClient service(DeadlineService service) {
    return (DeadlineClient) super.service(service);
  }

  /**
   * {@link DeadlineService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(DeadlineCreateRequestDto request) {
    return new CreateExecutor(DeadlineService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link DeadlineService#create}.
   *
   * @param groupIdentifier identifiant groupe
   * @param date date
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public CreateResponseDto create(String code, String name, String groupIdentifier,
      LocalDateTime date, String auditWho, String auditSession) {
    DeadlineCreateRequestDto request = new DeadlineCreateRequestDto();
    request.setCode(code);
    request.setName(name);
    request.setGroupIdentifier(groupIdentifier);
    request.setDate(date);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return create(request);
  }

  public GetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<GetManyResponseDto>(GetManyResponseDto.class,
        DeadlineService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * {@link DeadlineService#getMany}.
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

  public DeadlineDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<DeadlineDto>(DeadlineDto.class, DeadlineService.GET_ONE_IDENTIFIER)
        .execute(() -> service().getOne(request));
  }

  /**
   * {@link DeadlineService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public DeadlineDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link DeadlineService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public DeadlineDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<DeadlineDto>(DeadlineDto.class,
        DeadlineService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link DeadlineService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public DeadlineDto getByIdentifier(String identifier, ProjectionDto projection, String auditWho,
      String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(DeadlineUpdateRequestDto request) {
    return new IdentifiableExecutor(DeadlineService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  /**
   * {@link DeadlineService#update}.
   *
   * @param identifier identifiant
   * @param groupIdentifier identifiant groupe
   * @param date date
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto update(String identifier, String code, String name,
      String groupIdentifier, LocalDateTime date, String auditWho, String auditSession) {
    DeadlineUpdateRequestDto request = new DeadlineUpdateRequestDto();
    request.setIdentifier(identifier);
    request.setCode(code);
    request.setName(name);
    request.setGroupIdentifier(groupIdentifier);
    request.setDate(date);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return update(request);
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(DeadlineService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link DeadlineService#delete}.
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
