package hello.core.singleton;

public class SingletonService {
	
	//1. static ������ ��ü�� �� 1���� �����صд�.
	private static SingletonService instance = new SingletonService();
	
	//2. public ���� ��� ��ü �ν��Ͻ��� �ʿ��ϸ� static �޼��带 ���ؼ��� ��ȸ�ϵ��� ����Ѵ�.
	public static SingletonService getInstance() {
		return instance;
	}
	
	//3. �����ڸ� private ���� �����ؼ� �ܺο��� new Ű���带 ����� ��ü ������ ���ϰ� ���´�.
	private SingletonService() {
		
	}
	
	public void logic() {
		System.out.println("�̱��� ��ü ���� ȣ��");
	}

}
