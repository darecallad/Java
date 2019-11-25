package learn;

public class Coupling {

	public void natigate(String address) {
		String ip = findIpAddress(address);
		String html = sendHttpRequest(ip);
		System.out.println(html);
	}

	private String sendHttpRequest(String ip) {
		// TODO Auto-generated method stub
		return "<html></html>";
	}

	private String findIpAddress(String address) {
		// TODO Auto-generated method stub
		return "1277.0.01.2";
	}
}
