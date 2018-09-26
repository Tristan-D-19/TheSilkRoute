package com.aws.codestar.silkroute.customannotations;

import org.passay.*;
import org.passay.dictionary.WordListDictionary;
import org.passay.dictionary.WordLists;
import org.passay.dictionary.sort.ArraysSort;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordConstraintCheck implements ConstraintValidator <ValidPassword, String> {

	public static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static DictionaryRule dictionaryRule;
	
	@Override
	public void initialize(ValidPassword constraintAnnotation) {
//		 try {
//	            String invalidPasswordList = this.getClass().getResource("/invalid-password-list.txt").getFile();
//	            dictionaryRule = new DictionaryRule(
//	                    new WordListDictionary(WordLists.createFromReader(
//	                           
//	                            new FileReader[] {
//	                                    new FileReader(invalidPasswordList)
//	                            },
//	                            // True for case sensitivity, false otherwise
//	                            false,
//	                            // Dictionaries must be sorted
//	                            new ArraysSort()
//	                    )));
//	        } catch (IOException e) {
//	            throw new RuntimeException("could not load word list", e);
//		
//	}
}
	
	 @Override
	    public boolean isValid(String password, ConstraintValidatorContext context) {
		 PasswordValidator validator =  new PasswordValidator(Arrays.asList(

	                // at least 8 characters
	                new LengthRule(8, 30),

	                // at least one upper-case character
	                new CharacterRule(EnglishCharacterData.UpperCase, 1),

	                // at least one lower-case character
	                new CharacterRule(EnglishCharacterData.LowerCase, 1),

	                // at least one digit character
	                new CharacterRule(EnglishCharacterData.Digit, 1),

	                // at least one symbol (special character)
	                new CharacterRule(EnglishCharacterData.Special, 1),

	                // no whitespace
	                new WhitespaceRule()	
//	                ,dictionaryRule
	        ));

	        RuleResult result = validator.validate(new PasswordData(password));

	        if (result.isValid()) {
	            return true;
	        }

	        List<String> messages = validator.getMessages(result);
	        String messageTemplate = messages.stream().collect(Collectors.joining(" , "));
	        context.buildConstraintViolationWithTemplate(messageTemplate)
	                .addConstraintViolation()
	                .disableDefaultConstraintViolation();
	        return false;
	    }



}
