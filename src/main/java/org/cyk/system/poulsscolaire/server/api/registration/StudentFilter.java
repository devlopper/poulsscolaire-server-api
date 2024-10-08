package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link StudentDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class StudentFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;
  String registrationNumber;
  String firstName;
  String lastNames;
  String arabicFirstName;
  String arabicLastNames;

  public StudentFilter(FilterDto dto) {
    super(dto);
  }

  public StudentFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    registrationNumber = getRegistrationNumber(filter);
    firstName = getFirstName(filter);
    lastNames = getLastNames(filter);
    arabicFirstName = getArabicFirstName(filter);
    arabicLastNames = getArabicLastNames(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setRegistrationNumber(filter, registrationNumber);
    setFirstName(filter, firstName);
    setLastNames(filter, lastNames);
    setArabicFirstName(filter, arabicFirstName);
    setArabicLastNames(filter, arabicLastNames);
  }

  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static void setRegistrationNumber(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_NUMBER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationNumber(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_NUMBER));
  }

  public static void setFirstName(FilterDto filter, String identifier) {
    set(filter, JSON_FIRST_NAME, f -> f.getValueAsString(), f -> f.setValueAsString(identifier));
  }

  public static String getFirstName(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_FIRST_NAME));
  }

  public static void setLastNames(FilterDto filter, String identifier) {
    set(filter, JSON_LAST_NAMES, f -> f.getValueAsString(), f -> f.setValueAsString(identifier));
  }

  public static String getLastNames(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_LAST_NAMES));
  }

  public static void setArabicFirstName(FilterDto filter, String identifier) {
    set(filter, JSON_ARABIC_FIRST_NAME, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getArabicFirstName(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_ARABIC_FIRST_NAME));
  }

  public static void setArabicLastNames(FilterDto filter, String identifier) {
    set(filter, JSON_ARABIC_LAST_NAMES, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getArabicLastNames(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_ARABIC_LAST_NAMES));
  }

  public static final String JSON_SCHOOL_IDENTIFIER = StudentDto.JSON_SCHOOL_IDENTIFIER;
  public static final String JSON_REGISTRATION_NUMBER = StudentDto.JSON_REGISTRATION_NUMBER;
  public static final String JSON_FIRST_NAME = StudentDto.JSON_FIRST_NAME;
  public static final String JSON_LAST_NAMES = StudentDto.JSON_LAST_NAMES;
  public static final String JSON_ARABIC_FIRST_NAME = StudentDto.JSON_ARABIC_FIRST_NAME;
  public static final String JSON_ARABIC_LAST_NAMES = StudentDto.JSON_ARABIC_LAST_NAMES;
}
