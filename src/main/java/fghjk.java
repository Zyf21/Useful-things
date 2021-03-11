import de.micromata.opengis.kml.v_2_2_0.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashSet;
import java.util.List;

public class fghjk {
	public static void main(final String[] args) throws JAXBException {

		HashSet<String> states = new HashSet<String>();
		states.add("Germany");
		states.add("France");
		states.add("Italy");
		states.add("Italy");
		states.add("3434");

		for(String state : states){

			System.out.println(state);
		}


//		JAXBContext jc = JAXBContext.newInstance(Kml.class);
//		Unmarshaller u = jc.createUnmarshaller();
//		Kml kml = (Kml) u.unmarshal(new File("district.kml"));
//
//		final Document document = (Document)kml.getFeature();
//
//		Folder folder2 = (Folder) document.getFeature().get(0);
//		Placemark placemark2 = (Placemark) folder2.getFeature().get(0);
//		System.out.println(placemark2.getName());
//
//		Folder folder = (Folder) document.getFeature().get(1);
//		Placemark placemark = (Placemark) folder.getFeature().get(0);
//		LineString lineString = (LineString) placemark.getGeometry();
//
//		List<Coordinate> coordinates = lineString.getCoordinates();
//		for (Coordinate coordinate : coordinates) {
//			System.out.println(coordinate.getLongitude());
//			System.out.println(coordinate.getLatitude());
//
//		}


		JAXBContext jc = JAXBContext.newInstance(Kml.class);
		Unmarshaller u = jc.createUnmarshaller();
		Kml kml = (Kml) u.unmarshal(new File("zahra.kml"));

		final Document document = (Document)kml.getFeature();

//		Folder folder2 = (Folder) document.getFeature().get(0);
		Placemark placemark2 = (Placemark) document.getFeature().get(0);
		System.out.println(placemark2.getName());
		Point point =(Point)placemark2.getGeometry();
		List<Coordinate> coordinatesp = point.getCoordinates();
		Coordinate coordinatePoint = coordinatesp.get(0);
		System.out.println("333 "+coordinatePoint.getLatitude());
		System.out.println("333 "+coordinatePoint.getLongitude());


//		Folder folder = (Folder) document.getFeature().get(1);
		Placemark placemark = (Placemark) document.getFeature().get(1);
		LineString lineString = (LineString) placemark.getGeometry();

		List<Coordinate> coordinates = lineString.getCoordinates();
		for (Coordinate coordinate : coordinates) {
			System.out.println(coordinate.getLongitude());
			System.out.println(coordinate.getLatitude());

		}

	}

	public Double saveGeo (String coordinate){
		String str = coordinate.replace(',', '.');
		return Double.valueOf(str);
	}


}
