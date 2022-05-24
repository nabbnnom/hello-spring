package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
	
	private String url;

	public NetworkClient() {
		System.out.println("������ ȣ��, url = " + url);		
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	//���� ���۽� ȣ��
	public void connect() {
		System.out.println("connect: " + url);
	}
	
	//���� ����� ȣ��
	public void disconnect() {
		System.out.println("disconnect: " + url);
	}
	
	public void call(String message) {
		System.out.println("call: " + url + " message = " + message);
	}

	@PostConstruct
	public void init() {
		System.out.println("NetworkClient.init");
		
		connect();
		call("�ʱ�ȭ ���� �޼���");
	}

	@PreDestroy
	public void close() {
		System.out.println("NetworkClient.close");
		
		disconnect();
	}

}
