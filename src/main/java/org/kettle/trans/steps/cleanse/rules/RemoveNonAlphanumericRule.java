package org.kettle.trans.steps.cleanse.rules;

import org.kettle.trans.steps.cleanse.CleanseRule;
import org.kettle.trans.steps.cleanse.ValueProcessor;
import org.pentaho.di.core.exception.KettleValueException;
import org.pentaho.di.core.row.ValueMetaInterface;

/**
 * The rule removes all non-alphanumeric characters including spaces.
 * 
 * @See {@link RemoveSymbolRule}
 * 
 * @author Nicolas ADMENT *
 */

@CleanseRule(id = "RemoveNonAlphanumeric", name = "Remove non alphanumeric characters", category = "Cleaning", description = "The rule removes all non-alphanumeric characters including spaces")
public class RemoveNonAlphanumericRule implements ValueProcessor {

	@Override
	public Object processValue(final ValueMetaInterface valueMeta, final Object object) throws KettleValueException {
		if (object == null)
			return null;

		String value = valueMeta.getString(object);

		StringBuilder result = new StringBuilder(value.length());

		for (int offset = 0; offset < value.length();) {
			int codePoint = value.codePointAt(offset);
			offset += Character.charCount(codePoint);
			if (Character.isDigit(codePoint) || Character.isAlphabetic(codePoint)) {
				result.append(Character.toChars(codePoint));
			}
		}

		return result.toString();
	}

}
