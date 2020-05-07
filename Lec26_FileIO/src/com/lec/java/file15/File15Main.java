package com.lec.java.file15;

import java.io.File;

public class File15Main {

	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		// current working directory : 현재작업경로
		String curWorkingDir = System.getProperty("user.dir");
		System.out.println("현재 작업 폴더: " + curWorkingDir);
		
		System.out.println();
		// 현재 작업 디렉토리의 파일 리스트 출력
		// File 클래스: 파일(txt, doc, ...) 객체 또는 디렉토리(폴더) 객체
		File curDir = new File(curWorkingDir);   // 현재 작업 디렉토리 객체
		File[] list = curDir.listFiles();  // listFiles() : 디렉토리 안에 있는 '파일' 과 '디렉토리' 를 File배열로 리턴
		
		System.out.println(list.length);   // '파일' 과 '디렉토리' 의 개수
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) { 
				// isDirectory(): File 객체가 디렉토리이면 true 리턴
				// isFile(): File 객체가 파일이면 true 리턴
				System.out.print("DIR\t");
			} else {
				System.out.print("FILE\t");
			}
			System.out.println(list[i].getName());
		}
		
		
		System.out.println();
		
		//절대경로
		String tempDirPath=System.getProperty("user.dir")+File.separator+"temp";
		System.out.println(tempDirPath);
		
		// 디렉토리의 내용 출력, enhanced for 문 이용
		File tempDir=new File("temp");
		File[] list2 = tempDir.listFiles();
        for(File f : list2) {      
            if(f.isFile()) {
                System.out.print("file"+"\t");
            } else {
                System.out.print("dir"+"\t");
            }
            System.out.print(f.getName()+"\t");
            System.out.println(f.length());
        }        
		System.out.println();
		// 파일 하나에 대한 정보
		// TODO
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end File11Main

















