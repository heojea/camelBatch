package org.apache.camel.component.spring.batch.partitioner;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.component.spring.batch.support.CamelItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
public class CustomPartitioner implements Partitioner{
	private static final Logger LOG = LoggerFactory.getLogger(CamelItemProcessor.class);
	  @Override
	  public Map partition(int gridSize) {
	      //log.debug("START: Partition");
		  Map partitionMap = new HashMap();
		  int startingIndex = 0;
		  int endingIndex = 5;
		
		  for(int i=0; i< gridSize; i++){
		      ExecutionContext ctxMap = new ExecutionContext();
		      ctxMap.putInt("startingIndex",startingIndex);
		      ctxMap.putInt("endingIndex", endingIndex);
		
		      startingIndex = endingIndex+1;
		      endingIndex += 5;
		
		      partitionMap.put("Thread:-"+i, ctxMap);
		
		  }
		  LOG.debug("END: Created Partitions of size: "+ partitionMap.size());
		  return partitionMap;
	  }
}
