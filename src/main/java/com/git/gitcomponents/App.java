package com.git.gitcomponents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



/**
 * Hello world!
 *
 */
@SpringBootApplication
@EntityScan("com.git.gitcomponents.NetClientGet")
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
    }
}
