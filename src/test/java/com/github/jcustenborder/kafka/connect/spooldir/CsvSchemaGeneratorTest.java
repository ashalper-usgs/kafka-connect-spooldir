package com.github.jcustenborder.kafka.connect.spooldir;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.kafka.connect.data.Schema;

import org.junit.jupiter.api.Test;

/**
 * @author ashalper@usgs.gov
 */
class CsvSchemaGeneratorTest {
	
	CsvSchemaGenerator generator = null;
	@SuppressWarnings("unchecked")
	Map<String, ?> settings = mock(Map.class);

	/**
	 * Test method for
	 * {@link com.github.jcustenborder.kafka.connect.spooldir.CsvSchemaGenerator#determineFieldTypes(java.io.InputStream)}.
	 */
	@Test
	final void testDetermineFieldTypes() {
		InputStream inputStream = mock(InputStream.class);
		Map<String, Schema.Type> determineFieldTypes = null;

		try {
			generator = new CsvSchemaGenerator(settings);
			determineFieldTypes = generator.determineFieldTypes(inputStream);
		} catch (IOException ioe) {
			fail(ioe.getMessage());
		}
		assertNotNull(determineFieldTypes);
	}

	/**
	 * Test method for
	 * {@link com.github.jcustenborder.kafka.connect.spooldir.CsvSchemaGenerator#CsvSchemaGenerator(java.util.Map)}.
	 */
	@Test
	final void testCsvSchemaGenerator() {
		generator = null;
		generator = new CsvSchemaGenerator(settings);
		
		assertNotNull(generator);
	}

	/**
	 * Test method for
	 * {@link com.github.jcustenborder.kafka.connect.spooldir.CsvSchemaGenerator#config(java.util.Map)}.
	 */
	@Test
	final void testConfigMapOfStringQ() {
		SpoolDirCsvSourceConnectorConfig config = null;
		
		config = generator.config(settings);
		assertNotNull(config);
	}

} // CsvSchemaGeneratorTest
