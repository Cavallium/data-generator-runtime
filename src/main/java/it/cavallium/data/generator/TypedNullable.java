package it.cavallium.data.generator;

import org.jetbrains.annotations.NotNull;

public interface TypedNullable<T> extends NativeNullable<T> {

	@NotNull
	T get() throws NullPointerException;
}
