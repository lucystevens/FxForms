package uk.co.lukecmstevens.providers;

public class ProviderException extends RuntimeException {

	private static final long serialVersionUID = -1580856658708806138L;
	
	public ProviderException(Class<?> provider, Exception root){
		this(provider, root.getMessage());
	}
	
	public ProviderException(Class<?> provider, String message){
		super("Exception in provider: " + provider.getName() + ". Root cause: " + message);
	}

}
