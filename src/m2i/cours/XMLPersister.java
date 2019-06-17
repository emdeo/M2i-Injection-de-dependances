package m2i.cours;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLPersister implements IPersister {

	public void persist(Object o, Class<?> to) {

		System.out.println(to.getTypeName());

		try {

			File file = new File("./personne.xml");

			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(to);

			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Write XML to file
			jaxbMarshaller.marshal(o, file);
			jaxbMarshaller.marshal(o, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
