package com.common.core.component.rule.node;

import com.common.core.component.rule.operator.IOperator;


public class NodeOperator {
	
	private IOperator operator;
	
	public NodeOperator(IOperator operator)
	{
		this.operator=operator;
	}

	public IOperator getOperator() {
		return operator;
	}
	

}
