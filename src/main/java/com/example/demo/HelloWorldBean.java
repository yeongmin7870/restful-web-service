package com.example.demo;

// lombok 으로 인해 getter , setter, toString등등 필요한 생성자나 메소드들을 만들어준다.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lobok 선언
@AllArgsConstructor //생성자 자동으로 생성하게 도와줌
@NoArgsConstructor
public class HelloWorldBean {
    private String messge;

}
