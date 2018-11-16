package org.apache.camel.component.spring.batch.file.FlatFileItemReader;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;
import org.springframework.core.io.Resource;

/**
 * Restartable {@link ItemReader} that reads lines from input {@link #setResource(Resource)}. Line is defined by the
 * {@link #setRecordSeparatorPolicy(RecordSeparatorPolicy)} and mapped to item using {@link #setLineMapper(LineMapper)}.
 * If an exception is thrown during line mapping it is rethrown as {@link FlatFileParseException} adding information
 * about the problematic line and its line number.
 * 
 * @author Robert Kasanicky
 */
public abstract class WarraperFlatFileItemReader<T> extends FlatFileItemReader<T> {
}