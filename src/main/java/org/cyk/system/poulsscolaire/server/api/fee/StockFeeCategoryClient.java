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
import org.cyk.system.poulsscolaire.server.api.fee.StockFeeCategoryService.StockFeeCategoryCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockFeeCategoryService.StockFeeCategoryGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockFeeCategoryService.StockFeeCategoryUpdateRequestDto;

/**
 * Cette classe représente un client de {@link StockFeeCategoryService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class StockFeeCategoryClient extends AbstractClient<StockFeeCategoryService>
    implements GetByIdentifier<StockFeeCategoryDto>, GetMany<StockFeeCategoryGetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public StockFeeCategoryClient service(StockFeeCategoryService service) {
    return (StockFeeCategoryClient) super.service(service);
  }

  /**
   * {@link StockFeeCategoryService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(StockFeeCategoryCreateRequestDto request) {
    return new CreateExecutor(StockFeeCategoryService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link StockFeeCategoryService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public StockFeeCategoryGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<StockFeeCategoryGetManyResponseDto>(
        StockFeeCategoryGetManyResponseDto.class, StockFeeCategoryService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link StockFeeCategoryService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public StockFeeCategoryGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter,
      PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public StockFeeCategoryDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<StockFeeCategoryDto>(StockFeeCategoryDto.class,
        StockFeeCategoryService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link StockFeeCategoryService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public StockFeeCategoryDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link StockFeeCategoryService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public StockFeeCategoryDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<StockFeeCategoryDto>(StockFeeCategoryDto.class,
        StockFeeCategoryService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link StockFeeCategoryService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public StockFeeCategoryDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(StockFeeCategoryUpdateRequestDto request) {
    return new IdentifiableExecutor(StockFeeCategoryService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(StockFeeCategoryService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link StockFeeCategoryService#delete}.
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
