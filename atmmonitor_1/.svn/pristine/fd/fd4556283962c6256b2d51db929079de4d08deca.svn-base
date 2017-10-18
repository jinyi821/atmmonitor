package com.common.core.component.rule.node;

import com.common.core.component.rule.ParsedFunction;
import com.common.core.component.rule.RuleException;
import com.common.core.component.rule.function.Function;
import com.common.core.component.rule.function.FunctionException;
import com.common.core.component.rule.function.FunctionResult;
import com.common.core.component.rule.operator.IOperator;


public class NodeTree {
	//左操作数
	private Object leftOperand;
	//右操作数
	private Object rightOperand;
	//操作符
	private IOperator operator = null;
	
	
	public NodeTree( final Object leftOperand,
			final Object rightOperand, final IOperator operator)
	{
		this.leftOperand=leftOperand;
		this.rightOperand=rightOperand;
		this.operator=operator;
	}
	public Object getLeftOperand() {
		return leftOperand;
	}
	public Object getRightOperand() {
		return rightOperand;
	}
	public IOperator getOperator() {
		return operator;
	}
	
	public String calOperand() throws RuleException
	{
		String erLeftString="";
		String erRightString="";
		String result="";
		String leftResultString = null;
		Double leftResultDouble = null;
		if(leftOperand instanceof NodeTree)
		{
			leftResultString=((NodeTree)leftOperand).calOperand();
			erLeftString=leftResultString;
			try {
				leftResultDouble = new Double(leftResultString);
				leftResultString = null;
			} catch (NumberFormatException exception) {
				leftResultDouble = null;
			}			
		}
		else if(leftOperand instanceof NodeOperand)
		{
			
			leftResultString=((NodeOperand)leftOperand).getOperand();
			erLeftString=leftResultString;
			
			try {
				if(leftResultString.charAt(0)!='\'')
				{
					leftResultDouble = new Double(leftResultString);
					leftResultString = null;
				}
			} catch (NumberFormatException exception) 
			{
				if(leftResultString.charAt(0)!='\'')
				{
					leftResultString=null;
				}
				leftResultDouble = null;
				
			}			
		}
		else if (leftOperand instanceof ParsedFunction) {
			final ParsedFunction parsedFunction = (ParsedFunction) leftOperand;
			final Function function = parsedFunction.getFunction();
			String arguments = parsedFunction.getArguments();
			FunctionResult fncresult;
			try {
				fncresult = function.execute(arguments);
				if(fncresult!=null)
					leftResultString = fncresult.getResult();
			} catch (FunctionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		String rightResultString = null;
		Double rightResultDouble = null;
		if(rightOperand instanceof NodeTree)
		{
			rightResultString=((NodeTree)rightOperand).calOperand();
			erRightString=rightResultString;
			try {
				rightResultDouble = new Double(rightResultString);
				rightResultString = null;
			} catch (NumberFormatException exception) {
				rightResultDouble = null;
			}			
		}
		else if(rightOperand instanceof NodeOperand)
		{
			rightResultString=((NodeOperand)rightOperand).getOperand();
			erRightString=rightResultString;
			try {
				if(rightResultString.charAt(0)!='\'')
				{
					rightResultDouble = new Double(rightResultString);
					rightResultString = null;
				}
			} catch (NumberFormatException exception) {
				if(rightResultString.charAt(0)!='\'')
				{
					rightResultString = null;
				}
				rightResultDouble = null;
			}			
		}
		else if (rightOperand instanceof ParsedFunction) {
			final ParsedFunction parsedFunction = (ParsedFunction) rightOperand;
			final Function function = parsedFunction.getFunction();
			String arguments = parsedFunction.getArguments();
			FunctionResult fncresult;
			try {
				if(function!=null)
				{
					fncresult = function.execute(arguments);
					if(fncresult!=null)
					{
						rightResultString = fncresult.getResult();
					}
				}
			} catch (FunctionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		if(leftResultDouble!=null && rightResultDouble!=null)
		{
			double doubleResult = operator.evaluate(leftResultDouble.doubleValue(), rightResultDouble.doubleValue());
			result = new Double(doubleResult).toString();
		}
		else if(leftResultString!=null && rightResultString!=null)
		{
			result=operator.evaluate(leftResultString, rightResultString);
		}
		else if(leftResultDouble!=null && rightResultDouble==null)
		{
			throw new RuleException("表达式错误(calOperand):"+erLeftString +operator.getSymbol()+erRightString);
		}
		else
		{
			throw new RuleException("表达式错误(calOperand):"+erLeftString +operator.getSymbol()+erRightString);
		}
		
		return result;
	}

	
}
