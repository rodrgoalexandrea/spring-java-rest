package com.teste.javaspring.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PriceDeserializer extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		NumberFormat numberFormat = new DecimalFormat("¤#.00", new DecimalFormatSymbols(Locale.US));
		try {

			BigDecimal value = new BigDecimal(numberFormat.parse(p.getText()).toString()).setScale(2);

			return value;
		} catch (Exception e) {
			return null;
		}
	}

}
