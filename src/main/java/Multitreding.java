public class Multitreding extends Thread{
	public static void main(String[] args) {
//		Multitreding multitreding = new Multitreding();
//		multitreding.run();
	}
	@Override
	public void run() {
		System.out.println("I'm Thread! My name is " + getName());
	}
}
 class Main {

	public static void main(String[] args) {

		for (int i = 0; i < 15; i++) {

			Multitreding thread = new Multitreding();
			thread.start();
		}
	}
}
