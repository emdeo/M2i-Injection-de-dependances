package m2i.cours;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONPersister implements IPersister {

	@Override
	public void persist(Object p, Class<?> to) {

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

		System.out.println("Sauvegarde au format JSON : " + gson.toJson(p));
	}

}
