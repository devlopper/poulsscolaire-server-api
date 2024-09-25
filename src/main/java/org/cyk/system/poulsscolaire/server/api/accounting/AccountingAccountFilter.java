package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AccountingAccountDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AccountingAccountFilter extends AbstractIdentifiableFilter {

  AccountingAccountType type;

  public AccountingAccountFilter(FilterDto dto) {
    super(dto);
  }

  public AccountingAccountFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    type = getType(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setType(filter, type);
  }

  /**
   * Cette méthode permet d'assigner la {@link AccountingAccountType}.
   *
   * @param filter filtre
   * @param type {@link AccountingAccountType}
   */
  public static void setType(FilterDto filter, AccountingAccountType type) {
    set(filter, JSON_TYPE, f -> f.getValueAsString(), f -> f.setValueAsEnum(type));
  }

  /**
   * Cette méthode permet d'obtenir l'identifiant de {@link AccountingAccountType}.
   *
   * @param filter filtre
   * @return {@link AccountingAccountType}
   */
  public static AccountingAccountType getType(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsEnum(JSON_TYPE, AccountingAccountType.class));
  }

  public static final String JSON_TYPE = AccountingAccountDto.JSON_TYPE;
}
