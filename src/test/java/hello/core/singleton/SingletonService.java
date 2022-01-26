package hello.core.singleton;

import org.junit.jupiter.api.Test;

public class SingletonService {

    // static 영역에 객체를 1개만 생성
    private static final SingletonService instance = new SingletonService();

    // public으로 열어서 객체 인스턴스가 필요할 때 이 메서드를 통해서만 조회하도록 허용 
    public static  SingletonService getInstance() {
        return instance;
    }

    // 생성자 private 선언으로 외부에서 new 객체 생성 막음
    private SingletonService() {
    }
    
    public  void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

  





    }


