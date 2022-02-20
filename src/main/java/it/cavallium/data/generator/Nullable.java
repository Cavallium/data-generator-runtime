package it.cavallium.data.generator;

public class Nullable<T> {

	private static final long serialVersionUID = 1L;
	private static final Nullable<?> NULL = new Nullable<>(null);

	private final T value;

	public Nullable(T value) {
		this.value = value;
	}

	public static <T> Nullable<T> of(T value) {
		if (value == null) {
			throw new NullPointerException();
		} else {
			return new Nullable<>(value);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> Nullable<T> ofNullable(T value) {
		if (value == null) {
			return (Nullable<T>) NULL;
		} else {
			return new Nullable<>(value);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> Nullable<T> empty() {
		return (Nullable<T>) NULL;
	}

	public boolean isEmpty() {
		return value == null;
	}

	public boolean isPresent() {
		return value != null;
	}

	@org.jetbrains.annotations.NotNull
	public T get() {
		if (value == null) {
			throw new NullPointerException();
		} else {
			return value;
		}
	}

	@org.jetbrains.annotations.Nullable
	public T getNullable() {
		return value;
	}
}
