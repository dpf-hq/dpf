package no.hib.dpf.codegen.xpand.metamodel.test;

import java.util.Map;

import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.xtend.expression.ExceptionHandler;
import org.eclipse.xtend.expression.ExecutionContext;

public class DpfExceptionHandler implements ExceptionHandler {

	@Override
	public void handleRuntimeException(RuntimeException ex,
			SyntaxElement element, ExecutionContext ctx,
			Map<String, Object> additionalContextInfo) {
		System.err.println(element.getLine() + " " + ex.getMessage());
	}
	
}