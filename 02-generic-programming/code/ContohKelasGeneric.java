public class ContohKelasGeneric<T> {

	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}

}

