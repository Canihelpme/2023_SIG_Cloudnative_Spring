package SiG.demo.UserService;

//6
public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //static 영역에 올라가서 하나만 존재하게 됨
    //컴파일 시 객체를 1개 생성해서 instance의 참조변수에 주입

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }
    //private 제어자로 아무도 SingletonService를 생성할 수 없도록 막음

    public void logic(){
        System.out.println(" 싱글톤 인스턴스! ");
    }

}
