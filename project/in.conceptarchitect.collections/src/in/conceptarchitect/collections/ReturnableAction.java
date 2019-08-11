package in.conceptarchitect.collections;

public interface ReturnableAction<I, O> extends Action<I> {

	default O result() {
		return null;
	}
}

