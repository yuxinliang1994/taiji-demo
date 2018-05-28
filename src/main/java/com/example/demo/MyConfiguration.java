package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	@Autowired
	ApplicationContext context;
	@Bean
	public CommandLineRunner runner() {
		return (args) -> {
			Scanner scan = new Scanner(System.in);
			int readInt = -1;
			while (readInt != 0) {
				System.out.print("1：签到\t2：查询\t3：统计\t0：退出\n请输入：");
				String read = scan.nextLine();
				readInt = Integer.parseInt(read);
				System.out.println("输入的是"+readInt);
				switch (readInt) {
				case 1:
					String name ="yuyuyu";
					System.out.println(context.getBean("qiandao"));
					break;
				case 2:
					List<User> list = (List<User>) context.getBean("chaxun");			
					for (User user : list) {
						System.out.println(user);
					}
					break;
				case 3:
					System.out.println("功能正在设计");
					break;
				default:
					System.out.println("输入有误");
					break;
				}
			}
		};
	}
	@Bean
	public String qiandao() {
		return "已签到";
	}
	@Bean
	public List<User> chaxun() {
		List<User> list =new  ArrayList<User>();
		list.add(new User(1,"张三"));
		list.add(new User(2,"李四"));
		list.add(new User(3,"王二"));
		return list;
	}
}
