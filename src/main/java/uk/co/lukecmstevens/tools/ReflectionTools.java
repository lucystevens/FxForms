package uk.co.lukecmstevens.tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import uk.co.lukecmstevens.providers.ProviderException;

public class ReflectionTools {
	
	@SuppressWarnings("unchecked")
	public <T> T[] getEnumValues(Class<T> c){
		try {
			Method values = c.getMethod("values");
			return (T[]) values.invoke(null);
		} catch (Exception e) {
			throw new ProviderException(this.getClass(), e);
		}
	}
	
	public <T> T newInstance(Class<T> c) throws ReflectiveOperationException{
		Constructor<T> con = c.getDeclaredConstructor();
		return con.newInstance();
	}

}
