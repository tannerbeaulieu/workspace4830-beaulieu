
public aspect TraceAspectBeaulieu {
	
	pointcut classToTrace(): within(ComponentApp) || within(DataApp) 
						|| within(ServiceApp);

	pointcut methodToTrace(): classToTrace() && execution(* *(..));
	
	before(): methodToTrace() {
	    System.out.print("[BGN] ");
	    String info = thisJoinPointStaticPart.getSignature() + ", "
	    		+ thisJoinPointStaticPart.getSourceLocation().getLine();
	    System.out.println(info);
	    System.out.println("[END] " + thisJoinPointStaticPart.getSourceLocation().getFileName());
	}
}
