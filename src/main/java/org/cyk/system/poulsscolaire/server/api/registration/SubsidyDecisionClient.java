package org.cyk.system.poulsscolaire.server.api.registration;

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
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionUpdateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionUpdateSubsidiesRequestDto;

/**
 * Cette classe représente un client de {@link SubsidyDecisionService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class SubsidyDecisionClient extends AbstractClient<SubsidyDecisionService>
    implements GetByIdentifier<SubsidyDecisionDto>, GetMany<SubsidyDecisionGetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public SubsidyDecisionClient service(SubsidyDecisionService service) {
    return (SubsidyDecisionClient) super.service(service);
  }

  /**
   * {@link SubsidyDecisionService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(SubsidyDecisionCreateRequestDto request) {
    return new CreateExecutor(SubsidyDecisionService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link SubsidyDecisionService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public SubsidyDecisionGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<SubsidyDecisionGetManyResponseDto>(
        SubsidyDecisionGetManyResponseDto.class, SubsidyDecisionService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link SubsidyDecisionService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SubsidyDecisionGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter,
      PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public SubsidyDecisionDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<SubsidyDecisionDto>(SubsidyDecisionDto.class,
        SubsidyDecisionService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link SubsidyDecisionService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SubsidyDecisionDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link SubsidyDecisionService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public SubsidyDecisionDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<SubsidyDecisionDto>(SubsidyDecisionDto.class,
        SubsidyDecisionService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link SubsidyDecisionService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public SubsidyDecisionDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(SubsidyDecisionUpdateRequestDto request) {
    return new IdentifiableExecutor(SubsidyDecisionService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  public IdentifiableResponseDto updateSubsidies(SubsidyDecisionUpdateSubsidiesRequestDto request) {
    return new IdentifiableExecutor(SubsidyDecisionService.UPDATE_SUBSIDIES_IDENTIFIER)
        .execute(() -> service().updateSubsidies(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(SubsidyDecisionService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link SubsidyDecisionService#delete}.
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
