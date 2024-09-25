package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AccountingOperationAccountDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AccountingOperationAccountFilter extends AbstractIdentifiableFilter {

  String operationIdentifier;

  public AccountingOperationAccountFilter(FilterDto dto) {
    super(dto);
  }

  public AccountingOperationAccountFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    operationIdentifier = getOperationIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setOperationIdentifier(filter, operationIdentifier);
  }

  public static void setOperationIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_OPERATION_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getOperationIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_OPERATION_IDENTIFIER));
  }

  public static final String JSON_OPERATION_IDENTIFIER =
      AccountingOperationAccountDto.JSON_OPERATION_IDENTIFIER;
}
