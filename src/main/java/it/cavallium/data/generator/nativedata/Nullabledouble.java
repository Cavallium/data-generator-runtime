package it.cavallium.data.generator.nativedata;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Nullabledouble implements Serializable, IGenericNullable {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final Nullabledouble NULL = new Nullabledouble(null);

	private final Double value;

	public Nullabledouble(Double value) {
		this.value = value;
	}

	public static Nullabledouble of(double value) {
		return new Nullabledouble(value);
	}

	public static Nullabledouble ofNullable(@Nullable Double value) {
		if (value == null) {
			return NULL;
		} else {
			return new Nullabledouble(value);
		}
	}

	public static Nullabledouble ofNullableNumber(@Nullable Number value) {
		if (value == null) {
			return NULL;
		} else {
			return new Nullabledouble(value.doubleValue());
		}
	}

	public static Nullabledouble empty() {
		return NULL;
	}

	public boolean isEmpty() {
		return value == null;
	}

	public boolean isPresent() {
		return value != null;
	}

	public double get() {
		if (value == null) {
			throw new NullPointerException();
		} else {
			return value;
		}
	}

	public double orElse(double defaultValue) {
		if (value == null) {
			return defaultValue;
		} else {
			return value;
		}
	}

	@Override
	public Double $getNullable() {
		return this.getNullable();
	}

	@Nullable
	public Double getNullable() {
		return value;
	}

	public double getNullable(double defaultValue) {
		return value == null ? defaultValue : value;
	}

	@NotNull
	@Override
	public Nullabledouble clone() {
		if (value != null) {
			return Nullabledouble.of(value);
		} else {
			return Nullabledouble.empty();
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
		var that = (Nullabledouble) o;
		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return value == null ? 0 : value.hashCode();
	}

	@Override
	public String toString() {
		if (value == null) return "null";
		return "" + value;
	}
}
