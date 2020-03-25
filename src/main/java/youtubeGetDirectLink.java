import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class youtubeGetDirectLink {


	public youtubeGetDirectLink() {
	}

	public static void main(String[] args) {
//		youtube-dl -h;


//		new youtubeGetDirectLink().convertToPdf();
//		new youtubeGetDirectLink().getUnoVersion();
//		System.out.println(new youtubeGetDirectLink().getInfo("wSPHBGZohSg"));
		System.out.println(new youtubeGetDirectLink().convertToPdf());


	}

	public  String convertToPdf () {

		String gsonTest  = "{\n" +
				"  \"response\": {\n" +
				"    \"count\": 10307,\n" +
				"    \"items\": [\n" +
				"      {\n" +
				"        \"id\": 176514,\n" +
				"        \"from_id\": -114200945,\n" +
				"        \"owner_id\": -114200945,\n" +
				"        \"date\": 1506629224,\n" +
				"        \"marked_as_ads\": 0,\n" +
				"        \"post_type\": \"post\",\n" +
				"        \"text\": \"-я с разбитым сердцем сука,но я всё равно влюблённый.\",\n" +
				"        \"post_source\": {\n" +
				"          \"type\": \"api\"\n" +
				"        },\n" +
				"        \"comments\": {\n" +
				"          \"count\": 1,\n" +
				"          \"groups_can_post\": true,\n" +
				"          \"can_post\": 1\n" +
				"        },\n" +
				"        \"likes\": {\n" +
				"          \"count\": 103,\n" +
				"          \"user_likes\": 0,\n" +
				"          \"can_like\": 1,\n" +
				"          \"can_publish\": 1\n" +
				"        },\n" +
				"        \"reposts\": {\n" +
				"          \"count\": 3,\n" +
				"          \"user_reposted\": 0\n" +
				"        },\n" +
				"        \"views\": {\n" +
				"          \"count\": 1022\n" +
				"        }\n" +
				"      }\n" +
				"    ]\n" +
				"  }\n" +
				"}";

		Gson g = new Gson();
		Video video = g.fromJson(gsonTest, Video.class);
		System.out.println(video.getCount());
		return video.getCount();

	}


	public String getInfo(String videoId) {


		String videoUrl = "https://www.youtube.com/watch?v="+videoId;
		ProcessBuilder processBuilder = new ProcessBuilder("youtube-dl", "-e", "--get-duration",  "-gf","mp4",  videoUrl);
		//ProcessBuilder processBuilder = new ProcessBuilder("youtube-dl",  "--get-duration", "-e",  videoUrl);
		processBuilder.redirectErrorStream(true);
		Process process;
		try {
			process = processBuilder.start();
		} catch (IOException e) {

			return null;
		}
		StringBuilder processOutput = new StringBuilder();
		try {
			BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String readLine;
			while ((readLine = processOutputReader.readLine()) != null) {
				processOutput.append(readLine + System.lineSeparator());
			}
			process.waitFor();
		} catch (Exception e) {

		}
		return processOutput.toString().trim();
	}
	

}

