package org.cyk.system.poulsscolaire.server.api.payment;

import ci.gouv.dgbf.extension.server.service.api.client.AbstractClient;
import ci.gouv.dgbf.extension.server.service.api.client.executor.CreateExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.GetOneExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.IdentifiableExecutor;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
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
import org.cyk.system.poulsscolaire.server.api.payment.PaymentService.GetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.payment.PaymentService.PaymentCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.payment.PaymentService.PaymentUpdateRequestDto;

/**
 * Cette classe représente un client de {@link PaymentService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class PaymentClient extends AbstractClient<PaymentService>
    implements GetByIdentifier<PaymentDto>, GetMany<GetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public PaymentClient service(PaymentService service) {
    return (PaymentClient) super.service(service);
  }

  /**
   * {@link PaymentService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(PaymentCreateRequestDto request) {
    return new CreateExecutor(PaymentService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link PaymentService#create}.
   *
   * @param registrationIdentifier identifiant inscription
   * @param modeIdentifier identifiant mode
   * @param amount montant
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public CreateResponseDto create(String registrationIdentifier, String modeIdentifier, int amount,
      String auditWho, String auditSession) {
    PaymentCreateRequestDto request = new PaymentCreateRequestDto();
    request.setRegistrationIdentifier(registrationIdentifier);
    request.setModeIdentifier(modeIdentifier);
    request.setAmount(amount);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return create(request);
  }

  public GetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<GetManyResponseDto>(GetManyResponseDto.class,
        PaymentService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * {@link PaymentService#getMany}.
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

  public PaymentDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<PaymentDto>(PaymentDto.class, PaymentService.GET_ONE_IDENTIFIER)
        .execute(() -> service().getOne(request));
  }

  /**
   * {@link PaymentService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public PaymentDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link PaymentService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public PaymentDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<PaymentDto>(PaymentDto.class,
        PaymentService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link PaymentService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public PaymentDto getByIdentifier(String identifier, ProjectionDto projection, String auditWho,
      String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(PaymentUpdateRequestDto request) {
    return new IdentifiableExecutor(PaymentService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  /**
   * {@link PaymentService#update}.
   *
   * @param identifier identifiant
   * @param modeIdentifier identifiant mode
   * @param amount montant
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto update(String identifier, String modeIdentifier, int amount,
      String auditWho, String auditSession) {
    PaymentUpdateRequestDto request = new PaymentUpdateRequestDto();
    request.setIdentifier(identifier);
    request.setModeIdentifier(modeIdentifier);
    request.setAmount(amount);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return update(request);
  }

  public IdentifiableResponseDto cancel(ByIdentifierRequestDto request) {
    return new IdentifiableExecutor(PaymentService.CANCEL_IDENTIFIER)
        .execute(() -> service().cancel(request));
  }

  /**
   * {@link PaymentService#cancel}.
   *
   * @param identifier identifiant
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto cancel(String identifier, String auditWho, String auditSession) {
    ByIdentifierRequestDto request = new ByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return cancel(request);
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(PaymentService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link PaymentService#delete}.
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
