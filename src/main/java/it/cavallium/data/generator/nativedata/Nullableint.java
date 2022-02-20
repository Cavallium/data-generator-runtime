package it.cavallium.data.generator.nativedata;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Nullableint implements Serializable, IGenericNullable {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final Nullableint NULL = new Nullableint(null);

	private final Integer value;

	public Nullableint(Integer value) {
		this.value = value;
	}

	public static Nullableint of(int value) {
		return new Nullableint(value);
	}

	public static Nullableint ofNullable(@Nullable Integer value) {
		if (value == null) {
			return NULL;
		} else {
			return new Nullableint(value);
		}
	}

	public static Nullableint empty() {
		return NULL;
	}

	public boolean isEmpty() {
		return value == null;
	}

	public boolean isPresent() {
		return value != null;
	}

	public int get() {
		if (value == null) {
			throw new NullPointerException();
		} else {
			return value;
		}
	}

	public int orElse(int defaultValue) {
		if (value == null) {
			return defaultValue;
		} else {
			return value;
		}
	}

	@Override
	public Integer $getNullable() {
		return this.getNullable();
	}

	@Nullable
	public Integer getNullable() {
		return value;
	}

	public int getNullable(int defaultValue) {
		return value == null ? defaultValue : value;
	}

	@NotNull
	@Override
	public Nullableint clone() {
		if (value != null) {
			return Nullableint.of(value);
		} else {
			return Nullableint.empty();
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
		var that = (Nullableint) o;
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
