package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente la base de filtre de {@link AbstractAmountContainerDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public abstract class AbstractAmountContainerFilter extends AbstractIdentifiableFilter {

  Boolean amountOptional;
  Boolean amountValuePayableEqualsZero;
  Boolean amountDeadlineDateOver;

  protected AbstractAmountContainerFilter(FilterDto dto) {
    super(dto);
  }

  protected AbstractAmountContainerFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    amountOptional = getAmountOptional(filter);
    amountValuePayableEqualsZero = getAmountValuePayableEqualsZero(filter);
    amountDeadlineDateOver = getAmountDeadlineDateOver(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setAmountOptional(filter, amountOptional);
    setAmountValuePayableEqualsZero(filter, amountValuePayableEqualsZero);
    setAmountDeadlineDateOver(filter, amountDeadlineDateOver);
  }

  public static void setAmountOptional(FilterDto filter, Boolean value) {
    set(filter, JSON_AMOUNT_OPTIONAL, f -> f.getValueAsString(), f -> f.setValueAsBoolean(value));
  }

  public static Boolean getAmountOptional(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_AMOUNT_OPTIONAL));
  }

  public static void setAmountValuePayableEqualsZero(FilterDto filter, Boolean value) {
    set(filter, JSON_AMOUNT_VALUE_PAYABLE_EQUALS_ZERO, f -> f.getValueAsString(),
        f -> f.setValueAsBoolean(value));
  }

  public static Boolean getAmountValuePayableEqualsZero(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_AMOUNT_VALUE_PAYABLE_EQUALS_ZERO));
  }

  public static void setAmountDeadlineDateOver(FilterDto filter, Boolean value) {
    set(filter, JSON_AMOUNT_DEADLINE_DATE_OVER, f -> f.getValueAsString(),
        f -> f.setValueAsBoolean(value));
  }

  public static Boolean getAmountDeadlineDateOver(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_AMOUNT_DEADLINE_DATE_OVER));
  }

  public static final String JSON_AMOUNT_OPTIONAL = AmountDto.JSON_OPTIONAL;
  public static final String JSON_AMOUNT_VALUE_PAYABLE_EQUALS_ZERO =
      AmountDto.JSON_VALUE_PAYABLE_EQUALS_ZERO;
  public static final String JSON_AMOUNT_DEADLINE_DATE_OVER = AmountDto.JSON_DEADLINE_DATE_OVER;

}
