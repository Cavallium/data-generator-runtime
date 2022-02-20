package it.cavallium.data.generator.nativedata;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NullableString implements Serializable, IGenericNullable {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final NullableString NULL = new NullableString(null);

	private final String value;

	public NullableString(String value) {
		this.value = value;
	}

	@SuppressWarnings("ConstantConditions")
	public static NullableString of(@NotNull String value) {
		if (value == null) {
			throw new NullPointerException();
		} else {
			return new NullableString(value);
		}
	}

	public static NullableString ofNullable(@Nullable String value) {
		if (value == null) {
			return NULL;
		} else {
			return new NullableString(value);
		}
	}

	public static NullableString ofNullableBlank(@Nullable String value) {
		if (value == null || value.isBlank()) {
			return NULL;
		}
		return new NullableString(value);
	}

	public static NullableString empty() {
		return NULL;
	}

	public boolean isEmpty() {
		return value == null;
	}

	public boolean isPresent() {
		return value != null;
	}

	public boolean isContentful() {
		return value != null && !value.isBlank();
	}

	@NotNull
	public String get() {
		if (value == null) {
			throw new NullPointerException();
		} else {
			return value;
		}
	}

	public String orElse(String defaultValue) {
		if (value == null) {
			return defaultValue;
		} else {
			return value;
		}
	}

	@Override
	public String $getNullable() {
		return this.getNullable();
	}

	@Nullable
	public String getNullable() {
		return value;
	}

	@NotNull
	public String getNullable(String defaultValue) {
		return value == null ? defaultValue : value;
	}

	@NotNull
	@Override
	public NullableString clone() {
		if (value != null) {
			return NullableString.of(value);
		} else {
			return NullableString.empty();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		var that = (NullableString) o;
		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		if (value == null) return "null";
		return "" + value;
	}
}
