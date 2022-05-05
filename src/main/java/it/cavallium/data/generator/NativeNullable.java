package it.cavallium.data.generator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface NativeNullable<T> {

	boolean isEmpty();

	boolean isPresent();

	@NotNull
	T orElse(@NotNull T defaultValue);

	@NotNull NativeNullable<T> or(@NotNull NativeNullable<? extends T> fallback);

	@Nullable
	T getNullable();

	@Nullable
	T getNullable(@Nullable T defaultValue);
}
